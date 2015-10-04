package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Avoids boundaries by using the light sensor to detect a huge change in color.
 */
public class AvoidBoundary implements Behavior {	
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
	/** Light sensor. */
	private final LightSensor light;
	/** The color to detect (B/W). */
	private final char color;
	/** Maximum value to detect black. */
	private final int blackLevel;
	/** Minimum value to detect white. */
	private final int whiteLevel;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters to configure the behaviour.
	 */
	public AvoidBoundary(AiParameters parameters) {
		MotorPort motorLeftPort = DataConverter.motorPortFromChar(parameters.motorLeft);
		MotorPort motorRightPort = DataConverter.motorPortFromChar(parameters.motorRight);
		SensorPort lightPort = DataConverter.sensorPortFromInt(parameters.sensorLight);
		
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.speed = parameters.speedForward;
		this.direction = parameters.forward;
		this.light = new LightSensor(lightPort);
		this.color = parameters.color;
		this.blackLevel = parameters.blackLevel;
		this.whiteLevel = parameters.whiteLevel;
	}

	@Override
	public boolean takeControl() {
		return this.checkBoundary();
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
		
		LCD.drawString("Boundary! (" + String.valueOf(this.light.readValue()) + ")", 0, 3);			
		Delay.msDelay(1000);
	}
	
	/**
	 * Checks whether a boundary is detected.
	 * 
	 * @return Boolean value indicating whether the boundary has been detected.
	 */
	private Boolean checkBoundary() {
		int lightValue = this.light.readValue();
		
		if (this.color == 'B') {
			return (lightValue <= this.blackLevel);
		} else {
			return (lightValue >= this.whiteLevel);
		}
	}
}