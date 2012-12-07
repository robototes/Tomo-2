package com.shsrobotics.tomo2.commands;

import com.shsrobotics.tomo2.Maps;

public class TurnLightsOn extends CommandBase implements Maps{

      public TurnLightsOn() {
	    requires(lights);
      }

      protected void initialize() {
	    lights.set(ON);
      }

      protected void execute() { }

      protected boolean isFinished() {
	    return false;
      }

      protected void end() {
	    lights.set(OFF);
      }

      protected void interrupted() {
	    lights.set(OFF);
      }
}
