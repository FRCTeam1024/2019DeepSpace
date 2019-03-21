/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift_commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class MoveLiftPID extends Command {
	Level level;
	
	public MoveLiftPID(Level level) {
    	requires(Robot.lift);
    	this.level = level;
    }

    protected void initialize() {
    	Robot.lift.setPIDSetpoint(level.getHeight());
    }

    protected void execute() {
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
    
    private void log(Object msg) {
    	System.out.println(msg);
    }

    protected boolean isFinished() {
    	if (Robot.lift.getLiftEncoderValue() < level.getHeight() - 100 || Robot.lift.getLiftEncoderValue() > level.getHeight() + 100) {
    		return false;
    	} else {
    		log("FINISHING MOVE LIFT PID");
    		return true;
    	}
    }

    protected void end() {
    	Robot.lift.stopLift();
    }

    protected void interrupted() {
    	end();
    }
}