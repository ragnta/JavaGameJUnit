package com.application.demo.core.event;

import java.util.ArrayList;
import java.util.List;

import com.application.demo.core.Tamagochi;

/**
 * eventpublisher which contains all listener.
 * 
 * 
 * @author ragnt
 *
 */
public class EventPublisher {

	private List<Listener> listenerList;
	
	/**
	 * trigger remove event
	 * 
	 * call removeByTamagochi method of all SUBSCRIBED listener
	 * 
	 * @param t
	 */
	public void triggerRemove(Tamagochi t) {
		for(Listener listener: listenerList) {
			listener.removeByTamagochi(t);
		}
	}
	
	/**
	 * trigger add event
	 * 
	 * call addTamagochi method of all SUBSCRIBED listener
	 * 
	 * @param t
	 */
	public void triggerAdd(Tamagochi t) {
		for(Listener listener: listenerList) {
			listener.addTamagochi(t);
		}
	}
	
	/**
	 * Add new Listener
	 * @param listener
	 */
	public void addListener(Listener listener) {
		if(listenerList == null) {
			listenerList = new ArrayList<>();
		}
		listenerList.add(listener);
	}

	
}
