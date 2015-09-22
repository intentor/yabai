package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

/**
 * Drives the robot forward.
 */
public class DriveForward implements Behavior {
	private boolean suppressed = false;
	private UltrasonicSensor sonar;
	private int detectDistance;
	
	public DriveForward(SensorPort port, int detectDistance) {
		this.sonar = new UltrasonicSensor(port);
		this.detectDistance = detectDistance;
	}

	@Override
	public boolean takeControl() {
		LCD.drawInt(this.sonar.getDistance(), 2, 1);
		return (this.sonar.getDistance() <= this.detectDistance);
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public void action() {
		this.suppressed = false;

		Motor.A.setSpeed(1440);
		Motor.B.setSpeed(1440);
		Motor.A.backward();
		Motor.B.backward();
		
		int distance = this.sonar.getDistance();
		while (!this.suppressed || distance <= this.detectDistance) {
			distance = this.sonar.getDistance();
			LCD.drawInt(distance, 2, 1);
			Thread.yield();
		}
	}
}
