package oop;

public class Person extends SuperPerson {
	public Person() {
		// this("엄마의 아이", 1);
		System.out.println("Person1");
	}

	public Person(String name, int age) {
		super(name, age);
		// super();
		System.out.println("Person2");
	}
}
