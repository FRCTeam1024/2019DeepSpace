/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift_commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.logging.HelixEvents;

public class MoveLiftPID extends Command {
	Level level;
	
	public MoveLiftPID(Level level) {
		requires(Robot.lift);
		log("Constructor with level : " + level + ", height : " + level.getHeight());
    	this.level = level;
    }

    protected void initialize() {
		log("Initialize");
		// for some reason, all the switching of lift and lift encoders, made us
		// have to put the - here
    	Robot.lift.setPIDSetpoint(-level.getHeight());
    }

    protected void execute() {
		log("Excecuting...");
		/*
    	if(Robot.lift.getCommandedOutput() > 0.0) {
    		if (Robot.lift.getLiftEncoderValue() < 25000 /*&& !Robot.oi.getOverrideButton()) {
        		Robot.lift.configMaxOutputs(1.0);
//        		System.out.println("1");
    		} else {
    			Robot.lift.configMaxOutputs(0.25);
//        		System.out.println("2");

    		}
    	} else if(Robot.lift.getCommandedOutput() < 0.0) {
    		if (Robot.lift.getLiftEncoderValue() > 3000 /*&& !Robot.oi.getOverrideButton()) {
    			Robot.lift.configMaxOutputs(1.0);
//        		System.out.println("3");
    		} else {
    			Robot.lift.configMaxOutputs(0.25);
//        		System.out.println("4");
    		}
    	} else {
    		Robot.lift.configMaxOutputs(1.0);
//    		System.out.println("5");
    	}
//    	System.out.println(Robot.lift.liftMotor1.getMotorOutputPercent());
*/
    }
    
    private void log(String msg) {
		HelixEvents.getInstance().addEvent("MoveLiftPID", msg);
    	// System.out.println(msg);
    }

    protected boolean isFinished() {
		double liftValue = Robot.lift.getLiftEncoderValue();
		log("isFinished, height : " + liftValue + ", targetHeight : " + level.getHeight());
		if (Robot.lift.getLiftEncoderValue() < level.getHeight() - 100 || 
			Robot.lift.getLiftEncoderValue() > level.getHeight() + 100) {
			log("isFinished : FALSE");
    		return false;
    	} else {
    		log("FINISHING MOVE LIFT PID");
    		return true;
    	}
    }

    protected void end() {
		log("END");
		// commented out this holdLift() once we set brake mode on lift talons via Phoenix Tuner
		// but keeping it here just in case we need to go back to it
    	//Robot.lift.holdLift();
    }

    protected void interrupted() {
		log("Interrrupted");
    	end();
    }
}