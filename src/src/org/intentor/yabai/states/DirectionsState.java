package org.intentor.yabai.states;

import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.MovementDirection;
import org.intentor.yabai.constants.RotationDirection;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.util.*;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Settings/Directions configurations view.
 */
public class DirectionsState extends OptionsState {
	/** Forward direction. */
	private static final String[] FORWARD_DIRECTION = new String[] { 
		String.valueOf(MovementDirection.FORWARD), 
		String.valueOf(MovementDirection.BACKWARD)
	};
	/** Rotation direction. */
	private static final String[] ROTATION_DIRECTION = new String[] { 
		String.valueOf(RotationDirection.LEFT), 
		String.valueOf(RotationDirection.RIGHT)
	};
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileManager File manager.
	 * @param parameters AI parameters.
	 */
	public DirectionsState(AiParameters parameters, FileManager fileManager) {
		super("Speed", Asset.ICON_DIRECTIONS,
			new MenuItem[] { 
				new MenuListItem("Forward", String.valueOf(parameters.forward), FORWARD_DIRECTION),
				new MenuListItem("Rotation", String.valueOf(parameters.rotation), ROTATION_DIRECTION),
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
		if (option == 2) {
			//Updates settings.
			this.parameters.forward = this.menuItems[0].getValue().charAt(0);
			this.parameters.rotation = this.menuItems[1].getValue().charAt(0);
			
			this.stateManager.start(StateName.SETTINGS);
		}
	}
}