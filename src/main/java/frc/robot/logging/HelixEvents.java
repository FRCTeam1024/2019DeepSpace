package frc.robot.logging;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.Timer;

// can view log files at ftp://10.10.24.2/home/lvuser/logs/
public class HelixEvents {
 	private static HelixEvents INSTANCE = new HelixEvents();
 	public static HelixEvents getInstance() {
		return INSTANCE;
	}
 	private HelixEvents() { }
	
	private static final Notifier log = new Notifier(new LogSaver());
	private static Path file;
	private static String loggingLocation = "/home/lvuser/logs/";
	
	private static final BlockingQueue<String> events = new LinkedBlockingDeque<>();
	
	public void startLogging() {
		File usb1 = new File("/media/sda1/");
		if (usb1.exists()) {
			loggingLocation = "/media/sda1/logs/";
		}
		createFile();
		log.startPeriodic(1);
	}
	
	public void addEvent(String subsystem, String event) {
		events.add(
				new StringBuilder()
				.append(Instant.now().toString()).append("\t")
				.append(DriverStation.getInstance().getMatchTime()).append("\t")
				.append("(").append(subsystem).append(")").append("\t")
				.append(event).append("\n")
				.toString());
	}
	
	private static void createLogDirectory() throws IOException {
		File logDirectory = new File(loggingLocation);
		if (!logDirectory.exists()) {
			Files.createDirectory(Paths.get(loggingLocation));
		}
	}
	
	private static void createFile() {
		Writer output = null;
		try {
			createLogDirectory();
			if (DriverStation.getInstance().isFMSAttached()) {
				file = Paths.get(loggingLocation + 
						DriverStation.getInstance().getEventName() + "_"+ 
						DriverStation.getInstance().getMatchType() + 
						DriverStation.getInstance().getMatchNumber() + "Events.txt");
			} else {
				// if we want to timestamp files, use this
				// but we need to figure out how to delete old ones
				// Date now = new Date();
				// StringBuffer sb = new StringBuffer().append(now.getHours())
				// 					.append(":")
				// 					.append(now.getMinutes())
				// 					.append(":")
				// 					.append(now.getSeconds());
				// String timestamp = sb.toString();
				// file = Paths.get(loggingLocation + "testEvents" + timestamp + ".txt");
				 
				// but for now just use one file, which should over-write the last one
				file = Paths.get(loggingLocation + "testEvents.txt");
			}
			if (Files.exists(file)) {
				Files.delete(file);
			}
			Files.createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) { }
			}
		}
	}
	
	private static class LogSaver implements Runnable {
		
		@Override
		public void run() {
			while (events.poll() != null) {
				try {
					String event = events.remove();
			//		System.out.println(event);
					Files.write(file, event.getBytes(), StandardOpenOption.APPEND);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
} 