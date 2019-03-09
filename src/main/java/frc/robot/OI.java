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
import frc.robot.commands.commandgroups.CargoPickup;
import frc.robot.commands.commandgroups.OverRollerDriverIntake;
import frc.robot.commands.intake_commands.RotateHeadLeft;
import frc.robot.commands.intake_commands.RotateHeadNeutral;
import frc.robot.commands.intake_commands.RotateHeadRight;
import frc.robot.commands.intake_commands.TiltHeadDown;
import frc.robot.commands.intake_commands.TiltHeadUp;
import frc.robot.commands.intake_commands.TiltNeutral;
import frc.robot.commands.intake_commands.cargo_commands.*;
import frc.robot.commands.intake_commands.hatch_commands.*;
import frc.robot.commands.limelight_commands.*;
import frc.robot.commands.lift_commands.*;
import frc.robot.commands.drivetrain_commands.*;
import frc.robot.commands.hab_commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final Joystick lJoy = new Joystick(Constants.LEFT_JOYSTICK_PORT);
	public final Joystick rJoy = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
	public final Logitech logi = new Logitech(Constants.LOGITECH_JOYSTICK_PORT);
	// public final Joystick usbJoy = new Joystick(Constants.BUTTON_PANNEL_PORT);
	// JoystickButton liftRocketCargoLevelOne = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_ONE_CARGO_HEIGHT);
	// JoystickButton liftRocketCargoLevelTwo = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_TWO_CARGO_HEIGHT);
	// JoystickButton liftRocketCargoLevelThree = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_THREE_CARGO_HEIGHT);
	// JoystickButton liftRocketHatchLevelOne = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_ONE_HATCH_HEIGHT);
	// JoystickButton liftRocketHatchLevelTwo = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_TWO_HATCH_HEIGHT);
	// JoystickButton liftRocketHatchLevelThree = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_THREE_HATCH_HEIGHT);
	// JoystickButton liftCargoShip = new JoystickButton(usbJoy, Constants.CARGO_SHIP_HEIGHT);

	JoystickButton beakExtend = new JoystickButton(lJoy, Constants.BEAK_EXTEND);
	JoystickButton beakRetract = new JoystickButton(lJoy, Constants.BEAK_RETRACT);
	JoystickButton beakOpen = new JoystickButton(rJoy, Constants.BEAK_OPEN);
	JoystickButton beakClose = new JoystickButton(rJoy, Constants.BEAK_CLOSE);
	JoystickButton beakToggle = new JoystickButton(rJoy, Constants.BEAK_TOGGLE);

	JoystickButton overollerRetract = new JoystickButton(logi, Constants.OVEROLLER_RETRACT);
	JoystickButton overollerExtend = new JoystickButton(logi, Constants.OVEROLLER_EXTEND);
	JoystickButton cargoForward = new JoystickButton(lJoy, Constants.CARGO_OUT_LEFT);
	JoystickButton cargoBackward = new JoystickButton(lJoy, Constants.CARGO_OUT_RIGHT);
	JoystickButton cargoPickup = new JoystickButton(logi, Constants.CARGO_PICKUP);
	JoystickButton cargoSlow = new JoystickButton(logi, Constants.CARGO_SLOW);
	
	JoystickButton overollerInRJoy = new JoystickButton(rJoy, Constants.OVEROLLER_IN_RJOY);
	JoystickButton overollerInLogi = new JoystickButton(logi, Constants.OVEROLLER_IN_LOGI);
	JoystickButton overollerOut = new JoystickButton(rJoy, Constants.OVEROLLER_OUT);
	//JoystickButton overollerToggle = new JoystickButton(logi, Constants.OVEROLLER_TOGGLE);
	JoystickButton rampExtend = new JoystickButton(rJoy, Constants.RAMP_EXTEND);
	//JoystickButton rampRetract = new JoystickButton(logi, Constants.RAMP_RETRACT);
	
	JoystickButton flipDirection = new JoystickButton(rJoy, Constants.FLIP_ROBOT_DIRECTION);

	JoystickButton tiltUp = new JoystickButton(logi, Constants.TILT_UP);
	JoystickButton tiltDown = new JoystickButton(logi, Constants.TILT_DOWN);
	JoystickButton tiltNeutral = new JoystickButton(logi, Constants.TILT_NEUTRAL);
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
		


		// liftCargoShip.whenActive(new LiftCargoShip());
		// liftRocketCargoLevelOne.whenActive(new LiftRocketCargoLevelOne());
		// liftRocketCargoLevelTwo.whenActive(new LiftRocketCargoLevelTwo());
		// liftRocketCargoLevelThree.whenActive(new LiftRocketCargoLevelThree());
		// liftRocketHatchLevelOne.whenActive(new LiftRocketHatchLevelOne());
		// liftRocketHatchLevelTwo.whenActive(new LiftRocketHatchLevelTwo());
		// liftRocketHatchLevelThree.whenActive(new LiftRocketHatchLevelThree());
		
		beakExtend.whenPressed(new ExtendBeak());
		beakRetract.whenPressed(new RetractBeak());
		beakToggle.whenPressed(new ToggleBeak());
		beakOpen.whenPressed(new OpenBeak());
		beakClose.whenPressed(new CloseBeak());

		//overollerIn.toggleWhenPressed(new OverRollerSpeed());
		//cargoPickup.whenPressed(new CargoPickup());
		
		overollerRetract.whenPressed(new RetractOverRoller());
		overollerExtend.whenPressed(new ExtendOverRoller());
		overollerInRJoy.whileHeld(new OverRollerDriverIntake());
		overollerInLogi.whileHeld(new OverRollerDriverIntake());
		overollerOut.whileHeld(new ReverseOverRoller());
		//overollerToggle.toggleWhenPressed(new ExtendOverRoller());
		
		cargoForward.whileHeld(new ShootCargoHead());
		cargoBackward.whileHeld(new IntakeCargoHead(-.15));
		cargoSlow.whileHeld(new CargoHeadSlowSpeed());
		tiltDown.whenPressed(new TiltHeadDown());
		tiltUp.whenPressed(new TiltHeadUp());
		tiltNeutral.whenPressed(new TiltNeutral());
		
		rampExtend.whenPressed(new ExtendRamp());
		shiftHigh.whenPressed(new ShiftHigh());
		shiftLow.whenPressed(new ShiftLow());

		flipDirection.whenPressed(new FlipDirection());
		
		//closeClamp.whenPressed(new CloseClamp());
    	//openClamp.whenPressed(new OpenClamp());
		//logi.dPad.up.whenPressed(new IntakeExtend());
		logi.dPad.down.whenPressed(new RotateHeadNeutral());
		logi.dPad.left.whenPressed(new RotateHeadLeft());
		logi.dPad.right.whenPressed(new RotateHeadRight());
		// logi.dPad.upLeft.whenPressed(new IntakeExtendNarrow());
		// logi.dPad.upRight.whenPressed(new IntakeExtendFlat());
		//	logi.a.whenPressed(new TurnToTarget());
		//turnToCenterLimelight.whenActive(new TurnToCenterLimelight());
	}
}
