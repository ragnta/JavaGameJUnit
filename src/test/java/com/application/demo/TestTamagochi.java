package com.application.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTamagochi {

	private Tamagochi tamagochi;

	/**
	 * Create a new tamagochi instance for the test. 
	 * We will have a fresh instance in every testcase because of this.
	 * If we don't use the BeforeEach, we have to start the test with the following line:
	 *   `tamagochi = new Tamagochi();`
	 */
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

		assertTrue(tamagochi.isAlive());
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

		assertTrue(tamagochi.isAlive());
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

		assertTrue(tamagochi.isAlive());
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
		int expcetedFun = 0;
		int expcetedClean = 22;
		int expectedHungry = 2;

		tamagochi.feed();
		tamagochi.feed();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();

		
		assertFalse(tamagochi.isAlive());
		assertEquals(expcetedClean, tamagochi.getClean());
		assertEquals(expcetedFun , tamagochi.getFun());
		assertEquals(expectedHungry, tamagochi.getHungry());
	}
	
	@Test
	public void testKillTamagotchiByFunAndHunger() {
		int expcetedFun = -2;
		int expcetedClean = 28;
		int expectedHungry = 0;

		tamagochi.feed();
		tamagochi.feed();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		tamagochi.wash();
		
		assertFalse(tamagochi.isAlive());
		assertEquals(expcetedClean, tamagochi.getClean());
		assertEquals(expcetedFun , tamagochi.getFun());
		assertEquals(expectedHungry, tamagochi.getHungry());
	}

	
}
