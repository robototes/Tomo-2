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

	public void robotInit() {
		super.robotInit(); // runs basic system check
		
		new FlashLights().start(); // flash lights to show readiness (and check lights)

		Cannon.compressor.start(); // start storing air

		SmartDashboard.putString("Status", "Ready to go!");
	}

	public void teleopPeriodic() {
		Cannon.airRelease.set(Buttons.shootCannon.held() ? OPEN : CLOSED); // if button held, open air release valve, firing cannon
		Cannon.compressor.setRelayValue(Buttons.pulseCompressor.held() ? ON : OFF); // if button held, force compressor to intake air

		lights.set(Buttons.leftLightOn.held() ? LEFT_ON : OFF); // lights on while button held
		lights.set(Buttons.rightLightOn.held() ? RIGHT_ON : OFF); // lights on while button held
                // on button press, toggle lights
                if (Buttons.toggleLights.pressed()) {
                    lights.set(lights.get() == ON ? OFF : ON); 
                }
		Buttons.flashLights.whenPressed(new FlashLights());

		double scalingFactor = Buttons.fineControl.held() ? Constants.driveCoordinateScale : Constants.normalScale; // scale to 1/2 speed while button held
		//	-	-	cubed inputs	and	scale
		double X = MathUtils.pow(joystick.getX(), 3) * scalingFactor;
		double Y = MathUtils.pow(joystick.getY(), 3) * scalingFactor;
		double Z = MathUtils.pow(joystick.getZ(), 3) * scalingFactor;

		drive.mecanumDrive_Cartesian(X, Y, Z, noGyroscope);

		updateDashboardAndScreen();
	}

	private void updateDashboardAndScreen() {
		boolean charged = Cannon.compressor.getPressureSwitchValue();
		String airPressureUpdate = charged ? "FULLY CHARGED" : "NOT ENOUGH AIR PRESSURE";

		screen.println(Screen.line1, Screen.tab1, airPressureUpdate);
		SmartDashboard.putBoolean("Fully Charged", charged);
		SmartDashboard.putString("Status", airPressureUpdate);
                
                table.putBoolean(Comm.charged, charged);
	}
}