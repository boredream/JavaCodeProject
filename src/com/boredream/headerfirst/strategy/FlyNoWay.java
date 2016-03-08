package com.boredream.headerfirst.strategy;

public class FlyNoWay implements Flyable {

	@Override
	public void fly() {
		System.out.println("I can't fly! But I belive I can!");
	}

}
