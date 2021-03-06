/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.commandgroups;

import frc.robot.commands.CargoHeadSpeedTimed;
import frc.robot.commands.commandgroups.OverRollerIntakeAndRetract;
import frc.robot.commands.commandgroups.RotateLeftAndTiltHead;
import frc.robot.commands.intake_commands.*;
import frc.robot.commands.intake_commands.cargo_commands.CargoHeadSpeed;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CargoPickup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CargoPickup() {

    // addSequential(new RotateLeftAndTiltHead(1.0));
      
    // addParallel(new TiltHeadDown());
    // addParallel(new OverRollerIntakeAndRetract());
    // addParallel(new CargoHeadSpeedTimed(0.75));
    
    // addSequential(new TiltNeutral());
  }
}
