/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

/**
 * Stops the program.
 */
public class StopProgram implements Behavior {
	private boolean suppressed = false;

	@Override
	public boolean takeControl() {
		int key = Button.readButtons();
		return (key == Button.ID_ESCAPE);
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		Motor.A.stop();
		Motor.B.stop();
		
		System.exit(0);
	}
}