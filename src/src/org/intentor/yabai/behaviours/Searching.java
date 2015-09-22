/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

/**
 * Searches for a target.
 */
public class Searching implements Behavior {
	private boolean suppressed = false;
	private UltrasonicSensor sonar;
	private int detectDistance;
	
	public Searching(SensorPort port, int detectDistance) {
		this.sonar = new UltrasonicSensor(port);
		this.detectDistance = detectDistance;
	}

	@Override
	public boolean takeControl() {
		LCD.drawInt(this.sonar.getDistance(), 2, 2);
		return (this.sonar.getDistance() > this.detectDistance);
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public void action() {
		this.suppressed = false;

		Motor.A.setSpeed(1080);
		Motor.B.setSpeed(1080);
		Motor.A.forward();
		Motor.B.backward();
		
		while (!this.suppressed) {
			Thread.yield();
		};
	}
}
