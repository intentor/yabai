package org.intentor.yabai.behaviors;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.util.LightUtils;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Avoids boundaries by using the light sensor to detect a huge change in color.
 */
public class AvoidBoundary implements Behavior {
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
	/** Color to detect (B/W). */
	private final char color;
	/** Maximum light value to detect black. */
	private final int blackLevel;
	/** Minimum light value to detect white. */
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

	int counter;
	
	@Override
	public boolean takeControl() {
		if (++counter > 10) {
			return LightUtils.checkColor(this.light.readValue(), this.color, this.blackLevel, this.whiteLevel);
		} else {
			return false;
		}
	}

	@Override
	public void suppress() {
		
	}

	@Override
	public void action() {		
		if (this.direction == 'F') {
			this.motorLeft.backward();
			this.motorRight.backward();
		} else {
			this.motorLeft.forward();
			this.motorRight.forward();
		}
		
		this.motorLeft.setSpeed(this.speed);
		this.motorRight.setSpeed(this.speed);
				
		Delay.msDelay(500);
		
		this.motorLeft.stop();
		this.motorRight.stop();
	}
}