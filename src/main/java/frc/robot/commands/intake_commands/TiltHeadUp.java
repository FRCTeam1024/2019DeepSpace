/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake_commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class TiltHeadUp extends Command {
  private boolean isFinished = false;
  double delay = 0.0;
  public TiltHeadUp() {
    //requires(Robot.intake);
  }
  public TiltHeadUp(double delay) {
    this.delay = delay;
   }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(delay > 0.0) {
      Timer.delay(delay);
    }
    Robot.intake.tiltUp();
    isFinished = true;
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
