/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoysticks extends Command {
  public DriveWithJoysticks() {
    requires(Robot.drivetrain);
  }
  protected void initialize() {
  }

  protected void execute() {
    Robot.drivetrain.drive(Robot.oi.lJoy.getY(), Robot.oi.rJoy.getY());
  }

  protected boolean isFinished() {
      return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}
