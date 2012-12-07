package com.shsrobotics.tomo2;

import edu.wpi.first.wpilibj.Joystick;

public class SmoothJoystick extends Joystick {

      private double oldX = 0;
      private double oldY = 0;
      private double oldZ = 0;
      private boolean[] beingDebounced;
      private boolean[] state;


      public SmoothJoystick(final int port) {
	    super(port);
      }

      public double getSmoothX() {
	    double tbr = ( oldX + getX() ) / 2;
	    oldX = getX();
	    return tbr;
      }

      public double getSmoothY() {
	    double tbr = ( oldY + getY() ) / 2;
	    oldY = getY();
	    return tbr;
      }

      public double getSmoothZ() {
	    double tbr = ( oldZ + getZ() ) / 2;
	    oldZ = getZ();
	    return tbr;
      }

      public double getSmoothTwist() {
	    return getSmoothZ();
      }

      public boolean getDebouncedButton (int button) {
	    boolean current = getRawButton(button);
	    if (current && !beingDebounced[button]) {
		  beingDebounced[button] = true;
		  state[button] = true;
	    } else if (current && beingDebounced[button]) {
		  state[button] = false;
	    } else if (!current && beingDebounced[button]) {
		  beingDebounced[button] = false;
		  state[button] = false;
	    } else {
		  state[button] = false;
	    }

	    return state[button];
      } // END getDebouncedButton()

} // END class SmoothJoystick