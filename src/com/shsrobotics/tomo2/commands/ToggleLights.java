package com.shsrobotics.tomo2.commands;

public class ToggleLights extends CommandBase {

      public ToggleLights() {
	    requires(lights);
      }

      protected void initialize() { }

      protected void execute() {
	    lights.toggle();
      }

      protected boolean isFinished() {
	    return true;
      }

      protected void end() { }

      protected void interrupted() { }
}
