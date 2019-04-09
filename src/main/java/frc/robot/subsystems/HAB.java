/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class HAB extends Subsystem {
  //change ports later

  public TalonSRX habOne = new TalonSRX(RobotMap.HAB_ONE_MOTOR_PORT);
  public TalonSRX habTwo = new TalonSRX(RobotMap.HAB_TWO_MOTOR_PORT);
  private Solenoid habRamp = new Solenoid(Constants.CHASSIS_PCM_PORT, RobotMap.HAB_RAMP_PORT);

  private boolean habClimbState = true;
  private boolean habRampState = false;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
 
  public void habClimbUp() {
    //habClimb.set(true);
    habClimbState = true;
	}
	
	public void habClimbDown() {
    //habClimb.set(false);
    habClimbState = false;
  }
  
  public boolean habClimbState(){
    return habClimbState;
  }

  public void habRampUp() {
    habRamp.set(false);
    habRampState = false;
	}
	
	public void habRampDown() {
    habRamp.set(true);
    habRampState = true;
  }

  public boolean habRampState(){
    return habRampState;
  }
  public void habMove(double motorPower) {
    habOne.set(ControlMode.PercentOutput, motorPower);
    habTwo.set(ControlMode.PercentOutput, motorPower);
	}

}
