package com.application.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTamagochi {

	private Tamagochi tamagochi;

	@BeforeEach
	public void initTamagotchi() {
		tamagochi = new Tamagochi();
	}

	@Test
	public void testKillTamagochi() {
		for (int i = 0; i < Tamagochi.DEFAULT_VALUE * Tamagochi.STATE_CHANGE; i++) {
			tamagochi.update();
		}
		assertFalse(tamagochi.isAlive());
	}

	@Test
	public void testPlayWithTamagotchi() {
		int expectedClean = Tamagochi.DEFAULT_VALUE - 2;
		int expectedHungry = Tamagochi.DEFAULT_VALUE - 1;
		int expectedFun = Tamagochi.DEFAULT_VALUE + 2;

		tamagochi.play();

		assertEquals(expectedClean, tamagochi.getClean());
		assertEquals(expectedHungry, tamagochi.getHungry());
		assertEquals(expectedFun, tamagochi.getFun());
	}

	@Test
	public void testFeedWithTamagotchi() {
		int expectedClean = Tamagochi.DEFAULT_VALUE - 2;
		int expectedHungry = Tamagochi.DEFAULT_VALUE + 2;
		int expectedFun = Tamagochi.DEFAULT_VALUE + 1;

		tamagochi.feed();

		assertEquals(expectedClean, tamagochi.getClean());
		assertEquals(expectedHungry, tamagochi.getHungry());
		assertEquals(expectedFun, tamagochi.getFun());
	}

	@Test
	public void testWashWithTamagotchi() {
		int expectedClean = Tamagochi.DEFAULT_VALUE + 3;
		int expectedHungry = Tamagochi.DEFAULT_VALUE - 1;
		int expectedFun = Tamagochi.DEFAULT_VALUE - 1;

		tamagochi.wash();

		assertEquals(expectedClean, tamagochi.getClean());
		assertEquals(expectedHungry, tamagochi.getHungry());
		assertEquals(expectedFun, tamagochi.getFun());
	}
	
	@Test
	public void testKillTamagotchiByHunger() {
		int expcetedFun = 8;
		int expcetedClean = 8;
		int expectedHungry = -1;

		tamagochi.wash();
		tamagochi.play();
		tamagochi.wash();
		tamagochi.play();
		tamagochi.wash();
		tamagochi.play();
		
		assertFalse(tamagochi.isAlive());
		assertEquals(expcetedClean, tamagochi.getClean());
		assertEquals(expcetedFun , tamagochi.getFun());
		assertEquals(expectedHungry, tamagochi.getHungry());
	}
	
	@Test
	public void testKillTamagotchiByClean() {
		int expcetedFun = 8;
		int expcetedClean = -1;
		int expectedHungry = 11;

		tamagochi.feed();
		tamagochi.feed();
		tamagochi.feed();
		
		assertFalse(tamagochi.isAlive());
		assertEquals(expcetedClean, tamagochi.getClean());
		assertEquals(expcetedFun , tamagochi.getFun());
		assertEquals(expectedHungry, tamagochi.getHungry());
	}

	@Test
	public void testKillTamagotchiByFun() {
		

		// TODO 
	}
	
}
