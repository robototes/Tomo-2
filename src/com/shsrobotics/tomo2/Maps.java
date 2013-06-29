package com.shsrobotics.tomo2;

import edu.wpi.first.wpilibj.*;
import com.shsrobotics.library.Button;
import com.shsrobotics.library.JoystickButton;


/**
 * this interface contains subclasses that hold all of the values and maps for the robot.  everything needs to be a public static and final datatype.
 */
public interface Maps {
      //universal constants
      public static final Relay.Value ON = Relay.Value.kForward, OPEN = Relay.Value.kForward;
      public static final Relay.Value OFF = Relay.Value.kOff, CLOSED = Relay.Value.kOff;

      public static final Joystick joystick = new Joystick(1);

      /** ports on the robot */
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

      /** constants used in code */
      public class Constants {
	    public static final int flashRate = 4; // how often to flash (on -> off -> on) lights per second
	    public static final double flashCount = 4.0; // how many times to flash lights

	    public static final double driveCoordinateScale = 0.5; // factor to scale drive values
	    public static final double noDriveScaling = 1.0; // don't scale values when there is no scaling

	    public static final double noGyroscopeAngle = 0.0; // currently no gyroscope on robot
      }

      /** 
	   * shorthand variables for lines and columns of Driver Station Screen 
	   */
      public class Screen {
	    // lines on the driver station, each 21 char. in length, from top to bottom.
	    public static final DriverStationLCD.Line line1 = DriverStationLCD.Line.kMain6;
	    public static final DriverStationLCD.Line line2 = DriverStationLCD.Line.kUser2;
	    public static final DriverStationLCD.Line line3 = DriverStationLCD.Line.kUser3;
	    public static final DriverStationLCD.Line line4 = DriverStationLCD.Line.kUser4;
	    public static final DriverStationLCD.Line line5 = DriverStationLCD.Line.kUser5;
	    public static final DriverStationLCD.Line line6 = DriverStationLCD.Line.kUser6;

	    // each column represents one tab character
	    public static final int column1 = 1;
	    public static final int column2 = 5;
	    public static final int column3 = 9;
	    public static final int column4 = 13;
      }

      /** 
	   * Buttons.
      */
      public class Buttons {
	    public static final Button shootCannon = new JoystickButton(joystick, 1);
	    public static final Button lightsOn = new JoystickButton(joystick, 5);
	    public static final Button toggleLights = new JoystickButton(joystick, 10);
	    public static final Button fineControl = new JoystickButton(joystick, 2);
      }
}
