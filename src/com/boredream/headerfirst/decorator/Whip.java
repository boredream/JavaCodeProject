package com.boredream.headerfirst.decorator;

/**
 * ����װ��-����
 */
public class Whip extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// ί�и��µ�getDescription����,��ԭ�л���������µ�����
		return beverage.getDescription() + " ,add Whip";
	}

	@Override
	public float cost() {
		// ί�и��µ�cost����,��ԭ�л��������һ�����
		return beverage.cost() + 0.10f;
	}

}
