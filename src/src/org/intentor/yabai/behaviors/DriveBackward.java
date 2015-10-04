package org.intentor.yabai.behaviors;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Drives the robot backward.
 */
public class DriveBackward implements Behavior {
	/** Indicates whether the behaviour has been supressed. */
	private boolean suppressed = false;
	/** Left motor. */
	private final NXTRegulatedMotor motorLeft;
	/** Right motor. */
	private final NXTRegulatedMotor motorRight;
	/** Driving speed. */
	private final int speed;
	/** Driving direction (F/B). */
	private final char direction;
	/** Touch sensor. */
	private final TouchSensor touch;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters to configure the behaviour.
	 */
	public DriveBackward(AiParameters parameters) {
		MotorPort motorLeftPort = DataConverter.motorPortFromChar(parameters.motorLeft);
		MotorPort motorRightPort = DataConverter.motorPortFromChar(parameters.motorRight);
		SensorPort touchPort = DataConverter.sensorPortFromInt(parameters.sensorTouch);
		
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.speed = parameters.speedBackward;
		this.direction = parameters.forward;
		this.touch = new TouchSensor(touchPort);
	}

	@Override
	public boolean takeControl() {
		return this.touch.isPressed();
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		this.motorLeft.setSpeed(this.speed);
		this.motorRight.setSpeed(this.speed);
	
		if (this.direction == 'F') {
			this.motorLeft.backward();
			this.motorRight.backward();
		} else {
			this.motorLeft.forward();
			this.motorRight.forward();
		}
		
		while (!this.suppressed && this.touch.isPressed()) {
			LCD.drawString("Backward...", 0, 3);
			Thread.yield();
		}
	}
}