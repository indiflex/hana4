package oop;

public interface Flyable {
	public static final String StaticFly = "StaticFly";

	public static void staticMethod() {
		System.out.println("StaticMethod-Fly");
	}

	public void fly();

	public default void landing() {
		System.out.println("Landing");
		run();
	}

	private void run() {
		System.out.println("Flyable - Run!!");
	}

	interface Clickable {
		public void onClick();
	}

}
