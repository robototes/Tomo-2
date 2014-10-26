/*
 *	TEAM 2412
 *	BELLEVUE, WA
 *	JUNE 2013
 *	
 *	PROJECT LICENSE IN ROOT FOLDER.
 */
package com.shsrobotics.tomo2;

import com.shsrobotics.library.FRCRobot;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Main extends FRCRobot implements Hardware {
    
    boolean RECOIL = true;
    DriveType DRIVETYPE = DriveType.ALL_WHEELS;
    Location robot = new Location(0, 0);
    Location target = new Location(0, 0);

    public void robotInit() {
        super.robotInit(); // runs basic system check

        Cannon.compressor.start(); // start storing air
    }

    public void teleopPeriodic() {
        /*
         * DRIVING
         */
        double scalingFactor = Buttons.fineControl.held() ? Constants.driveCoordinateScale : Constants.normalScale; // scale to 1/2 speed while button held
        //	-	-	cubed inputs	and	scale
        double X = MathUtils.pow(joystick.outputX(), 3) * scalingFactor;
        double Y = MathUtils.pow(joystick.outputY(), 3) * scalingFactor;
        double Z = MathUtils.pow(joystick.outputZ(), 3) * scalingFactor;

        /*
         * CANNON
         */
        // if button held fire cannon
        if (Buttons.shootCannon.pressed() && RECOIL) {
            timer.stop();
            timer.reset();
            timer.start();
        }
        if (Buttons.shootCannon.held()) {
            Cannon.airRelease.set(OPEN); // fire
            if (RECOIL) {
                X = 0;
                Y = (Constants.recoilInitial - Constants.recoilDecay * timer.get()); // recoil
                Z = 0;
            }
        } else {
            Cannon.airRelease.set(CLOSED);
        }

        /*
         * LIGHTS
         */
        lights.set(Buttons.leftLightOn.held() ? LEFT_ON : OFF); // lights on while button held
        lights.set(Buttons.rightLightOn.held() ? RIGHT_ON : OFF); // lights on while button held
        // on button press, toggle lights
        if (Buttons.toggleLights.pressed()) {
            lights.set(lights.get() == ON ? OFF : ON);
        }
        Buttons.flashLights.whenPressed(new FlashLights());

        /*
         * EXECUTE DRIVE
         */
        drive.mecanumDrive_Cartesian(X, Y, Z, noGyroscope);

        /*
         * UPDATE DRIVER DISPLAY
         */
        updateDashboardAndScreen();
    }

    private void updateDashboardAndScreen() {
        boolean charged = Cannon.compressor.getPressureSwitchValue();
        String airPressureUpdate = charged ? "FULLY CHARGED" : "NOT ENOUGH AIR PRESSURE";

        screen.println(Screen.line1, Screen.tab1, airPressureUpdate);
        SmartDashboard.putBoolean("Fully Charged", charged);
        SmartDashboard.putString("Status", airPressureUpdate);

        table.putBoolean(Comm.charged, charged);
        
        RECOIL = table.getBoolean(Comm.recoil, true);
        switch ((int) table.getNumber(Comm.driveType, 0)) {
            case 0:
                DRIVETYPE = DriveType.ALL_WHEELS;
                break;
            case 1:
                DRIVETYPE = DriveType.FRONT_WHEELS;
                break;
            case 2:
                DRIVETYPE = DriveType.REAR_WHEELS;
                break;
            default:
                DRIVETYPE = DriveType.ALL_WHEELS;
                break;
        }
        robot.x = table.getNumber(Comm.robotX, robot.x);
        robot.y = table.getNumber(Comm.robotY, robot.y);
        target.x = table.getNumber(Comm.targetX, target.x);
        target.y = table.getNumber(Comm.targetY, target.y);
    }
    
    static class DriveType {
        public static final DriveType ALL_WHEELS = new DriveType(0);
        public static final DriveType FRONT_WHEELS = new DriveType(1);
        public static final DriveType REAR_WHEELS = new DriveType(2);
        
        int t;
        
        private DriveType(int t) {
            this.t = t;
        }
    }
}
