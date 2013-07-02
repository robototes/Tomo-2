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

	public void robotInit() { // flash lights
		super.robotInit();
		
		new FlashLights().start();

		Cannon.compressor.start(); // start storing air

		SmartDashboard.putString("Status", "Ready to go!");
	}

	public void teleopPeriodic() {
		Cannon.airRelease.set(Buttons.shootCannon.held() ? OPEN : CLOSED); // if button held, open air release valve, firing cannon
		Cannon.compressor.setRelayValue(Buttons.pulseCompressor.held() ? ON : OFF); // if button held, force compressor to intake air

		lights.set(Buttons.lightsOn.held() ? ON : OFF); // lights on while button held
		lights.set(Buttons.toggleLights.pressed() ? !lights.getState() : lights.getState()); // on button press, toggle lights
		Buttons.flashLights.whenPressed(new FlashLights());

		Buttons.driveInSquare.whileHeld(new DriveInSquare());
		
		double scalingFactor = Buttons.fineControl.held() ? Constants.driveCoordinateScale : Constants.normalScale; // scale to 1/2 speed while button held
		//							cubed inputs	and		scale
		double X = MathUtils.pow(joystick.getX(), 3) * scalingFactor;
		double Y = MathUtils.pow(joystick.getY(), 3) * scalingFactor;
		double Z = MathUtils.pow(joystick.getZ(), 3) * scalingFactor;

		drive.mecanumDrive_Cartesian(X, Y, Z, noGyroscopeAngle);

		updateDashboardAndScreen();
	}

	private void updateDashboardAndScreen() {
		boolean charged = Cannon.compressor.getPressureSwitchValue();
		String airPressureUpdate = charged ? "FULLY CHARGED" : "NOT ENOUGH AIR PRESSURE";

		screen.println(Screen.line1, Screen.tab1, airPressureUpdate);
		SmartDashboard.putBoolean("Fully Charged", charged);
		SmartDashboard.putString("Status", airPressureUpdate);
	}
}