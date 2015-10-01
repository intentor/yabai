package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.MenuTextItem;

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
			new MenuTextItem[] { 
				new MenuTextItem("Light"),
				new MenuTextItem("Sonar"),
				new MenuTextItem("Touch"),
				new MenuTextItem("Back")
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