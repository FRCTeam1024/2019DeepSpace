/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autodriving;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;



public class TurnToCenterLimelight extends Command {

  private boolean isFinished;
  
  
  public TurnToCenterLimelight() {
   requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    isFinished = false;
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.getLimeLightX() > .5) { // target is right of center, so turn right
      Robot.drivetrain.turn(.15);
    }else if(Robot.getLimeLightX() < -.5){ // target is left of center, so turn left
      Robot.drivetrain.turn(-.15);
    }
    if(Robot.getLimeLightX() < .5 && Robot.getLimeLightX() > -.5){
      isFinished = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
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
