package com.shsrobotics.tomo2;


import edu.wpi.first.wpilibj.*;
import com.shsrobotics.library.Button;
import com.shsrobotics.library.GLOBAL;
import com.shsrobotics.library.JoystickButton;
import com.shsrobotics.library.joysticks.Extreme3DController;


/**
 * this interface contains subclasses that hold all of the values and maps for the robot.  everything needs to be a public static and final datatype.
 */
public interface Maps extends GLOBAL {
	public static final Joystick joystick = new Joystick(USB_1);

	/** Ports on the robot. */
	public class Robot {
	    public static final int frontLeftWheel = PWM_3;
	    public static final int rearLeftWheel = PWM_4;
	    public static final int frontRightWheel = PWM_1;
	    public static final int rearRightWheel = PWM_2;

	    public static final int lights = RELAY_1;

	    public static final int compressorRelay = RELAY_7;
	    public static final int pressureSwitch = DIGITAL_IO_1;

	    public static final int airCannon = RELAY_2;
	}

	/** Constants used in code. */
	public class Constants {
	    public static final int flashRate = 4; // how often to flash (on -> off -> on) lights per second
	    public static final int flashCount = 4; // how many times to flash lights

	    public static final double driveCoordinateScale = 0.5; // factor to scale drive values
	    public static final double normalScale = 1.0; // normal scaling
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
		public static final Button pulseCompressor = new JoystickButton(joystick, Extreme3DController.topBottomRight);
	}
}
