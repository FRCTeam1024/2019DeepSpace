package frc.robot.commands.lift_commands;

import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLiftWithJoysticksPID extends Command {
public double movePower;
    public MoveLiftWithJoysticksPID() {
    	requires(Robot.lift);
    }

	@Override
    protected void initialize() {
	}
	
	@Override
    protected void execute() {
    	if(Robot.lift.getCommandedOutput() > 0.0) {
    		//	System.out.println("getCommandedOutput() > 0");
    		if (Robot.lift.getLiftEncoderValue() < 25000) {
            Robot.lift.configMaxOutputs(1.00);
            //System.out.println("geLiftEncoderValue() > 0");
    		} else {
          Robot.lift.configMaxOutputs(0.15);
          //System.out.println("configMaxOutputs(0.15");
    		}
    	} else if(Robot.lift.getCommandedOutput() < 0.0) {
    		if (Robot.lift.getLiftEncoderValue() > 3000) {
          Robot.lift.configMaxOutputs(1.00);
       //   System.out.println("getLiftEncoderValue() > 3000");
    		} else {
          Robot.lift.configMaxOutputs(0.15);
     //     System.out.println("configMaxOuputs(0.15");
    		}
    	} else {
        Robot.lift.configMaxOutputs(1.00);
       // System.out.println("configMaxOutputs(1.00");
		}
		//if(Robot.lift.getCommandedOutput() > 0.0){
		
		movePower = -Robot.oi.logi.getRawAxis(Constants.LIFT_STICK_AXIS);

		if(Robot.lift.getLimitSwitchTop() == false){ //if top limit switch is pressed
			//	System.out.println("top false");
				if(movePower > 0.0){
					movePower = 0.0;
				}

			}
			if(Robot.lift.getLimitSwitchBottom() == false){ //if bottom limit switch is pressed
		//		System.out.println("bottom false");
				Robot.lift.resetEncoder();
				if(movePower < 0.0){
					movePower = 0.0;
				}
			}
		//System.out.println(-movePower);
    Robot.lift.moveCarriage(movePower);
    }
		//System.out.println(Robot.lift.getLiftEncoderValue());
	
//	}

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