package trythis.shape;

public class Rectangle extends Shape implements Resizable {
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public Rectangle() {
		this(1, 1);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getArea() {
		return this.length * this.width;
	}

	public double getPerimeter() {
		return this.length * 2 + this.width * 2;
	}

	@Override
	public void resize(int percent) {
		setLength(this.length * (1.0 + (double)percent / 100));
	}

	@Override
	double calArea() {
		return getArea();
	}

	@Override
	public String toString() {
		return "Rectangle[length=%.1f, width=%.1f]의 둘레는 %.1f의 면적은 %.1f'".formatted(length, width, this.getPerimeter(),
			this.getArea());
	}
}
