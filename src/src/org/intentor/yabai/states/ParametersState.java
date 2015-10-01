package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings/Parameters state.
 */
public class ParametersState extends OptionsState {
	/** Light sensor color values. */
	private static final String[] COLOR_VALUES = new String[] { "W", "B" };
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public ParametersState(AiParameters parameters, FileManager fileManager) {
		super("Parameters", Asset.ICON_PARAMETERS,
			new MenuItem[] { 
				new MenuIntItem("Timer", parameters.timer, 1, 20, 1),
				new MenuListItem("Color", parameters.color, COLOR_VALUES),
				new MenuIntItem("Sonar", parameters.detectionDistance, 5, 170, 5),
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
			this.parameters.timer = Integer.parseInt(this.menuItems[0].getValue());
			this.parameters.color = this.menuItems[1].getValue();
			this.parameters.detectionDistance = Integer.parseInt(this.menuItems[2].getValue());
			
			this.stateManager.start(StateName.SETTINGS);
		}
	}
}