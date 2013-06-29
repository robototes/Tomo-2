/*
 *	TEAM 2412
 *	BELLEVUE, WA
 *	JUNE 2013
 *	
 *	PROJECT LICENSE IN ROOT FOLDER.
 */

package com.shsrobotics.tomo2;


import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

public class Main extends IterativeRobot implements Maps, Hardware {

      public void robotInit() { // flash lights
		  lights.set(ON);
		  Timer.delay(0.5);
		  lights.set(OFF);
		  Timer.delay(0.5);
		  lights.set(ON);
		  Timer.delay(0.5);
		  lights.set(OFF);
      }

      public void teleopInit() {
		  Cannon.compressor.start();
	  }

      public void teleopPeriodic() {
			Cannon.airRelease.set(Buttons.shootCannon.held()? OPEN : CLOSED);
			
			lights.set(Buttons.lightsOn.held() ? ON : OFF);
			lights.set(Buttons.toggleLights.pressed() ? !lights.getState() : lights.getState());
			
			double scalingFactor = Buttons.fineControl.held() ? 0.5 : 1.0;
			double X = MathUtils.pow(joystick.getX(), 2) * scalingFactor;
			double Y = MathUtils.pow(joystick.getY(), 2) * scalingFactor;
			double Z = MathUtils.pow(joystick.getZ(), 2) * scalingFactor;
			
			drive.mecanumDrive_Cartesian(X, Y, Z, Constants.noGyroscopeAngle);
	  }
	  
	  public void disabledInit() {
		  Cannon.compressor.stop();
	  }
}