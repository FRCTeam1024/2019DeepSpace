/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift_commands;


import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LiftCargoShip extends Command {
  public boolean isFinished = false;


  public LiftCargoShip() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.lift.getLiftEncoderValue() >= (Constants.CARGO_SHIP_HEIGHT + Constants.LIFT_ENCODER_TOLERANCE)){
      Robot.lift.moveCarriage(-0.5);
   //   System.out.println("LIFT TOO HIGH");
    }
    else if(Robot.lift.getLiftEncoderValue() <= (Constants.CARGO_SHIP_HEIGHT - Constants.LIFT_ENCODER_TOLERANCE)){
      Robot.lift.moveCarriage(0.5);
   //   System.out.println("LIFT TOO LOW");
      }
      else if(Robot.lift.getLiftEncoderValue() > (Constants.CARGO_SHIP_HEIGHT - Constants.LIFT_ENCODER_TOLERANCE) && Robot.lift.getLiftEncoderValue() < (Constants.CARGO_SHIP_HEIGHT + Constants.LIFT_ENCODER_TOLERANCE))  {
      Robot.lift.stopLift();
     // System.out.println("LIFT AT HEIGHT");
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
