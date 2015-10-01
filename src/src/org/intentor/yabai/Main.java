package org.intentor.yabai;

import org.intentor.yabai.constants.FileName;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.StateManager;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.states.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Main {
	/** Program version. */
	public static final String VERSION = "0.1";
	
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
		stateManager.add(StateName.RUNNING, new RunningState());
		stateManager.add(StateName.SETTINGS, new SettingsState(parameters, file));
		stateManager.add(StateName.SETTINGS_MOTORS, new MotorsState(parameters, file));
		stateManager.add(StateName.SETTINGS_SENSORS, new SensorsState(parameters, file));
		stateManager.add(StateName.SETTINGS_PARAMETERS, new ParametersState(parameters, file));
		stateManager.add(StateName.SETTINGS_SPEED, new SpeedState(parameters, file));
		
		stateManager.start(StateName.HOME);
		stateManager.run();
	}
}
