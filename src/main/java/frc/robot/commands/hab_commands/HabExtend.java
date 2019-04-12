/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hab_commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class HabExtend extends Command {
  // public TalonSRX habOne = new TalonSRX(RobotMap.HAB_ONE_MOTOR_PORT);
  // public TalonSRX habTwo = new TalonSRX(RobotMap.HAB_TWO_MOTOR_PORT);
  public HabExtend() {
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
   // requires(Robot.hab);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.hab.habMove(-1.0);
  //  System.out.println("EXECUTING");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hab.habMove(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
