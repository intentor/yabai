package org.intentor.yabai.states;

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
	 * @param option Selected option.
	 */
	@Override
	protected void onMenuOptionSelected(int option) {
		if (option == 3) {
			//Updates settings.
			this.parameters.sensorLight = Integer.parseInt(this.menuItems[0].getValue());
			this.parameters.sensorUltrasonic = Integer.parseInt(this.menuItems[1].getValue());
			this.parameters.sensorTouch = Integer.parseInt(this.menuItems[2].getValue());
			
			this.stateManager.start(StateName.SETTINGS);
		}
	}
}