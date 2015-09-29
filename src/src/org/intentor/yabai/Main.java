package org.intentor.yabai;

import org.intentor.yabai.constants.FileName;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.StateManager;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.states.*;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Main {
	/** Program version. */
	public static final String VERSION = "0.1";
	
	public static void main(String[] args) {		
		FileManager file = new FileManager(FileName.DATA_FILE_NAME);
		StateManager stateManager = new StateManager();		
		
		stateManager.add(StateName.HOME, new HomeState(VERSION));
		stateManager.add(StateName.RUNNING, new RunningState());
		stateManager.add(StateName.SETTINGS, new SettingsState(file));
		stateManager.add(StateName.SETTINGS_MOTORS, new MotorsState(file));
		stateManager.add(StateName.SETTINGS_SENSORS, new SensorsState(file));
		stateManager.add(StateName.SETTINGS_PARAMETERS, new ParametersState(file));
		stateManager.add(StateName.SETTINGS_SPEED, new SpeedState(file));
		
		stateManager.start(StateName.HOME);
		stateManager.run();
	}
}
