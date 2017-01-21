package org.usfirst.frc.team9817.robot;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	VideoCapture camera;
	@Override
	public void robotInit() {
		System.load("/usr/local/lib/lib_OpenCV/java/libopencv_java2410.so");
		System.out.println("Hello, OpenCV");
		// Load the native library.
		camera = new VideoCapture(0);
		camera.open(0);
		if(!camera.isOpened()){
			SmartDashboard.putString("camera working?","Camera Error");
		}
		else{
			SmartDashboard.putString("camera working?","Camera OK?");
		}

	}

	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Mat frame = new Mat();


		camera.read(frame);


		SmartDashboard.putNumber("Captured Frame Width ", frame.width());
		SmartDashboard.putNumber("Captured Frame Height ", frame.height());


		Highgui.imwrite("camera.jpg", frame);

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

