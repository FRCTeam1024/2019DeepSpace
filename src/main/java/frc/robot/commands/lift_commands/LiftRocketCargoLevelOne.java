/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift_commands;


import frc.robot.Level;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LiftRocketCargoLevelOne extends CommandGroup {
  public LiftRocketCargoLevelOne() {
    addSequential(new MoveLiftPID(Level.ROCKET_CARGO_1));
  }
}
