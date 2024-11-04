package trythis;

import trythis.shape.Circle;

public class TryThis {
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(2);

		System.out.println("circle1 = " + circle1);
		System.out.println("circle2 = " + circle2);
	}
}
