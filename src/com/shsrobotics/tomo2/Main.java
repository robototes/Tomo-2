/*----------------------------------------------------------------------------*/
/* TEAM 2412					                              */
/* BSD LICENSE IN ROOT FOLDR                                                  */
/*----------------------------------------------------------------------------*/

package com.shsrobotics.tomo2;


import com.shsrobotics.tomo2.commands.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Main extends IterativeRobot {

      public void robotInit() {
	    CommandBase.init();
      }

      public void autonomousInit() { }

      public void autonomousPeriodic() {
	    Scheduler.getInstance().run();
      }

      public void teleopInit() { }

      public void teleopPeriodic() {
	      Scheduler.getInstance().run();
      }
}
