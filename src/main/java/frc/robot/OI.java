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
import frc.robot.commands.intake_commands.cargo_commands.*;
import frc.robot.commands.intake_commands.hatch_commands.*;
import frc.robot.commands.limelight_commands.*;
import frc.robot.commands.lift_commands.*;
import frc.robot.commands.drivetrain_commands.*;

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
	JoystickButton liftRocketCargoLevelTwo = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_TWO_CARGO_HEIGHT);
	JoystickButton liftRocketCargoLevelThree = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_THREE_CARGO_HEIGHT);
	JoystickButton liftRocketHatchLevelOne = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_ONE_HATCH_HEIGHT);
	JoystickButton liftRocketHatchLevelTwo = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_TWO_HATCH_HEIGHT);
	JoystickButton liftRocketHatchLevelThree = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_THREE_HATCH_HEIGHT);
	JoystickButton liftCargoShip = new JoystickButton(usbJoy, Constants.CARGO_SHIP_HEIGHT);
	JoystickButton beakExtend = new JoystickButton(lJoy, Constants.BEAK_EXTEND);
	JoystickButton beakRetract = new JoystickButton(lJoy, Constants.BEAK_RETRACT);
	JoystickButton beakOpen = new JoystickButton(lJoy, Constants.BEAK_OPEN);
	JoystickButton beakClose = new JoystickButton(lJoy, Constants.BEAK_CLOSE);
	JoystickButton overollerRetract = new JoystickButton(lJoy, Constants.OVEROLLER_RETRACT);
	JoystickButton overollerExtend = new JoystickButton(lJoy, Constants.OVEROLLER_EXTEND);
	JoystickButton cargoForward = new JoystickButton(lJoy, Constants.CARGO_SHOOT);
	JoystickButton cargoBackward = new JoystickButton(lJoy, Constants.CARGO_INTAKE);
	JoystickButton flipDirection = new JoystickButton(rJoy, Constants.FLIP_ROBOT_DIRECTION);

	//JoystickButton turnToCenterLimelight = new JoystickButton(usbJoy, Constants.TURN_CENTER_LIMELIGHT_BUTTON);
	//JoystickButton backToDriveWithJoystick = new JoystickButton(lJoy, Constants.LEFT_JOYSTICK_TRIGGER);
	JoystickButton shiftHigh     = new JoystickButton(lJoy, Constants.SHIFT_HIGH_BUTTON);
	JoystickButton shiftLow      = new JoystickButton(lJoy, Constants.SHIFT_LOW_BUTTON);
 
	//JoystickButton intakeStartAcquire = new JoystickButton(logi, Constants.INTAKE_START_ACQUIRE);
	//JoystickButton switchHeight   	  = new JoystickButton(logi, Constants.REACH_SWITCH_HEIGHT);
	//JoystickButton zeroHeight         = new JoystickButton(logi, Constants.REACH_ZERO_HEIGHT);
	//JoystickButton portalHeight       = new JoystickButton(logi, Constants.REACH_PORTAL_HEIGHT);
	//JoystickButton scaleHeight		  = new JoystickButton(logi, Constants.REACH_SCALE_HEIGHT);
	
	
	public OI () {
		


		liftCargoShip.whenActive(new LiftCargoShip());
		liftRocketCargoLevelOne.whenActive(new LiftRocketCargoLevelOne());
		liftRocketCargoLevelTwo.whenActive(new LiftRocketCargoLevelTwo());
		liftRocketCargoLevelThree.whenActive(new LiftRocketCargoLevelThree());
		liftRocketHatchLevelOne.whenActive(new LiftRocketHatchLevelOne());
		liftRocketHatchLevelTwo.whenActive(new LiftRocketHatchLevelTwo());
		liftRocketHatchLevelThree.whenActive(new LiftRocketHatchLevelThree());
		
		beakExtend.whenPressed(new ExtendBeak());
		beakRetract.whenPressed(new RetractBeak());
		beakOpen.whenPressed(new OpenBeak());
		beakClose.whenPressed(new CloseBeak());

		overollerRetract.whenPressed(new RetractOverRoller());
		overollerExtend.whenPressed(new ExtendOverRoller());
		cargoForward.whileHeld(new ShootCargoHead());
		cargoBackward.whileHeld(new IntakeCargoHead());

		flipDirection.whenPressed(new FlipDirection());
		
		//closeClamp.whenPressed(new CloseClamp());
    	//openClamp.whenPressed(new OpenClamp());
    	//logi.dPad.down.whenPressed(new IntakeRetract());
		//logi.dPad.up.whenPressed(new IntakeExtend());
		//logi.dPad.left.whenPressed(new IntakeNarrow());
		//logi.dPad.right.whenPressed(new IntakeFlat());
		// logi.dPad.upLeft.whenPressed(new IntakeExtendNarrow());
		// logi.dPad.upRight.whenPressed(new IntakeExtendFlat());
	//	logi.a.whenPressed(new TurnToTarget());
		//turnToCenterLimelight.whenActive(new TurnToCenterLimelight());
	}
}
