package oop;

public class Dog extends Animal implements Flyable, Swimmable {
	@Override
	void walk() {
		System.out.println("Dog Walk!!");
	}

	@Override
	public void fly() {
		System.out.println("fly by ears!!");
	}

	// @Override
	// public void landing() {
	// 	Flyable.super.landing();
	// }

	public static void main(String[] args) {
		Dog maxx = new Dog();
		maxx.fly();
		maxx.landing();
		maxx.bark();

		System.out.println("Animal.StaticName = " + Animal.StaticName);
		System.out.println("Flyable.StaticFly = " + Flyable.StaticFly);

		Swimmable swimBoy = Math.random() > 0.5 ? new Dog() : new Cat();
		swimBoy.swim();
		Swimmable.staticMethod();

		Flyable flyer = new Flyable() {
			@Override
			public void fly() {
				System.out.println("Anonymous Implements Object!!");
			}
		};
		flyer.fly();
	}

	@Override
	public void swim() {
		System.out.println("Swim Dog!!");
	}
}
