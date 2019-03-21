/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift_commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LiftRocketCargoLevelThreePID extends CommandGroup {
  public LiftRocketCargoLevelThreePID() {
   addSequential(new MoveLiftPID(frc.robot.Level.ROCKET_CARGO_3));
  }
}