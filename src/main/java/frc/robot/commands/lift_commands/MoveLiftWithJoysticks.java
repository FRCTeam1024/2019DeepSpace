package frc.robot.commands.lift_commands;

import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLiftWithJoysticks extends Command {

    public MoveLiftWithJoysticks() {
    	requires(Robot.lift);
    }

	@Override
    protected void initialize() {
	}
	
	@Override
    protected void execute() {
    	if(Robot.lift.getCommandedOutput() > 0.0) {
    			
    		if (Robot.lift.getLiftEncoderValue() < 25000 /*&& !Robot.oi.getOverrideButton()*/) {
        		Robot.lift.configMaxOutputs(1.00);
    		} else {
    			Robot.lift.configMaxOutputs(0.15);
    		}
    	} else if(Robot.lift.getCommandedOutput() < 0.0) {
    		if (Robot.lift.getLiftEncoderValue() > 3000 /*&& !Robot.oi.getOverrideButton()*/) {
    			Robot.lift.configMaxOutputs(1.00);
    		} else {
    			Robot.lift.configMaxOutputs(0.15);
    		}
    	} else {
    		Robot.lift.configMaxOutputs(1.00);
    	}
    	Robot.lift.moveCarriage(Robot.oi.logi.getRawAxis(Constants.LIFT_STICK_AXIS));
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