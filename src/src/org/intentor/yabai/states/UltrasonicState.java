package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Configures the ultrasonic sensor.
 */
public class UltrasonicState extends OptionsState {	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public UltrasonicState(AiParameters parameters, FileManager fileManager) {
		super("Ultrasonic", Asset.ICON_ULTRASONIC,
			new MenuItem[] {
				new MenuIntItem("Distance", parameters.detectionDistance, 5, 170, 5),
				new MenuItem("Test"),
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
		//Updates settings.
		this.parameters.detectionDistance = Integer.parseInt(this.menuItems[0].getValue());
			
		if (option == 1) {
			this.stateManager.start(StateName.TEST_ULTRASONIC);
		} else if (option == 2) {			
			this.stateManager.start(StateName.SETTINGS_PARAMETERS);
		}
	}
}