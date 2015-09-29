package org.intentor.yabai.states;

import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.core.data.FileManager;

/**
 * Settings home state.
 */
public class SettingsState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 */
	public SettingsState(FileManager fileManager) {
		super("Settings", Asset.ICON_SETTINGS,
			new String[] { " Motors", " Sensors", " Parameters", " Speed", " Back" },
			fileManager);
	}
	
	/**
	 * Called when a menu item is selected.
	 * 
	 * @param option The selected option.
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
				this.stateManager.start(StateName.HOME);
			break;
		}
	}
}