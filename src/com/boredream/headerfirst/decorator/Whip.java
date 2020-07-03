package com.boredream.headerfirst.decorator;

/**
 * 饮料装饰-奶泡
 */
public class Whip extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		// 委托给新的getDescription方法,在原有基础上添加新的描述
		return beverage.getDescription() + " ,add Whip";
	}

	@Override
	public float cost() {
		// 委托给新的cost方法,在原有基础上添加一定金额
		return beverage.cost() + 0.10f;
	}

}
