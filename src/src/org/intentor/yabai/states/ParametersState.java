package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Configures general parameters.
 */
public class ParametersState extends OptionsState {
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public ParametersState(AiParameters parameters, FileManager fileManager) {
		super("Parameters", Asset.ICON_PARAMETERS,
			new MenuItem[] { 
				new MenuIntItem("Timer", parameters.timer, 1, 20, 1),
				new MenuItem("Light"),
				new MenuItem("Ultrasonic"),
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
		if (option == 1) {
			this.stateManager.start(StateName.SETTINGS_LIGHT);
		} else if (option == 2) {
			this.stateManager.start(StateName.SETTINGS_ULTRASONIC);
		} else if (option == 3) {
			//Updates settings.
			this.parameters.timer = Integer.parseInt(this.menuItems[0].getValue());
			
			this.stateManager.start(StateName.SETTINGS);
		}
	}
}