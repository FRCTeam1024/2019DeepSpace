/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constants {
    
	public static final double NAVX_TOLERANCE = 2.0f;
	public static final double MIN_ROTATION_ANGLE = -180;
	public static final double MAX_ROTATION_ANGLE = 180;

	// PID

	public static final double TRIM_PID_MIN_OUTPUT = -0.3;
	public static final double TRIM_PID_MAX_OUTPUT = 0.3;
	public static final double POS_PID_MIN_OUTPUT = -1.0;
	public static final double POS_PID_MAX_OUTPUT = 1.0;
	public static final double TURN_PID_MIN_OUTPUT = -1.0;
	public static final double TURN_PID_MAX_OUTPUT = 1.0;
	public static final double TURN_PID_ABSOLUTE_TOLERANCE = 0.5;

	public static final double DRIVETRAIN_ENCODER_DISTANCE_PER_PULSE = (1.0 / 71.0) * 4.0;

	//PID Constants
	public static final double TURN_KP = 0.018; //0.018;
	public static final double TURN_KI = 0.0;//0.0001;//0.0005; //was no i
	public static final double TURN_KD = 0.025;//0.025;//0.015; //was 0.025
	public static final double TURN_KF = 0.0;

	public static final double POS_KU = 0.08;
	public static final double POS_TU = 3.0;
	public static final double POS_KP = 0.066;//0.8 * POS_KU;
	public static final double POS_KI = 0.0;
	public static final double POS_KD = POS_TU / 8;
	public static final double POS_KF = 0.0;

	public static final double TRIM_KP = 0.055;
	public static final double TRIM_KI = 0.0;
	public static final double TRIM_KD = 0.1;
	public static final double TRIM_KF = 0.0;

	public static final double LIFT_KP = 1.5;
	public static final double LIFT_KI = 0.0;
	public static final double LIFT_KD = 0.0;

	public static final double WHEEL_DIAMETER_IN = 6.125;
	public static final double MAGNETIC_ENCODER_COUNTS_PER_REVOLUTION = 1024;
	public static final double OPTICAL_ENCODER_COUNTS_PER_REVOLUTION = 250;
	public static final double ENCODER_RATIO_TO_WHEEL = 3;

	public static final double ENCODER_RATIO_TO_LIFT_SHAFT = 64;

	// Ultrasonic Constants:
	public static final double MILLIMETER_SCALE_FACTOR = 124;
	public static final double INCH_SCALE_FACTOR = 48.8188; // MILLIMETER_SCALE_FACTOR * 0.3937;

	// Robot Constants:
	public static final double ROBOT_LENGTH_IN = 39.0; // front-to-back For 2018 Bot 39
	public static final double ROBOT_WIDTH_IN = 34.0; // side-to-side For 2018 Bot 35.5

	// Field Constants:
	public static final double FIELD_WIDTH = 324.0; //324 on real field
	public static final double FIELD_LENGTH = 648.0; //648 on real field
	public static final double BACKWALL_TO_EDGE_SWITCH_DISTANCE = 140.0;
	public static final double BACKWALL_TO_EDGE_SCALE_DISTANCE = 299.65;
	public static final double BACKWALL_TO_MIDDLE_SWITCH_DISTANCE = 168.0;
	public static final double BACKWALL_TO_MIDDLE_SCALE_DISTANCE = 324.0;
	public static final double SIDEWALL_TO_SWITCH_DISTANCE = 59.0; // 85.25 on real field
	public static final double SIDEWALL_TO_SCALE_DISTANCE = 71.57;
	public static final double SIDEWALL_TO_PORTAL_EDGE = 30.0;
	
	public static final double LOWEST_HEIGHT = 0;
	public static final double INTAKE_HEIGHT = -200;
	public static final double PORTAL_HEIGHT = 5500; //was 5023
	public static final double SWITCH_HEIGHT = 10024.0;
	public static final double SCALE_OWNERSHIP_HEIGHT = 21069.0;
	public static final double SCALE_NEUTRAL_HEIGHT = 23064.0;
	public static final double SCALE_LOSS_HEIGHT = 25000.0;
	public static final double MAX_HEIGHT = 26113;

	// Controller Constants:
	
	public static final int LEFT_JOYSTICK_PORT = 0;
	public static final int RIGHT_JOYSTICK_PORT = 1;
	public static final int LOGITECH_JOYSTICK_PORT = 2;
	public static final int BUTTON_PANNEL_PORT = 3;
	
	//public static final int LEFT_JOYSTICK_TRIGGER = 0;
	public static final int LIFT_STICK_AXIS = 3;
	public static final int INTAKE_STICK_AXIS_Y = 1;
	public static final int INTAKE_STICK_AXIS_X = 0;
	public static final int SHIFT_HIGH_BUTTON = 7;
	public static final int SHIFT_LOW_BUTTON = 10;
	
	public static final int TURN_CENTER_LIMELIGHT_BUTTON = 1;
	

	// public static final int INTAKE_SLIDE_IN_BUTTON = 8;
	// public static final int INTAKE_SLIDE_OUT_BUTTON = 6;

	// public static final int INTAKE_NARROW_ORIENTATION_BUTTON = 3;
	// public static final int INTAKE_FLAT_ORIENTATION_BUTTON = 4;

	public static final int LIFT_CLAMP_CLOSE_BUTTON = 7;
	public static final int LIFT_CLAMP_OPEN_BUTTON = 5;
	public static final int ENGAGE_AIRBAG_BUTTON = 8;
	public static final int DISENGAGE_AIRBAG_BUTTON = 6;
	public static final int CUBE_START_DETECT_BUTTON = 2;
	//public static final int LIFT_OVERRIDE_BUTTON = 1;

	public static final int INTAKE_START_ACQUIRE = 11;

	public static final int REACH_PORTAL_HEIGHT = 1;
	public static final int REACH_SWITCH_HEIGHT = 3;
	public static final int REACH_ZERO_HEIGHT = 2;
	public static final int REACH_SCALE_HEIGHT = 4;
}
