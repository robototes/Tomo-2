/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shsrobotics.tomo2.subsystems;

import com.shsrobotics.tomo2.Maps;
import com.shsrobotics.tomo2.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem implements Maps {

      private RobotDrive drive = new RobotDrive(Robot.frontLeftWheel, Robot.rearLeftWheel, Robot.frontRightWheel, Robot.rearRightWheel);

      public void drive(double x, double y, double z) {

	    drive.mecanumDrive_Cartesian(x, y, z, Constants.gyroAngle);
      }

      public void initDefaultCommand() {
	   setDefaultCommand(new DriveWithJoystick());
      }
}
