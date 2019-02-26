/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain_commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoysticks extends Command {
  public double driveLeft;
  public double driveRight;
  public DriveWithJoysticks() {
    requires(Robot.drivetrain);
  }
  protected void initialize() {
  }

  protected void execute() {
    if(Robot.DRIVE_FORWARD){
      driveLeft = Robot.oi.lJoy.getY();
      driveRight = Robot.oi.rJoy.getY();
    } else {
      driveLeft = -Robot.oi.rJoy.getY();
      driveRight = -Robot.oi.lJoy.getY();
    }
    Robot.drivetrain.drive(driveRight, driveLeft);
  }

  protected boolean isFinished() {
      return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}
