package com.application.demo.core;

import java.util.ArrayList;
import java.util.List;

import com.application.demo.core.event.EventPublisher;

public class TamagochiGraveyard {

	private List<Tamagochi> tamagochiList;
	private EventPublisher ep;
	
	public TamagochiGraveyard(EventPublisher ep) {
		this.ep=ep;
		tamagochiList = new ArrayList<>();
	}
	
	public void update() {
		checkDeathTamagochi();
		for(Tamagochi t : tamagochiList) {
			t.update();
		}
	}
	
	/**
	 * check every tamagochi, if a tamagochi is dead, trigger a remove event
	 */
	private void checkDeathTamagochi() {
		List<Tamagochi> tmp = new ArrayList<>();
		for(Tamagochi t: tamagochiList) {
			if(!t.isAlive()) {
				ep.triggerRemove(t);
				tmp.add(t);
			}
		}
		for(Tamagochi removable: tmp) {
			tmp.remove(removable);
		}
	}
	
	/**
	 * add a new Tamagochi and trigger an add event
	 * @param name
	 */
	public void add(String name) {
		Tamagochi t = new Tamagochi(name);
		tamagochiList.add(t);
		ep.triggerAdd(t);
	}
}
