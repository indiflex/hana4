package oop;

import java.util.Objects;

public class SuperPerson {
	private final String name;
	protected int age;

	public SuperPerson(String name, int age) {
		System.out.println("Super2" + name + age);
		this.name = name;
		this.age = age;
	}

	public SuperPerson() {
		// this("", 0);
		this.name = "";
		this.age = 0;
		// System.out.println("Super1");
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		SuperPerson person = (SuperPerson)obj;
		System.out.println("person = " + person);
		return age == person.getAge() && Objects.equals(name, person.getName());
	}

	@Override
	public int hashCode() {
		System.out.println("age=" + age);
		try {
			Class<?> person = Class.forName("Person");
			System.out.println("person = " + person);
		} catch (ClassNotFoundException e) {
			// throw new RuntimeException(e);
		}
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return "SuperPerson{"
			+ "name='" + name + '\'' + ", age=" + age + '}';
	}

	public static void main(String[] args) {
		// Person hong = new Person("Hong", 33);
		// System.out.println("hong = " + hong);
		// SuperPerson kim = new Person("Kim", 30);
		// System.out.println("kim = " + kim);
		// System.out.println("age=" + kim.getAge());

		SuperPerson ps = Math.random() > 0.5 ? new Student() : new Person();

		if (ps instanceof Person) {
			System.out.println("ps = " + ps.getClass().getSimpleName());
			((Person)ps).walk();
		} else {
			System.out.println("ps = " + ps.getClass().getSimpleName());
		}

		if (ps instanceof Person psPerson) {
			psPerson.walk();
		}

	}
}
