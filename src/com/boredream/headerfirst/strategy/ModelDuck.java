package com.boredream.headerfirst.strategy;

public class ModelDuck extends Duck {

	public ModelDuck() {
		flyable = new FlyNoWay();
	}
	
	@Override
	public void display() {
		System.out.println("looks like model");
	}

}
