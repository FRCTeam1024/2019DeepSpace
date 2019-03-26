/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autodriving;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.logging.HelixEvents;
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
  private NetworkTableEntry ty;

  private int numFramesNoImages = 0;
  
  public DriveToVisibleTarget() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    log("constructor");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drivetrain.resetGyro();
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    log("initialize");
    isFinished = false;
    numFramesNoImages = 0;
  }

  private void log(String msg) {
    HelixEvents.getInstance().addEvent("DriveToVisibleTarget", msg);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    tv = limelightTable.getEntry("tv");
    ty = limelightTable.getEntry("ty");
    ta = limelightTable.getEntry("ta");
    ta0 = limelightTable.getEntry("ta0");
    ta1 = limelightTable.getEntry("ta1");
    // tx is the dual-target's center, compared to what we're looking at
    // the dual-target makes a rectangle out of our 2 vision targets, and
    // tx is the center of that
    // tx is negative if it is to the left of our center, 
    // so when tx is negative, we should turn left
    tx = limelightTable.getEntry("tx");
    tx0 =limelightTable.getEntry("tx0");
    tx1 =limelightTable.getEntry("tx1");
    double txNum = tx.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double validObjects = tv.getDouble(0.0);
    double limeX = tx.getDouble(0.0);
    double txZero = tx0.getDouble(0.0);
    double txOne = tx1.getDouble(0.0);
    double headingAngle = Robot.drivetrain.getHeading();
  
  
    if(validObjects == 1) {
      log("VALID OBJECTS == 1");
      numFramesNoImages--;
      if(numFramesNoImages < 0) {
        numFramesNoImages = 0;
      }
      // we think this was for when we treated the 2 vision targets as separate targets,
      // txZero and txOne

      // if(txZero < 0 && txOne == 0.0){
      //   System.out.print(txZero);
      //   Robot.drivetrain.drive(-0.20, -0.40);
      // }else if(txZero > 0 && txOne == 0.0){
      //   Robot.drivetrain.drive(-0.40, -0.20);
      //   }else if(txZero < 0 && txOne < 0){
      //     Robot.drivetrain.drive(-0.20, -0.40);
      //   }else if (txZero > 0 && txOne > 0){
      //     Robot.drivetrain.drive(-0.40, -0.20);
      //   }else if(txZero < 0 && txOne > 0){
      //     Robot.drivetrain.drive(-0.40, -0.40);
      // }

      // this is when we're using target grouping, grouping the 2 targets into 1 big box
      // and txNum is the center of that box; if it's positive, it's to the right,
      // so we want to turn right
      log("tx = " + txNum);
      // log("ty = " + ty.getDouble(0.0));
      // log("area = " + area);
      // log("txZero = " + txZero);
      // log("txOne = " + txOne);
      if (txNum < -1.0) { // target is to the left of center, so curve left
        log("target to left so curving left");
        Robot.drivetrain.drive(-0.50, -0.30);
      } else if (txNum > 1.0  ) { // target is to the right of center, so curve right
        log("target to right so curving right");
        Robot.drivetrain.drive(-0.30, -0.50);
      } else if(txNum < 1.0 && txNum > -1.0) { // roughly center so drive straight
        log("going straight");
        Robot.drivetrain.drive(-0.50, -0.50);
      }
    } else if(validObjects == 0) { //THIS NEEDS TO CHANGE, NEEDS TO GO A DISTANCE
      numFramesNoImages++;
      log("NO VALID OBJECTS");
      //isFinished = true;
    }
    if(numFramesNoImages > 10) {
      log("numFramesNoImages > 10 so finishing");
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
    Robot.drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    log("interrupted");
  }
}
