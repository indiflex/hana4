package trythis.shape;

public class Figure<T> {
	T figure;

	public Figure(T figure) {
		this.figure = figure;
	}

	public void print() {
		System.out.printf("Perimeter=%.1f, Area=%.1f", 0.0, 0.0);
	}
}
