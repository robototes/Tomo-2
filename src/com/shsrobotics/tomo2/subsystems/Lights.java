
package com.shsrobotics.tomo2.subsystems;

import com.shsrobotics.tomo2.Maps;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem implements Maps {

      private Relay lights = new Relay(Robot.lights);
      private boolean lightsOn = false;

      public void toggle() {
	    lightsOn = !lightsOn;
	    lights.set(lightsOn ? ON : OFF);
      }

      public void set(boolean value) {
	    lightsOn = value;
	    lights.set(lightsOn ? ON : OFF);
      }
      public void set(Relay.Value value) {
	    lightsOn = (value == ON) ? true : false;
	    lights.set(value);
      }

      public void initDefaultCommand() { }
}
