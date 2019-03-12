/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake_commands.cargo_commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.logging.HelixEvents;

public class OverRollerSpeed extends Command {

 // private boolean isFinished = false;
  private double speed;
  private int duration = 0;

  public OverRollerSpeed() {
    // requires(Robot.intake);
  }

  public OverRollerSpeed(int duration) {
    // requires(Robot.intake);
    this.duration = duration;
  } 

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    log("Initialize");
  }
  
  private void log(String msg) {
    // HelixEvents.getInstance().addEvent("OverRollerSpeed", msg);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.intake.overRollerSpeed(-.7);
    //Timer.delay(1);
    
    
    //isFinished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    log("isFinished(), Duration : " + duration);
    double timeSinceInitialized = timeSinceInitialized();
    log("isFinished(), Time since initializied : " + timeSinceInitialized);
    if(duration > 0) {
      if(timeSinceInitialized > duration) {
        log("isFinished(), returning true");
        return true;
      }
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intake.overRollerSpeed(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    log("Interrupted  ******");
    end();
  }
}
