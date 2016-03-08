package com.boredream.headerfirst.decorator;

/**
 * 无咖啡因咖啡
 */
public class Decaf extends Beverage {

	public Decaf() {
		// 默认中杯
		setSize(2);
	}
	
	@Override
	public String getDescription() {
		return "Decaf";
	}

	@Override
	public float cost() {
		return 0.50f + getSize() * 0.1f;
	}

}
