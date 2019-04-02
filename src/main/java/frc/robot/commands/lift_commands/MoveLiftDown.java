/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift_commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.logging.HelixEvents;

public class MoveLiftDown extends Command {
  public boolean isFinished = false;
  public MoveLiftDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.lift.moveCarriage(0.75);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.lift.getLimitSwitchBottom() == false) { //if top limit switch is pressed
      //THIS IS THE LOGIC FOR THE TOP LIMIT SWITCH, WE SWITCHED THIS AT CENTER GROVE
      //Robot.lift.resetEncoder();
      isFinished = true;
    }
    else{
      isFinished = false;
    }
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
