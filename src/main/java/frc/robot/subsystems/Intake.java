/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

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
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Intake extends Subsystem {
  //Port numbers subject to change
  //Setup ports in RobotMap
  private TalonSRX cargoHeadRight  = new TalonSRX(RobotMap.RIGHT_CARGOHEAD_MOTOR_PORT);
  private TalonSRX cargoHeadLeft = new TalonSRX(RobotMap.LEFT_CARGOHEAD_MOTOR_PORT);
  private TalonSRX overRollerMotor  = new TalonSRX(RobotMap.OVER_ROLLER_MOTOR_PORT);

  
  private DoubleSolenoid openCenterRotate = new DoubleSolenoid(12, 1, 2);
  private DoubleSolenoid openCenterTilt = new DoubleSolenoid(12, 3, 4);

  private Solenoid beakExtender = new Solenoid(RobotMap.BEAK_EXTENDER_PORT);
  private Solenoid beakOpener = new Solenoid(RobotMap.BEAK_OPENER_PORT);
  private Solenoid overRollerExtender = new Solenoid(RobotMap.OVER_ROLLER_EXTENDER_PORT);

  private boolean beakOpenState = false;  
  private boolean beakExtendState = false;
  private boolean overRollerState = false;  
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void cargoheadSpeed(double Power) {
		cargoHeadLeft.set(ControlMode.PercentOutput, -Power);
		cargoHeadRight.set(ControlMode.PercentOutput, Power);
	}
	
  public void cargoheadStop() {
    cargoHeadLeft.set(ControlMode.PercentOutput, 0.0);
		cargoHeadRight.set(ControlMode.PercentOutput, 0.0);
  }

  public void overRollerSpeed(double Power) {
		overRollerMotor.set(ControlMode.PercentOutput, Power);
	}
	
  public void overRollerStop() {
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

  public boolean overRollerState() {
		return overRollerState;
	}

  public void beakEnxtend() {
    beakExtender.set(true);
    beakExtendState = true;
	}
	
	public void beakRetract() {
    beakExtender.set(false);
    beakExtendState = false;
  }
  
  public void beakOpen() {
    beakOpener.set(true);
    beakOpenState = true;
	}
	
	public void beakClose() {
    beakOpener.set(false);
    beakOpenState = false;
  }
  
  public boolean beakOpenState() {
		return beakOpenState;
	}
	
	public boolean beakExtendState() {
		return beakExtendState;
	}

  public void tiltUp(){
    //Not sure of direction yet
    openCenterTilt.set(DoubleSolenoid.Value.kForward);
  }
  
  public void tiltDown(){
    //Not sure of direction yet
    openCenterTilt.set(DoubleSolenoid.Value.kReverse);
  }

  public void tiltNeutral(){
    openCenterTilt.set(DoubleSolenoid.Value.kOff);
  }

  public void rotateRight(){
    //Not sure of direction yet
    openCenterRotate.set(DoubleSolenoid.Value.kForward);
  }

  public void rotateLeft(){
    //Not sure of direction yet
    openCenterRotate.set(DoubleSolenoid.Value.kReverse);
  }

  public void rotateNeutral(){
    openCenterRotate.set(DoubleSolenoid.Value.kOff);
  }
}
