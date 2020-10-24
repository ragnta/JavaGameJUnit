package com.application.demo;

public class Tamagochi {

	public static final int DEFAULT_VALUE = 5;
	public static final int MAX_FUN = 10;
	public static final int MAX_CLEAN = 10;
	public static final int MAX_HUNGRY = 10;

	public static final int STATE_CHANGE = 30;

	private int fun;
	private int clean;
	private int hungry;
	private int counter = 0;

	public Tamagochi() {
		super();
		this.fun = DEFAULT_VALUE;
		this.clean = DEFAULT_VALUE;
		this.hungry = DEFAULT_VALUE;
	}

	public boolean isAlive() {
		return fun > 0 && clean > 0 && hungry > 0;
	}

	public void update() {
		counter++;
		if (counter == STATE_CHANGE) {
			fun--;
			clean--;
			hungry--;
			counter = 0;
		}
	}

	public void play() {

		clean = clean - 2;
		hungry--;
		fun = fun + 2;
	}

	public void wash() {
		clean = clean + 3;
		hungry--;
		fun--;
	}

	public void feed() {
		hungry = hungry + 2;
		clean = clean - 2;
		fun++;
	}
	
	public int getFun() {
		return fun;
	}
	
	public int getHungry() {
		return hungry;
	}
	
	public int getClean() {
		return clean;
	}

}
