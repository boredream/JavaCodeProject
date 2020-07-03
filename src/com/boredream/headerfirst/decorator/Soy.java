package com.boredream.headerfirst.decorator;

/**
 * ����װ��-����
 */
public class Soy extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// ί�и��µ�getDescription����,��ԭ�л���������µ�����
		return beverage.getDescription() + " ,add Soy";
	}

	@Override
	public float cost() {
		// ί�и��µ�cost����,��ԭ�л��������һ�����
		return beverage.cost() + 0.05f * (beverage.getSize()+1);
	}
	
	@Override
	public int getSize() {
		return beverage.getSize();
	}

	@Override
	public void setSize(int size) {
		beverage.setSize(size);
	}
}
