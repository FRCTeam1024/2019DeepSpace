/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autodriving;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class DriveToVisibleTarget extends Command {
  boolean isFinished = false;
  private NetworkTable limelightTable;
  private NetworkTableEntry ta;
  private NetworkTableEntry ta0;
  private NetworkTableEntry ta1;
  private NetworkTableEntry tx;
  private NetworkTableEntry tx0;
  private NetworkTableEntry tx1;
  private NetworkTableEntry tv;

 /* public boolean validTarget(){
    if(validObjects = 0){
      return true;
    }
  }*/

  public DriveToVisibleTarget() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drivetrain.resetGyro();
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    tv = limelightTable.getEntry("tv");
    ta = limelightTable.getEntry("ta");
    ta0 = limelightTable.getEntry("ta0");
    ta1 = limelightTable.getEntry("ta1");
    tx = limelightTable.getEntry("tx");
    tx0 =limelightTable.getEntry("tx0");
    tx1 =limelightTable.getEntry("tx1");
    double area = ta.getDouble(0.0);
    double validObjects = tv.getDouble(0.0);
    double limeX = tx.getDouble(0.0);
    double txZero = tx0.getDouble(0.0);
    double txOne = tx1.getDouble(0.0);
    double headingAngle = Robot.drivetrain.getHeading();
  
  
    if(validObjects == 1){
      System.out.println("VALID OBJECTS == 1");
      if(txZero < 0 && txOne == 0.0){
        System.out.print(txZero);
        Robot.drivetrain.drive(-0.20, -0.40);
      }else if(txZero > 0 && txOne == 0.0){
        Robot.drivetrain.drive(-0.40, -0.20);
        }else if(txZero < 0 && txOne < 0){
          Robot.drivetrain.drive(-0.20, -0.40);
        }else if (txZero > 0 && txOne > 0){
          Robot.drivetrain.drive(-0.40, -0.20);
        }else if(txZero < 0 && txOne > 0){
          Robot.drivetrain.drive(-0.40, -0.40);
      }
    }
    
    else if(validObjects == 0){ //THIS NEEDS TO CHANGE, NEEDS TO GO A DISTANCE
      System.out.println("NO VALID OBJECTS");
      isFinished = true;
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
