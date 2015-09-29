package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;

/**
 * Settings/Sensors ports state.
 */
public class SensorsState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 */
	public SensorsState(FileManager fileManager) {
		super("Sensors", Asset.ICON_SENSORS,
			new String[] { " Light", " Sonar", " Touch", " Back" },
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