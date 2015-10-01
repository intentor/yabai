package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.MenuItem;

/**
 * Settings/Motors ports state.
 */
public class MotorsState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 */
	public MotorsState(FileManager fileManager) {
		super("Motors", Asset.ICON_MOTORS, 
			new MenuItem[] { 
				new MenuItem("Left"),
				new MenuItem("Right"),
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
				if (button == Button.ENTER) {
					this.stateManager.start(StateName.SETTINGS);
				}
			break;
		}
	}
}
