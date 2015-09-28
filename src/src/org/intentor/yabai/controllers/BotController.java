package org.intentor.yabai.controllers;

import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.behaviours.*;

/**
 * Controls the bot.
 */
public class BotController {
	/**
	 * Starts the bot program.
	 */
	public void Start() {
		SensorPort ultrasonicPort = SensorPort.S1;
		int detectDistance = 30;

		Behavior searching = new Searching(ultrasonicPort, detectDistance);
		Behavior driveForward = new DriveForward(ultrasonicPort, detectDistance);
		Behavior stopProgram = new StopProgram();

		Behavior [] behaviours = { searching, driveForward, stopProgram};
		Arbitrator arbitrator = new Arbitrator(behaviours);
		arbitrator.start();
	}
	
	/**
	 * Stops the bot program.
	 */
	public void Stop() {
		
	}
}
