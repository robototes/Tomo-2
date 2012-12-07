package com.shsrobotics.tomo2.commands;

public class DriveWithJoystick extends CommandBase {

      public DriveWithJoystick() {
	    requires(driveTrain);
	    setInterruptible(false);
      }

      protected void initialize() { }

      protected void execute() {
	    driveTrain.drive(oi.getX(), oi.getY(), oi.getZ());
      }

      protected boolean isFinished() {
	    return false;
      }

      protected void end() { }

      protected void interrupted() { }
}
