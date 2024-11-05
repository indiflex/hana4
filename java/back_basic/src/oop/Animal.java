package oop;

abstract class Animal {
	public static String StaticName = "StaticAnimal";

	public static void staticMethod() {
		System.out.println("StaticMethod11");
	}

	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void bark() {
		System.out.println("BARK!!");
	}

	abstract void walk();
}
