package com.shsrobotics.tomo2;

import edu.wpi.first.wpilibj.*;
import com.shsrobotics.library.Button;
import com.shsrobotics.library.GLOBAL;
import com.shsrobotics.library.JoystickButton;
import com.shsrobotics.library.joysticks.Extreme3DController;

/**
 * this interface contains subclasses that hold all of the values and maps for
 * the robot. everything needs to be a public static and final datatype.
 */
public interface Maps extends GLOBAL {

    public static final IIR joystick = new IIR(USB_1, new IIR.Smoothing(30, 30, 20));
    public static final Relay.Value LEFT_ON = Relay.Value.kForward;
    public static final Relay.Value RIGHT_ON = Relay.Value.kReverse;
    public static final Relay.Value BOTH_ON = Relay.Value.kOn;

    public static final Timer timer = new Timer();

    public class Comm {

        public static final String charged = "charged";
        public static final String tableName = "DASHBOARD";
    }

    /**
     * Ports on the robot.
     */
    public class Robot {

        public static final int frontLeftWheel = PWM_1;
        public static final int rearLeftWheel = PWM_2;
        public static final int frontRightWheel = PWM_4;
        public static final int rearRightWheel = PWM_3;

        public static final int lights = RELAY_1;

        public static final int compressorRelay = RELAY_8;
        public static final int pressureSwitch = DIGITAL_IO_1;

        public static final int airCannon = RELAY_2;
    }

    /**
     * Constants used in code.
     */
    public class Constants {

        public static final int flashRate = 4; // how often to flash (on -> off -> on) lights per second
        public static final int flashCount = 4; // how many times to flash lights

        public static final double driveCoordinateScale = 0.5; // factor to scale drive values
        public static final double normalScale = 1.0; // normal scaling
        
        public static final double recoilInitial = -0.5; // initial recoil velocity
        public static final double recoilDecay = 0.25; // rate to decrease recoil (velocity/s)
    }

    /**
     * Buttons.
     */
    public class Buttons {

        public static final Button shootCannon = new JoystickButton(joystick, Extreme3DController.trigger);
        public static final Button leftLightOn = new JoystickButton(joystick, Extreme3DController.topBottomLeft);
        public static final Button rightLightOn = new JoystickButton(joystick, Extreme3DController.topBottomRight);
        public static final Button toggleLights = new JoystickButton(joystick, Extreme3DController.baseRearRight);
        public static final Button flashLights = new JoystickButton(joystick, Extreme3DController.topTopRight);
        public static final Button fineControl = new JoystickButton(joystick, Extreme3DController.side);
        public static final Button pulseCompressor = new JoystickButton(joystick, Extreme3DController.baseFrontRight);
    }
}
