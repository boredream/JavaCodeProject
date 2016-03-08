package com.boredream.headerfirst.strategy;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyable = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("looks like mallard");
	}

}
