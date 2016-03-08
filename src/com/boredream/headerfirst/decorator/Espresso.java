package com.boredream.headerfirst.decorator;

/**
 * 意式浓缩咖啡
 */
public class Espresso extends Beverage {

	public Espresso() {
		// 默认小杯
		setSize(1);
	}

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public float cost() {
		return 1.00f + getSize() * 0.3f;
	}

}
