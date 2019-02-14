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

public class OverRoller extends Subsystem {
  //change ports later
  private TalonSRX overRollerMotor  = new TalonSRX(RobotMap.OVER_ROLLER_MOTOR_PORT);

  private Solenoid habClimb = new Solenoid(9);
  private Solenoid habRamp = new Solenoid(8);
  private Solenoid overRollerExtender = new Solenoid(7);

  private boolean overRollerState = false;  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void overRollerSpeed(double Power) {
		overRollerMotor.set(ControlMode.PercentOutput, Power);
	}
	
  public void cargoheadStop() {
    overRollerMotor.set(ControlMode.PercentOutput, 0.0);
  }

  public void overRollerExtend() {
    overRollerExtender.set(true);
    overRollerState = true;
	}
	
	public void overRollerRetract() {
    overRollerExtender.set(false);
    overRollerState = false;
  }
  
  public void habClimbUp() {
    habClimb.set(true);
	}
	
	public void habClimbDown() {
    habClimb.set(false);
  }
  
  public void habRampUp() {
    habRamp.set(true);
	}
	
	public void habRampDown() {
    habRamp.set(false);
  }

  public boolean overRollerState() {
		return overRollerState;
	}
	

}
