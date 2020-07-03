package com.boredream.headerfirst.decorator;

/**
 * 饮料装饰-豆浆
 */
public class Soy extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// 委托给新的getDescription方法,在原有基础上添加新的描述
		return beverage.getDescription() + " ,add Soy";
	}

	@Override
	public float cost() {
		// 委托给新的cost方法,在原有基础上添加一定金额
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
