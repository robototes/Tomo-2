package com.shsrobotics.tomo2.commands;

import com.shsrobotics.tomo2.Maps;
import edu.wpi.first.wpilibj.Timer;

public class FlashLights extends CommandBase implements Maps {
      boolean isFinished;
      Timer timer;
      int interval;
      int centiseconds;
      double currentFlashCount;

      public FlashLights() {
	    requires(lights);
	    setInterruptible(false);
	    timer = new Timer();
	    interval = (int) (1e2 / (2*Constants.flashRate)); // length of flash in hundredths of a second
      }

      protected void initialize() {
	    lights.set(OFF);
	    currentFlashCount = 0.0;
	    isFinished = false;
	    timer.start();
      }

      protected void execute() {
	    centiseconds = (int) (timer.get() / 1e4); // timer value in hundredths of a second
	    if (centiseconds % interval < 5) { // within 0.05 seconds of flash change
		  lights.toggle();
		  currentFlashCount += 0.5; // each change is 1/2 of a flash
	    }
	    if (currentFlashCount == Constants.flashCount) { // when done
		  isFinished = true;
		  timer.stop();
		  timer.reset();
	    }
      }

      protected boolean isFinished() {
	    return isFinished;
      }

      protected void end() { }

      protected void interrupted() { }
}
