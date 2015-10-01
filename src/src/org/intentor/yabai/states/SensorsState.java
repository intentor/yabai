package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings/Sensors ports state.
 */
public class SensorsState extends OptionsState {
	/** Sensor ports. */
	private static final String[] SENSOR_PORTS = new String[] { "1", "2", "3", "4" };
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public SensorsState(AiParameters parameters, FileManager fileManager) {
		super("Sensors", Asset.ICON_SENSORS,
			new MenuItem[] { 
				new MenuListItem("Light", String.valueOf(parameters.sensorLight), SENSOR_PORTS),
				new MenuListItem("Sonar", String.valueOf(parameters.sensorUltrasonic), SENSOR_PORTS),
				new MenuListItem("Touch", String.valueOf(parameters.sensorTouch), SENSOR_PORTS),
				new MenuItem("Back")
			}, parameters, fileManager);
	}
	
	/**
	 * Called when a menu option is selected.
	 * 
	 * @param option The selected option.
	 * @param button The pressed button that selected the option.
	 */
	@Override
	protected void onMenuOptionSelected(int option, Button button) {
		switch (option) {
			case 0:
				
			break;
			case 1:
				
			break;
			case 2:
				
			break;
			case 3:
				if (button == Button.ENTER) {
					this.stateManager.start(StateName.SETTINGS);
				}
			break;
		}
	}
}