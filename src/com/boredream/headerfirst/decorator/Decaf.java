package com.boredream.headerfirst.decorator;

/**
 * �޿����򿧷�
 */
public class Decaf extends Beverage {

	public Decaf() {
		// Ĭ���б�
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
