
package com.shsrobotics.tomo2.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.shsrobotics.tomo2.Maps;
import com.shsrobotics.tomo2.commands.EnableCannon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;

public class AirCannon extends Subsystem implements Maps {

      private Compressor airCompressor = new Compressor(Robot.compressorRelay, Robot.compressorModule);
      private Relay airCannon = new Relay(Robot.airCannon);
      private boolean open = false;
      private boolean isEnabled = false;

      public void enable() {
	    airCompressor.start();
	    isEnabled = true;
      }
      public void disable() {
	    airCompressor.stop();
	    isEnabled = false;
      }

      public void fire() {
	    airCannon.set(ON);
	    open = true;
      }
      public void unFire() {
	    airCannon.set(OFF);
	    open = false;
      }

      public boolean isOpen() {
	    return open;
      }
      public boolean isEnabled() {
	    return isEnabled;
      }

      public void initDefaultCommand() {
	    setDefaultCommand(new EnableCannon());
      }
}

