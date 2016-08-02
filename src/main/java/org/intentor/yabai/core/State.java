package org.intentor.yabai.core;

import javax.microedition.lcdui.Graphics;

/**
 * Base state.
 */
public abstract class State {
	/** State ID. */
	protected String id;
	/** Reference to the state manager. */
	protected StateManager stateManager;
	/** Graphics object. */
	protected Graphics graphics = new Graphics();
	
	/**
	 * Sets the state ID.
	 * 
	 * @param value State ID.
	 */
	public void setId(String value) {
		this.id = value;
	}
	
	/**
	 * Gets the state ID.
	 * 
	 * @return State ID.
	 */
	public String getId() {
		return this.id;		
	}
	
	/**
	 * Sets the state manager.
	 * 
	 * @param value State manager.
	 */
	public void setStateManager(StateManager value) {
		this.stateManager = value;
	}
	
	/**
	 * Called when the state is being started.
	 */
	public void onStart() {
		
	}
	
	/**
	 * Updates/renders the state.
	 */
	public abstract void update();
	
	/**
	 * Called when the state is being finished.
	 */
	public void onFinished() {
		
	}
}