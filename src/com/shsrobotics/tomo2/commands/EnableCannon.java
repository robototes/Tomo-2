package com.shsrobotics.tomo2.commands;

public class EnableCannon extends CommandBase {

      public EnableCannon() {
	    requires(airCannon);
	    setInterruptible(false);
      }

      protected void initialize() {
	    airCannon.enable();
      }

      protected void execute() { }

      protected boolean isFinished() {
	    return true;
      }

      protected void end() { }

      protected void interrupted() { }
}
