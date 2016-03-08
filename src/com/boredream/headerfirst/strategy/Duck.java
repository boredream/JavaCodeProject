package com.boredream.headerfirst.strategy;

public abstract class Duck {

	protected Quackable quackable;
	protected Flyable flyable;
	
	public void setFlyable(Flyable flyable) {
		this.flyable = flyable;
	}

	public void performQuack(){
		quackable.quack();
	}
	
	public void performFly(){
		flyable.fly();
	}
	
	public abstract void display();
	
}
