package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings/Speed configurations view.
 */
public class SpeedState extends OptionsState {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public SpeedState(AiParameters parameters, FileManager fileManager) {
		super("Speed", Asset.ICON_SPEED,
			new MenuItem[] { 
				new MenuIntItem("Front", parameters.speedForward, 180, 2160, 30),				
				new MenuIntItem("Back", parameters.speedBackward, 180, 2160, 30),
				new MenuIntItem("Rotate", parameters.speedRotation, 180, 2160, 30),
				new MenuItem("Back")
			}, parameters, fileManager);
	}
	
	
	
	/**
	 * Called when a menu option is selected.
	 * 
	 * @param option The selected option.
	 */
	@Override
	protected void onMenuOptionSelected(int option) {
		if (option == 3) {
			//Updates settings.
			this.parameters.speedForward = Integer.parseInt(this.menuItems[0].getValue());
			this.parameters.speedBackward = Integer.parseInt(this.menuItems[1].getValue());
			this.parameters.speedRotation = Integer.parseInt(this.menuItems[2].getValue());
			
			this.stateManager.start(StateName.SETTINGS);
		}
	}
}