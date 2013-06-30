/*
 *	TEAM 2412
 *	BELLEVUE, WA
 *	JUNE 2013
 *	
 *	PROJECT LICENSE IN ROOT FOLDER.
 */

package com.shsrobotics.tomo2;


import com.shsrobotics.library.Screen;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Main extends IterativeRobot implements Maps, Hardware {

      public void robotInit() { // flash lights
		  new FlashLights().start();
		  
		  Cannon.compressor.start(); // start storing air
		  
		  SmartDashboard.putString("Status", "Ready to go!");
		  
      }

      public void teleopPeriodic() {
			Cannon.airRelease.set(Buttons.shootCannon.held()? OPEN : CLOSED); // if button held open air release valve, firing cannon
			
			lights.set(Buttons.lightsOn.held() ? ON : OFF); // lights on while button held
			lights.set(Buttons.toggleLights.pressed() ? !lights.getState() : lights.getState()); // on button press toggle lights
			
			double scalingFactor = Buttons.fineControl.held() ? 0.5 : 1.0; // scale to 1/2 speed while button held
			//							cubed inputs	and		scale
			double X = MathUtils.pow(joystick.getX(), 3) * scalingFactor;
			double Y = MathUtils.pow(joystick.getY(), 3) * scalingFactor;
			double Z = MathUtils.pow(joystick.getZ(), 3) * scalingFactor;
			
			drive.mecanumDrive_Cartesian(X, Y, Z, Constants.noGyroscopeAngle);
			
			updateDashboardAndScreen();
	  }

	private void updateDashboardAndScreen() {
		boolean charged = Cannon.compressor.getPressureSwitchValue();
		String airPressureUpdate = charged ? "FULLY CHARGED" : "NOT ENOUGH AIR PRESSURE";
		
		screen.println(Screen.line1, Screen.column1, airPressureUpdate);
		SmartDashboard.putBoolean("Fully Charged", charged);
		SmartDashboard.putString("Status", airPressureUpdate);
	}
}