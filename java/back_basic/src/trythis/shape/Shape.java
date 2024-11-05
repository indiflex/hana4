package trythis.shape;

import java.math.BigDecimal;

abstract class Shape {
	abstract double calArea();

	public static void main(String[] args) {
		Shape[] shapes = {new Circle(5), new Rectangle(3, 4), new ColorCircle(1, "black")};

		BigDecimal totArea = BigDecimal.valueOf(0);
		for (Shape shape : shapes) {
			System.out.println("shape = " + shape.calArea());
			// totArea += shape.calArea();
			totArea = totArea.add(BigDecimal.valueOf(shape.calArea()));
		}
		System.out.printf("면적의 합: %.2f\n", totArea);

		System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));
		BigDecimal bd = BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2));
		System.out.print(bd);
	}
}
