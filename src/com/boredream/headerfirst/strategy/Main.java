package com.boredream.headerfirst.strategy;

public class Main {

	public static void main(String[] args) {
		Duck duck = new ModelDuck();
		duck.display();
		duck.performFly();
		
		duck.setFlyable(new FlyRocketPower());
		duck.performFly();
	}
}
