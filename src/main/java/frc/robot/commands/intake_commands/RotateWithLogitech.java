/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake_commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RotateWithLogitech extends Command {

  public RotateWithLogitech() {
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.logi.getPOV() == 90){
      Robot.intake.rotateLeft();;
    }else if(Robot.oi.logi.getPOV() == 270){
      Robot.intake.rotateNeutral();;
    }else if(Robot.oi.logi.getPOV() == 180){
      Robot.intake.rotateRight();;
    }

    if(Robot.oi.logi.getRawButton(2)){
      Robot.intake.tiltDown();
    }else if(Robot.oi.logi.getRawButton(4)){
      Robot.intake.tiltUp();
    }else if(Robot.oi.logi.getRawButton(3)){
      Robot.intake.tiltNeutral();
    }
  }

  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
