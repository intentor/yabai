package org.intentor.yabai.states;

import lejos.nxt.Button;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings/Motors ports state.
 */
public class MotorsState extends OptionsState {
	/** Motor ports. */
	private static final String[] MOTOR_PORTS = new String[] { "A", "B", "C" };
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public MotorsState(AiParameters parameters, FileManager fileManager) {
		super("Motors", Asset.ICON_MOTORS, 
			new MenuItem[] { 
				new MenuListItem("Left", String.valueOf(parameters.motorLeft), MOTOR_PORTS),
				new MenuListItem("Right", String.valueOf(parameters.motorRight), MOTOR_PORTS),
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
		if (option == 2) {
			//Updates settings.
			this.parameters.motorLeft = this.menuItems[0].getValue().charAt(0);
			this.parameters.motorRight = this.menuItems[1].getValue().charAt(0);
			
			this.stateManager.start(StateName.SETTINGS);
		}
	}
}
