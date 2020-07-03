package com.boredream.headerfirst.decorator;

/**
 * 饮料基类
 */
public abstract class Beverage {

	/**
	 * 1小 2中 3大
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
