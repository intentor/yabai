package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;

/**
 * Settings/Motors ports state.
 */
public class MotorsState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 */
	public MotorsState() {
		super("Motors", Asset.ICON_MOTORS,
			new String[] { " Left", " Right", " Back" });
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
				this.stateManager.start(StateName.SETTINGS);
			break;
		}
	}
}
