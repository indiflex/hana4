package trythis.shape;

public class Circle implements GeomericObject {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle() {
		this(1.0);
	}

	public double getRadius() {
		return radius;
	}

	protected void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	public double getPerimeter() {
		return Math.PI * this.radius * 2;
	}

	@Override
	public String toString() {
		return "Circle[radius=%s]의 둘레는 %.2f의 면적은 %.2f".formatted(getRadius(), this.getPerimeter(),
			this.getArea());
	}
}
