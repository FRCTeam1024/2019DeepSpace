/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake_commands.hatch_commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class ToggleBeak extends CommandGroup {
  /**
   * Command Broken, fix
   */
  public ToggleBeak() {
    if(!Robot.intake.beakOpenState()){
      addSequential(new CloseBeak());
    }else{
      addSequential(new OpenBeak());
    }
  }
}
