/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autodriving;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 * Add your docs here.
 */
public class DriveStraightTimed extends TimedCommand {
  double movePower;
  /**
   * Add your docs here.
   */
  public DriveStraightTimed(double timeout, double movePower) {
    super(timeout);
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.drive(-movePower, -movePower);
  //  System.out.println("EXECUTE");
  }

  // Called once after timeout
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
