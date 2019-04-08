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
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.buttons.Trigger.ButtonScheduler;
import frc.robot.commands.commandgroups.OverRollerDriverIntake;
import frc.robot.commands.intake_commands.RotateHeadNeutral;
import frc.robot.commands.intake_commands.RotateHeadRight;
import frc.robot.commands.intake_commands.TiltHeadDown;
import frc.robot.commands.intake_commands.TiltHeadUp;
import frc.robot.commands.intake_commands.TiltNeutral;
import frc.robot.commands.intake_commands.cargo_commands.*;
import frc.robot.commands.intake_commands.hatch_commands.*;
import frc.robot.commands.limelight_commands.*;
import frc.robot.commands.lift_commands.*;
import frc.robot.commands.autodriving.*;
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
	 public final Joystick usbJoy = new Joystick(Constants.BUTTON_PANNEL_PORT);
	 JoystickButton liftRocketCargoLevelOne = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_ONE_CARGO_BUTTON);
	 JoystickButton liftRocketCargoLevelTwo = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_TWO_CARGO_BUTTON);
	 JoystickButton liftRocketCargoLevelThree = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_THREE_CARGO_BUTTON);
	 JoystickButton liftRocketHatchLevelOne = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_ONE_HATCH_BUTTON);
	 JoystickButton liftRocketHatchLevelTwo = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_TWO_HATCH_BUTTON);
	 JoystickButton liftRocketHatchLevelThree = new JoystickButton(usbJoy, Constants.ROCKET_LEVEL_THREE_HATCH_BUTTON);
	 JoystickButton liftCargoShip = new JoystickButton(usbJoy, Constants.CARGO_SHIP_BUTTON);

	JoystickButton beakExtend = new JoystickButton(lJoy, Constants.BEAK_EXTEND);
	JoystickButton beakRetract = new JoystickButton(lJoy, Constants.BEAK_RETRACT);
	JoystickButton beakOpen = new JoystickButton(rJoy, Constants.BEAK_OPEN);
	JoystickButton beakClose = new JoystickButton(rJoy, Constants.BEAK_CLOSE);
	JoystickButton beakToggle = new JoystickButton(rJoy, Constants.BEAK_TOGGLE);


	JoystickButton overollerRetract = new JoystickButton(logi, Constants.OVEROLLER_RETRACT);
	JoystickButton overollerExtend = new JoystickButton(logi, Constants.OVEROLLER_EXTEND);
	JoystickButton cargoForward = new JoystickButton(lJoy, Constants.CARGO_OUT_LEFT);
	JoystickButton cargoBackward = new JoystickButton(lJoy, Constants.CARGO_OUT_RIGHT);
	JoystickButton switchCameraMode = new JoystickButton(lJoy, Constants.SWITCH_CAMERA);
	JoystickButton cargoSlow = new JoystickButton(logi, Constants.CARGO_SLOW);
	JoystickButton cargoSlowReverse = new JoystickButton(logi, Constants.CARGO_SLOW_REVERSE);
	
	JoystickButton overollerIn = new JoystickButton(lJoy, Constants.OVEROLLER_IN);
	JoystickButton overollerOut = new JoystickButton(lJoy, Constants.OVEROLLER_OUT);
	JoystickButton overollerInRJoy = new JoystickButton(rJoy, Constants.OVEROLLER_IN_RJOY);
	//JoystickButton overollerInLogi = new JoystickButton(logi, Constants.OVEROLLER_IN_LOGI);
	//JoystickButton overollerOut = new JoystickButton(rJoy, Constants.OVEROLLER_OUT);
	//JoystickButton overollerToggle = new JoystickButton(logi, Constants.OVEROLLER_TOGGLE);
	JoystickButton habExtend = new JoystickButton(lJoy, Constants.HAB_EXTEND_BUTTON);
	JoystickButton habRetract = new JoystickButton(lJoy, Constants.HAB_RETRACT_BUTTON);
	JoystickButton rampExtend = new JoystickButton(logi, Constants.RAMP_EXTEND);
	JoystickButton rampRetract = new JoystickButton(logi, Constants.RAMP_RETRACT);
	
	JoystickButton flipDirection = new JoystickButton(rJoy, Constants.FLIP_ROBOT_DIRECTION);
	JoystickButton driveToVisibleTarget = new JoystickButton(lJoy, Constants.DRIVE_TO_VISIBLE_TARGET);
	JoystickButton driveStraightTest = new JoystickButton(lJoy, Constants.DRIVE_STRAIGHT_TEST);
	JoystickButton xButton = new JoystickButton(logi, Constants.LOGITECH_X_BUTTON);
	JoystickButton yButton = new JoystickButton(logi, Constants.LOGITECH_Y_BUTTON);
	JoystickButton aButton = new JoystickButton(logi, Constants.LOGITECH_A_BUTTON);
	JoystickButton bButton = new JoystickButton(logi, Constants.LOGITECH_B_BUTTON);
	// JoystickButton tiltDown = new JoystickButton(logi, Constants.TILT_DOWN);
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
		


		 liftCargoShip.whenPressed(new LiftCargoShipPID());
		 liftRocketCargoLevelOne.whenPressed(new LiftRocketCargoLevelOnePID());
		 liftRocketCargoLevelTwo.whenPressed(new LiftRocketCargoLevelTwoPID());
		 liftRocketCargoLevelThree.whenPressed(new LiftRocketCargoLevelThreePID());
		 liftRocketHatchLevelOne.whenPressed(new MoveLiftDown());
		 liftRocketHatchLevelTwo.whenPressed(new LiftRocketHatchLevelTwoPID());
		 liftRocketHatchLevelThree.whenPressed(new LiftRocketHatchLevelThreePID());
		
		beakExtend.whenPressed(new ExtendBeak());
		beakRetract.whenPressed(new RetractBeak());
		beakToggle.whenPressed(new ToggleBeak());
		beakOpen.whenPressed(new OpenBeak());
		beakClose.whenPressed(new CloseBeak());

		overollerIn.whileHeld(new OverRollerSpeed());
		overollerOut.whileHeld(new OverRollerSpeedReverse());
		//overollerIn.toggleWhenPressed(new OverRollerSpeed());
		//cargoPickup.whenPressed(new CargoPickup());
		
		overollerRetract.whenPressed(new RetractOverRoller());
		overollerExtend.whenPressed(new ExtendOverRoller());
		overollerInRJoy.whileHeld(new OverRollerDriverIntake());
		//overollerInLogi.whileHeld(new OverRollerDriverIntake());
		overollerOut.whileHeld(new ReverseOverRoller());
		//overollerToggle.toggleWhenPressed(new ExtendOverRoller());
		
		cargoForward.whileHeld(new ShootCargoHead());
		cargoBackward.whileHeld(new IntakeCargoHead(-.15));
		cargoSlow.whileHeld(new CargoHeadSlowSpeed());
		cargoSlowReverse.whileHeld(new CargoHeadSlowSpeedReverse());
		xButton.whenPressed(new TiltHeadUp());
		yButton.whenPressed(new TiltHeadUp());
		aButton.whenPressed(new TiltHeadDown());
		bButton.whenPressed(new TiltHeadDown());
		tiltNeutral.whenPressed(new TiltNeutral());
		
		rampExtend.whenPressed(new ExtendRamp());
		rampRetract.whenPressed(new RetractRamp());
		shiftHigh.whenPressed(new ShiftHigh());
		shiftLow.whenPressed(new ShiftLow());

		flipDirection.whenPressed(new FlipDirection());
		// driveToVisibleTarget.whenPressed(new DriveToVisibleTarget());
		switchCameraMode.whenPressed(new SwitchCameraMode());
		driveToVisibleTarget.whenPressed(new CenterOnVisibleTarget());
		//driveStraightTest.whenPressed(new DriveStraightTimed(4, 0.5));
		habExtend.whileHeld(new HabExtend());
		habRetract.whileHeld(new HabRetract());
		//closeClamp.whenPressed(new CloseClamp());
    	//openClamp.whenPressed(new OpenClamp());
		//logi.dPad.up.whenPressed(new IntakeExtend());
		//logi.dPad.right.whenPressed(new RotateHeadNeutral());
		logi.dPad.right.whenPressed(new RotateHeadRight());
		logi.dPad.up.whenPressed(new RotateHeadNeutral());
		// logi.dPad.upLeft.whenPressed(new IntakeExtendNarrow());
		// logi.dPad.upRight.whenPressed(new IntakeExtendFlat());
		//	logi.a.whenPressed(new TurnToTarget());
		//turnToCenterLimelight.whenActive(new TurnToCenterLimelight());
	}
}
