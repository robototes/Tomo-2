package com.shsrobotics.tomo2.commands;

public class DisableCannon extends CommandBase {

      public DisableCannon() {
	    requires(airCannon);
	    setInterruptible(false);
      }

      protected void initialize() {
	    airCannon.disable();
      }

      protected void execute() { }

      protected boolean isFinished() {
	    return true;
      }

      protected void end() { }

      protected void interrupted() { }
}
