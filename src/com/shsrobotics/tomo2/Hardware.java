package com.shsrobotics.tomo2;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * Hardware for robot.
 */
public interface Hardware extends Maps {
	public class Wheels {
		public static SpeedController frontLeft = new Jaguar(Robot.frontLeftWheel);
		public static SpeedController rearLeft = new Jaguar(Robot.rearLeftWheel);
		public static SpeedController rearRight = new Jaguar(Robot.rearRightWheel);
		public static SpeedController frontRight = new Jaguar(Robot.frontRightWheel);
	} 
	
	public class Cannon {
		public static Compressor compressor = new Compressor(Robot.pressureSwitch, Robot.compressorRelay);
		public static Relay airRelease = new Relay(Robot.airCannon);
	}
	
	public static Relay lights = new Relay(Robot.lights);
	public static RobotDrive drive = new RobotDrive(Wheels.frontLeft, Wheels.rearLeft, Wheels.rearRight, Wheels.frontRight);
        
        public static NetworkTable table = NetworkTable.getTable(Comm.tableName);
}
