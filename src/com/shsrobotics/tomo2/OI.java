
package com.shsrobotics.tomo2;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import com.shsrobotics.tomo2.commands.*;

/** Operator Interface class connects buttons, switches, and joysticks to commands and values on the robot */
public class OI implements Maps {

    public OI() {
	  Buttons.shootCannon.whenPressed(new FireCannon());
	  Buttons.enableCannon.whenPressed(new EnableCannon());
	  Buttons.disableCannon.whenPressed(new DisableCannon());
	  Buttons.toggleLights.whenPressed(new ToggleLights());
	  Buttons.flashLights.whenPressed(new FlashLights());
	  Buttons.lightsOn.whileHeld(new TurnLightsOn());
    }

    public double getX() {
	  double driveCoordinateScaling = joystick.getRawButton(Buttons.fineControl) ? Constants.driveCoordinateScale : Constants.noDriveScaling;
	  return joystick.getX() * driveCoordinateScaling;
    }
    public double getY() {
	  double driveCoordinateScaling = joystick.getRawButton(Buttons.fineControl) ? Constants.driveCoordinateScale : Constants.noDriveScaling;
	  return joystick.getY() * driveCoordinateScaling;
    }
    public double getZ() {
	  double driveCoordinateScaling = joystick.getRawButton(Buttons.fineControl) ? Constants.driveCoordinateScale : Constants.noDriveScaling;
	  return joystick.getZ() * driveCoordinateScaling;
    }
}

