package oop;

import java.util.Objects;

public class SuperPerson {
	private final String name;
	private final int age;

	public SuperPerson(String name, int age) {
		System.out.println("Super2");
		this.name = name;
		this.age = age;
	}

	public SuperPerson() {
		// this("", 0);
		this.name = "";
		this.age = 0;
		System.out.println("Super1");
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
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
		return age == person.getAge() && Objects.equals(name, person.getName());
	}

	@Override
	public int hashCode() {
		System.out.println("age=" + age);
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return "SuperPerson{"
			+ "name='" + name + '\'' + ", age=" + age + '}';
	}

	public static void main(String[] args) {
		Person hong = new Person("Hong", 33);
		System.out.println("hong = " + hong);
		// Person kim = new Person("Kim", 30);
		// System.out.println("kim = " + kim);
		// System.out.println("age=" + kim.getAge());
	}
}
