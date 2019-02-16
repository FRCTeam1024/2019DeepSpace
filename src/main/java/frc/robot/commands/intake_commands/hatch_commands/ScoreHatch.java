/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake_commands.hatch_commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreHatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ScoreHatch() {
  addSequential(new ExtendBeak());
  addSequential(new CloseBeak());
  }
}
