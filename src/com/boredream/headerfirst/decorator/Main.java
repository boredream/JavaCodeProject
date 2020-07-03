package com.boredream.headerfirst.decorator;

public class Main {

	public static void main(String[] args) {
		// ԭζDecaf
		Beverage beverage1 = new Decaf();
		System.out.println(beverage1.getSize() + " ... " + beverage1.cost() + " ... " + beverage1.getDescription());
		
		// �������,��������ʽŨ������
		Beverage beverage2 = new Espresso();
		beverage2.setSize(2);
		System.out.println(beverage2.getSize() + " ... " + beverage2.cost() + " ... " + beverage2.getDescription());
		beverage2 = new Soy(beverage2);
		System.out.println(beverage2.getSize() + " ... " + beverage2.cost() + " ... " + beverage2.getDescription());
		
	}
	
}
