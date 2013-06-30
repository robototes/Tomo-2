package com.shsrobotics.tomo2;

import com.shsrobotics.library.Task;
import edu.wpi.first.wpilibj.Timer;

/**
 * Flashes lights.
 * @author Team 2412 <first.robototes.com, github.com/robototes>
 */
public class FlashLights extends Task implements Maps, Hardware {

	protected void initialize() {
		for (int i = 0; i < Constants.flashCount; i++) {
			lights.set(ON);
			Timer.delay(1 / Constants.flashRate);
			lights.set(OFF);
			Timer.delay(1 / Constants.flashRate);
		}
	}

	protected void execute() { }

	protected boolean isFinished() {
		return true;
	}

	protected void end() { }
}
