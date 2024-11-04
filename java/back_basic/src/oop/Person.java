package oop;

import java.util.Objects;

public class Person extends SuperPerson {
	private String addr;

	public Person() {
		this("엄마의 아이", 1);
		System.out.println("Person1");
	}

	public Person(String name, int age) {
		super(name, age);
		// super();
		System.out.println("Person2");
	}

	public Person(String name, int age, String addr) {
		super(name, age);
		this.addr = addr;
	}

	public String getAddr() {
		return this.addr;
	}

	@Override
	public boolean equals(Object person) {
		return super.equals(person) && ((Person)person).getAddr().equals(this.getAddr());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), addr);
	}

	@Override
	public String toString() {
		return "SuperPerson{ name='%s', age=%d, addr='%s'}".formatted(getName(), getAge(), getAddr());
	}
}
