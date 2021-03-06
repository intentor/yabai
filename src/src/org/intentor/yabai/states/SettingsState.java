package org.intentor.yabai.states;

import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.MenuItem;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Displays the main settings menu.
 */
public class SettingsState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public SettingsState(AiParameters parameters, FileManager fileManager) {
		super("Settings", Asset.ICON_SETTINGS,
			new MenuItem[] { 
				new MenuItem("Motors"),
				new MenuItem("Sensors"),
				new MenuItem("Parameters"),
				new MenuItem("Speed"),
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
		switch (option) {
			case 0:
				this.stateManager.start(StateName.SETTINGS_MOTORS);
			break;
			case 1:
				this.stateManager.start(StateName.SETTINGS_SENSORS);
			break;
			case 2:
				this.stateManager.start(StateName.SETTINGS_PARAMETERS);
			break;
			case 3:
				this.stateManager.start(StateName.SETTINGS_SPEED);
			break;
			case 4:
				//Saves settings.
				this.file.write(this.parameters.toString());
				
				this.stateManager.start(StateName.HOME);
			break;
		}
	}
}