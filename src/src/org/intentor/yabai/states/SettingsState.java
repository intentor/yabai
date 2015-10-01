package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.MenuItem;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings home state.
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
	 * @param option The selected option.
	 * @param button The pressed button that selected the option.
	 */
	@Override
	protected void onMenuOptionSelected(int option, Button button) {
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
				if (button == Button.ENTER) {
					this.stateManager.start(StateName.HOME);
				}
			break;
		}
	}
}