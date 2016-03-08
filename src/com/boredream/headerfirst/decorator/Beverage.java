package com.boredream.headerfirst.decorator;

/**
 * ���ϻ���
 */
public abstract class Beverage {

	/**
	 * 1С 2�� 3��
	 */
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private String description = "Unkown beverage";

	public String getDescription() {
		return description;
	}

	public abstract float cost();
}
