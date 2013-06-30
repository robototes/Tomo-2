package com.shsrobotics.tomo2;

import edu.wpi.first.wpilibj.*;
import com.shsrobotics.library.Button;
import com.shsrobotics.library.GBL;
import com.shsrobotics.library.JoystickButton;
import com.shsrobotics.library.joysticks.Extreme3DController;


/**
 * this interface contains subclasses that hold all of the values and maps for the robot.  everything needs to be a public static and final datatype.
 */
public interface Maps {
	//universal constants
	public static final Relay.Value 
		ON = Relay.Value.kForward, 
		OFF = Relay.Value.kOff, 
		OPEN = Relay.Value.kForward,
		CLOSED = Relay.Value.kOff;

	public static final Joystick joystick = new Joystick(GBL.USB_1);

	/** Ports on the robot. */
	public class Robot {
	    public static final int frontLeftWheel = 3;
	    public static final int rearLeftWheel = 4;
	    public static final int frontRightWheel = 1;
	    public static final int rearRightWheel = 2;

	    public static final int lights = 1;

	    public static final int compressorRelay = 7;
	    public static final int pressureSwitch = 1;

	    public static final int airCannon = 2;
	}

	/** Constants used in code. */
	public class Constants {
	    public static final int flashRate = 4; // how often to flash (on -> off -> on) lights per second
	    public static final double flashCount = 4.0; // how many times to flash lights

	    public static final double driveCoordinateScale = 0.5; // factor to scale drive values
	    public static final double noDriveScaling = 1.0; // don't scale values when there is no scaling

	    public static final double noGyroscopeAngle = 0.0; // currently no gyroscope on robot
	}


	/** 
	 * Buttons.
	*/
	public class Buttons {
	    public static final Button shootCannon = new JoystickButton(joystick, Extreme3DController.trigger);
	    public static final Button lightsOn = new JoystickButton(joystick, Extreme3DController.topBottomLeft);
	    public static final Button toggleLights = new JoystickButton(joystick, Extreme3DController.baseRearRight);
	    public static final Button flashLights = new JoystickButton(joystick, Extreme3DController.topTopRight);
	    public static final Button fineControl = new JoystickButton(joystick, Extreme3DController.side);
	}
}
