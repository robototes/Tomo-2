
package com.shsrobotics.tomo2.commands;

import edu.wpi.first.wpilibj.Timer;

public class FireCannon extends CommandBase {

      public FireCannon() {
	    requires(airCannon);
	    setTimeout(1); // stop after 1 second
      }

      protected void initialize() {
	    if (!airCannon.isEnabled()) {
		  airCannon.enable();
	    }
	    if (airCannon.isOpen()) {
		  airCannon.unFire();
	    }
      }

      protected void execute() {
	    airCannon.fire();
      }

      protected boolean isFinished() {
	  return isTimedOut(); // stop after 1 second
      }

      protected void end() {
	    airCannon.unFire();
      }

      protected void interrupted() {
	    System.out.println("Firing interrupted after " + timeSinceInitialized() + " seconds.");
	    end();
      }
}
