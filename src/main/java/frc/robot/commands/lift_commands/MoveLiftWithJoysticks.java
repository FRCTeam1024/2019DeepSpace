package frc.robot.commands.lift_commands;

import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.logging.HelixEvents;

/**
 *
 */
public class MoveLiftWithJoysticks extends Command {
public double movePower;
    public MoveLiftWithJoysticks() {
    	requires(Robot.lift);
    }

	@Override
    protected void initialize() {
	}
	
	private void log(String msg) {
		HelixEvents.getInstance().addEvent("MoveLiftWithJoysticks", msg);
    	// System.out.println(msg);
    }

	@Override
    protected void execute() {
    	/*if(Robot.lift.getCommandedOutput() > 0.0) {
    			
    		if (Robot.lift.getLiftEncoderValue() < 25000 /*&& !Robot.oi.getOverrideButton()) {
        		Robot.lift.configMaxOutputs(1.00);
    		} else {
    			Robot.lift.configMaxOutputs(0.15);
    		}
    	} else if(Robot.lift.getCommandedOutput() < 0.0) {
    		if (Robot.lift.getLiftEncoderValue() > 3000 /*&& !Robot.oi.getOverrideButton()) {
    			Robot.lift.configMaxOutputs(1.00);
    		} else {
    			Robot.lift.configMaxOutputs(0.15);
    		}
    	} else {
    		Robot.lift.configMaxOutputs(1.00);
		}*/
		//if(Robot.lift.getCommandedOutput() > 0.0){
		
		movePower = Robot.oi.logi.getRawAxis(Constants.LIFT_STICK_AXIS);

		// just testing a hold power
		// if(movePower < 0.02 && movePower > -0.02) {
		// 	movePower = 0.10;
		// }
		
		if(Robot.lift.getLimitSwitchTop() == false) { //if top limit switch is pressed
			log("TOP limit switch FALSE, is PRESSED");
			if(movePower > 0.0){
				movePower = 0.0;
			}
		}

		if(Robot.lift.getLimitSwitchBottom() == false) { //if bottom limit switch is pressed
			log("BOTTOM limit switch FALSE, is PRESSED");
			Robot.lift.resetEncoder();
			if(movePower < 0.0){
				movePower = 0.0;
			}
		}
		
		//System.out.println(-movePower);
		Robot.lift.moveCarriage(movePower);
		//System.out.println(Robot.lift.getLiftEncoderValue());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
    protected void end() {
	}
	
	@Override
    protected void interrupted() {
    }
}