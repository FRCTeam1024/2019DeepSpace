/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Motors:
	public static final int OVER_ROLLER_MOTOR_PORT = 10;
	
	public static final int LEFT_CARGOHEAD_MOTOR_PORT = 42;
	public static final int RIGHT_CARGOHEAD_MOTOR_PORT = 1;

	public static final int FRONT_LEFT_MOTOR_PORT = 2;
	public static final int MIDDLE_LEFT_MOTOR_PORT = 3;
	public static final int REAR_LEFT_MOTOR_PORT = 4;
	public static final int FRONT_RIGHT_MOTOR_PORT = 5;
	public static final int MIDDLE_RIGHT_MOTOR_PORT = 8;
	public static final int REAR_RIGHT_MOTOR_PORT = 9;

	public static final int LIFT_MOTOR_1_PORT = 6;
	public static final int LIFT_MOTOR_2_PORT = 7;
	
	//Pnuematics:
	public static final int INTAKE_SLIDE_PORT = 1;
	public static final int SHIFTER_PORT = 2;
	public static final int AIRBAG_PORT = 3;
	public static final int INTAKE_POS_PORT = 4;
	public static final int LIFT_CLAMP_PORT = 5;
	
	public static final int OVER_ROLLER_EXTENDER_PORT = 7;
	public static final int HAB_RAMP_PORT = 8;
	public static final int HAB_CLIMB_PORT = 9;

	public static final int BEAK_OPENER_PORT = 5;
	public static final int BEAK_EXTENDER_PORT = 6;

	//I2C
	public static final Port NAVX_PORT = Port.kMXP;
	public static final Port COLOR_SENSOR_PORT = Port.kOnboard;
	
	//Digital
	public static final int DRIVE_ENCODER_CHANNEL_A = 0;
	public static final int DRIVE_ENCODER_CHANNEL_B = 1;
	public static final int DRIVE_ENCODER2_CHANNEL_A = 3;
	public static final int DRIVE_ENCODER2_CHANNEL_B = 4;
	public static final int LEFT_BUMP_CUBE_DETECTOR_PORT = 2;
	public static final int RIGHT_BUMP_CUBE_DETECTOR_PORT = 3;
	
	
}
