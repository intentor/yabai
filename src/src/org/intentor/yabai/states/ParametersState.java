package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;

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
			new String[] { " Timer", " Color", " Sonar", " Back" },
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
				
			break;
			case 1:
				
			break;
			case 2:
				
			break;
			case 3:
				this.stateManager.start(StateName.SETTINGS);
			break;
		}
	}
}