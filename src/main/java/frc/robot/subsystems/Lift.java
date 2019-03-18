/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Lift extends Subsystem {

  public TalonSRX liftMotor1 = new TalonSRX(RobotMap.LIFT_MOTOR_1_PORT);
	public TalonSRX liftMotor2 = new TalonSRX(RobotMap.LIFT_MOTOR_2_PORT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public Lift(){
    liftMotor2.follow(liftMotor1);
  }

  public void moveLift(double power){
    liftMotor1.set(ControlMode.PercentOutput, -power);
  }
  
}
*/
package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.lift_commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {
	
	public TalonSRX liftMotor1 = new TalonSRX(RobotMap.LIFT_MOTOR_1_PORT);
	public TalonSRX liftMotor2 = new TalonSRX(RobotMap.LIFT_MOTOR_2_PORT);
	
	public Lift () {
		//liftMotor2.set(ControlMode.Follower, liftMotor1.getDeviceID());
		//liftMotor2.follow(liftMotor1);
		liftMotor1.config_kP(0, Constants.LIFT_KP, 10);
		liftMotor1.config_kI(0, Constants.LIFT_KI, 10);
		liftMotor1.config_kD(0, Constants.LIFT_KD, 10);
		/*liftMotor2.config_kP(0, Constants.LIFT_KP, 10);
		liftMotor2.config_kI(0, Constants.LIFT_KI, 10);
		liftMotor2.config_kD(0, Constants.LIFT_KD, 10);*/
		configMaxOutputs(1.0);
		liftMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		liftMotor2.configSelectedFeedbackSensor(RemoteFeedbackDevice.RemoteSensor0, 0, 10);
		liftMotor1.setNeutralMode(NeutralMode.Brake);
		liftMotor2.setNeutralMode(NeutralMode.Brake);

	}
	
	public void moveCarriage(double power) {
		liftMotor1.set(ControlMode.PercentOutput, -power);
		liftMotor2.set(ControlMode.PercentOutput, -power);
	}
	
	public void setPIDSetpoint(double setpoint) {
		liftMotor1.set(ControlMode.Position, setpoint);
		liftMotor2.set(ControlMode.Position, setpoint);
	}
	
	public void stopLift() {
		moveCarriage(0.0);
	}
	
	public void resetEncoder() {
		liftMotor1.setSelectedSensorPosition(0, 0, 10);
	}
	
	public void outputToSmartDashboard() {
		SmartDashboard.putNumber("Lift Motor Rotations", liftMotor1.getSelectedSensorPosition(0) / 4096);
		SmartDashboard.putNumber("Lift Encoder Raw", liftMotor1.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("LiftMotorOutPut", liftMotor1.getMotorOutputPercent());
		
	}
	
	public double getLiftEncoderValue() {
		return liftMotor1.getSelectedSensorPosition(0);
	}
	
	public void configMaxOutputs(double maxPower) {
		liftMotor1.configPeakOutputForward(maxPower, 10);
		liftMotor1.configPeakOutputReverse(-maxPower, 10);
		liftMotor2.configPeakOutputForward(maxPower, 10); 
		liftMotor2.configPeakOutputReverse(-maxPower, 10);
	}
	
	public double getCommandedOutput() {
		return liftMotor1.getMotorOutputPercent();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveLiftWithJoysticks());
    }
}