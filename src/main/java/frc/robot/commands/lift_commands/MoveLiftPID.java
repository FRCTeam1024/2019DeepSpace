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
	public boolean isFinished = false;
	
	public MoveLiftPID(Level level) {
		requires(Robot.lift);
		log("Constructor with level : " + level + ", height : " + level.getHeight());
    	this.level = level;
    }

    protected void initialize() {
		log("Initialize, setpoint : " + -level.getHeight());
		log("            current encoder : " + Robot.lift.getLiftEncoderValue());
		// for some reason, all the switching of lift and lift encoders, made us
		// have to put the - here
		Robot.lift.setPIDSetpoint(-level.getHeight());
    }

    protected void execute() {
		log("execute, setpoint : " + -level.getHeight());
		log("         current encoder : " + Robot.lift.getLiftEncoderValue());
		// if(Robot.lift.getLimitSwitchBottom() == false) { //if top limit switch is pressed
		// 	//THIS IS THE LOGIC FOR THE TOP LIMIT SWITCH, WE SWITCHED THIS AT CENTER GROVE
		// 	Robot.lift.resetEncoder();
		// 	isFinished = true;
			
		// }

		// else if(Robot.lift.getLimitSwitchTop() == false) { //if bottom limit switch is pressed
			
		// 	//THIS IS THE LOGIC FOR THE BOTTOM LIMIT SWITCH, WE SWITCHED THIS AT CENTER GROVE
		// 	isFinished = true;
		// }
		//log("Excecuting...");
		/*if(Robot.lift.getLimitSwitchTop() == false) { //if top limit switch is pressed
			Robot.lift.configMaxOutputs(0.0);
		}

		if(Robot.lift.getLimitSwitchBottom() == false) { //if bottom limit switch is pressed
			Robot.lift.resetEncoder();
			Robot.lift.configMinOutputs(0.0);
		}*/
		
    }
    
    private void log(String msg) {
		//HelixEvents.getInstance().addEvent("MoveLiftPID", msg);
    	System.out.println(msg);
    }

    protected boolean isFinished() {
		
		//log("isFinished, height : " + liftValue + ", targetHeight : " + level.getHeight());
		if (Robot.lift.getLiftEncoderValue() < level.getHeight() - 100 || 
			Robot.lift.getLiftEncoderValue() > level.getHeight() + 100) {
				if(Robot.lift.getLimitSwitchTop() == false) { //if top limit switch is pressed
					//THIS IS THE LOGIC FOR THE TOP LIMIT SWITCH, WE SWITCHED THIS AT CENTER GROVE
					//Robot.lift.resetEncoder();
					isFinished = true;
				}
				else{
					isFinished = false;
				}
		
				
			//isFinished = false;
			//return isFinished;
    		
    	} else {
			isFinished = true;
			//return isFinished;
		}
		return isFinished;
	
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