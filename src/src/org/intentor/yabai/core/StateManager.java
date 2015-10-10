package org.intentor.yabai.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages states.
 */
public final class StateManager {
	/** Added states. */
	private final Map<String, State> states;
	/** Current state. */
	private State currentState;
	
	/**
	 * Creates a new instance of the class.
	 */
	public StateManager() {
		this.states = new HashMap<String, State>();
	}
	
	/**
	 * Adds a state to the manager.
	 * 
	 * @param id State ID.
	 * @param state State to be added.
	 */
	public void add(String id, State state) {
		state.setId(id);
		state.setStateManager(this);
		this.states.put(id, state);
	}
	
	/**
	 * Makes the state manager to run.
	 */
	public void run() {
		while (true) {
			if (this.currentState != null) {
				this.currentState.update();
			}
		}
	}
	
	/**
	 * Starts the given state.
	 * 
	 * @param id State ID.
	 */
	public void start(String id) {		
		this.currentState = this.states.get(id);
		this.currentState.onStart();
	}
}