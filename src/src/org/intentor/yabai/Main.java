package org.intentor.yabai;

import lejos.nxt.*;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.behaviours.*;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Intentor Sumo");

		while (true) {
			int key = Button.readButtons();
			
			switch (key) {
				case Button.ID_ESCAPE:
					return;
				case Button.ID_ENTER:
					SensorPort ultrasonicPort = SensorPort.S1;
					int detectDistance = 30;
					
					Behavior searching = new Searching(ultrasonicPort, detectDistance);
					Behavior driveForward = new DriveForward(ultrasonicPort, detectDistance);
					Behavior stopProgram = new StopProgram();
					
					Behavior [] behaviours = { searching, driveForward, stopProgram};
					Arbitrator arbitrator = new Arbitrator(behaviours);
					arbitrator.start();
				break;
			}
		}
	}
}
