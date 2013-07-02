package com.shsrobotics.tomo2;

import com.shsrobotics.library.Task;
import edu.wpi.first.wpilibj.Timer;

/**
 * Drives robot in square, always facing outward.
 * @author Team 2412 <first.robototes.com, github.com/robototes>
 */
public class DriveInSquare extends Task implements Hardware {

	protected void initialize() {
		setTimeout(4000 * 10); // maximum 10 loops * 4000 milliseconds a loop
	}

	protected void execute() {
		drive.mecanumDrive_Cartesian(-1.0, 0.0, Constants.powerToTurnInFourSeconds, noGyroscopeAngle);
		Timer.delay(1); // seconds
		drive.mecanumDrive_Cartesian(0.0, -1.0, Constants.powerToTurnInFourSeconds, noGyroscopeAngle);
		Timer.delay(1); // seconds
		drive.mecanumDrive_Cartesian(1.0, 0.0, Constants.powerToTurnInFourSeconds, noGyroscopeAngle);
		Timer.delay(1); // seconds
		drive.mecanumDrive_Cartesian(0.0, 1.0, Constants.powerToTurnInFourSeconds, noGyroscopeAngle);
		Timer.delay(1); // seconds
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drive.mecanumDrive_Cartesian(0.0, 0.0, 0.0, noGyroscopeAngle);
	}
	
}
