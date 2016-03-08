package com.boredream.headerfirst.decorator;

/**
 * ��ʽŨ������
 */
public class Espresso extends Beverage {

	public Espresso() {
		// Ĭ��С��
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
