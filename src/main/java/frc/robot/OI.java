/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.buttons.Trigger.ButtonScheduler;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final Joystick lJoy = new Joystick(Constants.LEFT_JOYSTICK_PORT);
	public final Joystick rJoy = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
	public final Logitech logi = new Logitech(Constants.LOGITECH_JOYSTICK_PORT);
	public final Joystick usbJoy = new Joystick(Constants.BUTTON_PANNEL_PORT);
	JoystickButton liftRocketCargoLevelOne = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_ONE_CARGO_HEIGHT);
	JoystickButton leftShiftHigh      = new JoystickButton(lJoy, Constants.SHIFT_HIGH_BUTTON);
	JoystickButton leftShiftLow       = new JoystickButton(lJoy, Constants.SHIFT_LOW_BUTTON);
	//JoystickButton turnToCenterLimelight = new JoystickButton(usbJoy, Constants.TURN_CENTER_LIMELIGHT_BUTTON);
	//JoystickButton backToDriveWithJoystick = new JoystickButton(lJoy, Constants.LEFT_JOYSTICK_TRIGGER);
	JoystickButton rightShiftHigh     = new JoystickButton(rJoy, Constants.SHIFT_HIGH_BUTTON);
	JoystickButton rightShiftLow      = new JoystickButton(rJoy, Constants.SHIFT_LOW_BUTTON);
  	JoystickButton closeClamp 		  = new JoystickButton(logi, Constants.LIFT_CLAMP_CLOSE_BUTTON);
	JoystickButton openClamp          = new JoystickButton(logi, Constants.LIFT_CLAMP_OPEN_BUTTON);
	//JoystickButton intakeStartAcquire = new JoystickButton(logi, Constants.INTAKE_START_ACQUIRE);
	//JoystickButton switchHeight   	  = new JoystickButton(logi, Constants.REACH_SWITCH_HEIGHT);
	//JoystickButton zeroHeight         = new JoystickButton(logi, Constants.REACH_ZERO_HEIGHT);
	//JoystickButton portalHeight       = new JoystickButton(logi, Constants.REACH_PORTAL_HEIGHT);
	//JoystickButton scaleHeight		  = new JoystickButton(logi, Constants.REACH_SCALE_HEIGHT);
	
	
	public OI () {
		//closeClamp.whenPressed(new CloseClamp());
    	//openClamp.whenPressed(new OpenClamp());
    	//logi.dPad.down.whenPressed(new IntakeRetract());
		//logi.dPad.up.whenPressed(new IntakeExtend());
		//logi.dPad.left.whenPressed(new IntakeNarrow());
		//logi.dPad.right.whenPress\ed(new IntakeFlat());
		//logi.dPad.upLeft.whenPressed(new IntakeExtendNarrow());
		//logi.dPad.upRight.whenPressed(new IntakeExtendFlat());
		//logi.a.whenPressed(new TurnToTarget());
		//turnToCenterLimelight.whenActive(new TurnToCenterLimelight());
	}
}
