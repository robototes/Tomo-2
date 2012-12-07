package com.shsrobotics.tomo2.commands;

import com.shsrobotics.tomo2.OI;
import com.shsrobotics.tomo2.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public abstract class CommandBase extends Command {

    public static OI oi;

    public static AirCannon airCannon = new AirCannon();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Lights lights = new Lights();

    public static void init() {
        oi = new OI(); // REQUIRED
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
