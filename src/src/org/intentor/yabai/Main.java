package org.intentor.yabai;

import org.intentor.yabai.constants.FileName;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.StateManager;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.states.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Program entry.
 */
public class Main {
	/** Program version. */
	public static final String VERSION = "0.4";
	
	public static void main(String[] args) {		
		FileManager file = new FileManager(FileName.DATA_FILE_NAME);
		String data = file.read();
		AiParameters parameters;
		
		if (data.equals("")) {
			parameters = AiParameters.createDefault();
		} else {
			parameters = AiParameters.createFromString(data);
		}	
		
		StateManager stateManager = new StateManager();

		stateManager.add(StateName.HOME, new HomeState(VERSION));
		stateManager.add(StateName.START, new StartState(parameters));
		stateManager.add(StateName.RUNNING, new RunningState(parameters));
		stateManager.add(StateName.SETTINGS, new SettingsState(parameters, file));
		stateManager.add(StateName.SETTINGS_MOTORS, new MotorsState(parameters, file));
		stateManager.add(StateName.SETTINGS_SENSORS, new SensorsState(parameters, file));
		stateManager.add(StateName.SETTINGS_PARAMETERS, new ParametersState(parameters, file));
		stateManager.add(StateName.SETTINGS_SPEED, new SpeedState(parameters, file));
		stateManager.add(StateName.SETTINGS_DIRECTIONS, new DirectionsState(parameters, file));
		stateManager.add(StateName.SETTINGS_LIGHT, new LightState(parameters, file));
		stateManager.add(StateName.SETTINGS_ULTRASONIC, new UltrasonicState(parameters, file));
		stateManager.add(StateName.TEST_LIGHT, new TestLightState(parameters));
		stateManager.add(StateName.TEST_ULTRASONIC, new TestUltrasonicState(parameters));
		
		stateManager.start(StateName.HOME);
		stateManager.run();
	}
}