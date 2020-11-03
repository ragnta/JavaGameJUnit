package com.application.demo.core.event;

import com.application.demo.core.Tamagochi;

public interface Listener {

	/**
	 * called by EventPublisher
	 * 
	 * @param t
	 */
	void removeByTamagochi(Tamagochi t);
	
	/**
	 * called by EventPublisher
	 * @param t
	 */
	void addTamagochi(Tamagochi t);
}
