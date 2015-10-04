package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings/Parameters/Light state.
 */
public class LightState extends OptionsState {
	/** Light sensor color values. */
	private static final String[] COLOR_VALUES = new String[] { "W", "B" };
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public LightState(AiParameters parameters, FileManager fileManager) {
		super("Light", Asset.ICON_LIGHT,
			new MenuItem[] {
				new MenuListItem("Color", String.valueOf(parameters.color), COLOR_VALUES),
				new MenuIntItem("Black", parameters.blackLevel, 0, 100, 1),
				new MenuIntItem("White", parameters.whiteLevel, 0, 100, 1),
				new MenuItem("Back")
			}, parameters, fileManager);
	}
	
	/**
	 * Called when a menu option is selected.
	 * 
	 * @param option Selected option.
	 */
	@Override
	protected void onMenuOptionSelected(int option) {
		if (option == 3) {
			//Updates settings.
			this.parameters.color = this.menuItems[0].getValue().charAt(0);
			this.parameters.blackLevel = Integer.parseInt(this.menuItems[1].getValue());
			this.parameters.whiteLevel = Integer.parseInt(this.menuItems[2].getValue());
			
			this.stateManager.start(StateName.SETTINGS_PARAMETERS);
		}
	}
}