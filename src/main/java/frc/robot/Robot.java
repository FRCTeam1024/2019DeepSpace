/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.List;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.HttpCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;

import java.io.*;
import java.util.logging.*;

import edu.wpi.first.wpilibj.Filesystem;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.commands.intake_commands.*;
import frc.robot.commands.limelight_commands.*;
import frc.robot.commands.drivetrain_commands.*;
import frc.robot.commands.lift_commands.*;
import frc.robot.logging.*;

public class Robot extends TimedRobot {

	public static Drivetrain drivetrain = new Drivetrain();
  	public static OI oi = new OI();
  	public static Lift lift = new Lift();
  	public static Intake intake = new Intake();
  	public static Hab hab = new Hab();
  	public static Sensors sensors = new Sensors();
	public static PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	Command m_autonomousCommand;
	Command driveWithJoysticks = new DriveWithJoysticks();
	Command	tiltWithJoysticks = new TiltWithJoystick();
	Command liftWithJoysticks = new MoveLiftWithJoysticks();

	SendableChooser<String> autoChooser = new SendableChooser<String>();

	// define the logger for this class. This should be done for every class
  private static LogWrapper mLog;

  private static double LimeX;
  
	private static int cameraMode = 0;

	@Override
	public void robotInit() {
    
		oi = new OI();
		NetworkTableEntry tx;
		NetworkTableEntry ty;
		NetworkTableEntry ta;
		initLogging();
    	sensors.startColorSensor();
    
		try {
			// UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
			HttpCamera limelight = CameraServer.getInstance().addAxisCamera("http://10.10.24.11:5801/");
		
			outputCameraToSmartDashboard();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

	private void initLogging() {
		HelixEvents.getInstance().startLogging();
		// try {
        //     File dir = Filesystem.getDeployDirectory();
        //     String logFile = "NOTFOUND";
        //     if (dir.isDirectory() && dir.exists()) {
        //         logFile = dir.getAbsolutePath() + "/logging.properties";
        //     } else {
		// 		System.out.println("Directory not found.");
		// 	}
        //     System.out.println("**********  logConfig: " + logFile + "  *********************");
        //     // BufferedReader br = new BufferedReader(new FileReader(logFile));
        //     // String line = null;
        //     // while ((line = br.readLine()) != null) {
        //     //     System.out.println(line);
        //     // }
        //     // br.close();
        //     FileInputStream configFile = new FileInputStream(logFile);
        //     LogManager.getLogManager().readConfiguration(configFile);
        // } catch (IOException ex) {
        //     System.out.println("WARNING: Could not open configuration file");
        //     System.out.println("WARNING: Logging not configured (console output only)");
        // }
		// mLog = new LogWrapper(Robot.class.getName());
        // try {
        //     mLog.info("robotInit: ---------------------------------------------------");
        //     // mControlBoard = ControlBoard.getInstance();
        //     // mDriveSys = DriveSys.getInstance();
        //     // mNavXsys = NavXSys.getInstance();
        //     // mDriveDistCmd = new DriveDistCmd(5);
        //     mLog.info("robotInit: Completed   ---------------------------------------");
        // } catch (Exception ex) {
        //     mLog.severe(ex, "Robot.robotInit:  exception: " + ex.getMessage());
        // }
	}


	public static int switchCameraMode(){
		if(cameraMode == 0){
			cameraMode = 1;
		}else if(cameraMode == 1){
			cameraMode = 0;
		}
		return cameraMode;
	}

	@Override
	public void disabledInit() {
		//drivetrain.setCoast();
		//intake.setCubeLight();
		//intake.posIn();
		//intake.slideIn();
		//lift.clamp(false);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//intake.setCubeLight();
		//drivetrain.outputToSmartDashboard();
		//lift.outputToSmartDashboard();
		//intake.outputToSmartDashboard();
	}
	
	@Override
	public void autonomousInit() {
		
		//Robot.drivetrain.resetOpticalEncoder();
		//Robot.drivetrain.resetGyro();
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		//intake.setCubeLight();
		//drivetrain.outputToSmartDashboard();
		//lift.outputToSmartDashboard();
		//intake.outputToSmartDashboard();

		outputCameraToSmartDashboard();
		// double turn = centerX1 - (IMG_WIDTH / 2);
		// drive.arcadeDrive(-0.6, turn * 0.005);
	}

	private void outputCameraToSmartDashboard() {
		
		SmartDashboard.putNumber("Angle", drivetrain.getHeading());
		//SmartDashboard.putData("Reset Gyro", new resetGyro());
		//SmartDashboard.putData("CurveToTarget", new TurnToTarget());
		SmartDashboard.putData("Change Camera Mode", new SwitchCameraMode());
		//SmartDashboard.putData("TurnToCenterLimelight", new TurnToCenterLimelight());
		//SmartDashboard.putData("CurveHabToRocket", new CurveHabToRocket());
		//SmartDashboard.putData("HabToRocketHatch", new HabToRocketHatch());
		Robot.sensors.printValue();

		NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
		NetworkTableEntry tx;
		NetworkTableEntry ty;
		NetworkTableEntry ta;
		NetworkTableEntry thor;
		NetworkTableEntry tvert;
		
		tx = table.getEntry("tx");
		ty = table.getEntry("ty");
		ta = table.getEntry("ta");
		thor = table.getEntry("thor");
		tvert = table.getEntry("tvert");

		//read values periodically
		LimeX = tx.getDouble(0.0);
		double y = ty.getDouble(0.0);
		double area = ta.getDouble(0.0);
		double hor = thor.getDouble(0.0);
		double vert = tvert.getDouble(0.0);
		double areaCalc = hor*vert;

		//post to smart dashboard periodically
		SmartDashboard.putNumber("LimelightX", LimeX);
		SmartDashboard.putNumber("LimelightY", y);
		SmartDashboard.putNumber("LimelightArea", area);
		SmartDashboard.putNumber("Limelight Horizontal", hor);
		SmartDashboard.putNumber("Limelight Vertical", vert);
		SmartDashboard.putNumber("LimelightArea Calculated", areaCalc);
	}
	
	public static double getLimeLightX(){
		return LimeX;
	}

	@Override
	public void teleopInit() {
		
		// drivetrain.setBrake();
		// lift.disengageAirBag();
		// intake.setCubeLight();
		// This makes sure that the autonomous stops running when teleop starts running.
		// If you want the autonomous to continue until interrupted by another command,
		// remove this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		//intake.cubeLight.set(Relay.Value.kForward);
		
		//driveTargetCommand = new DriveToTargetStraight(0.15, 0.15);
		
	}
	
	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
		outputCameraToSmartDashboard();
		drivetrain.outputToSmartDashboard();

		//intake.setCubeLight();
		//lift.outputToSmartDashboard();
		//intake.outputToSmartDashboard();
		//intake.cubeLight.set(Relay.Value.kForward);
		//turnTargetCommand.start();
		
		driveWithJoysticks.start();
		tiltWithJoysticks.start();
		liftWithJoysticks.start();
	}
	
	@Override
	public void testPeriodic() {
		
  }
}

