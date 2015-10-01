package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.MenuItem;

/**
 * Settings/Parameters state.
 */
public class ParametersState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 */
	public ParametersState(FileManager fileManager) {
		super("Parameters", Asset.ICON_PARAMETERS,
			new MenuItem[] { 
				new MenuItem("Timer"),
				new MenuItem("Color"),
				new MenuItem("Sonar"),
				new MenuItem("Back")
			}, fileManager);
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