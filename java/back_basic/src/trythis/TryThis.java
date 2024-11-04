package trythis;

import trythis.comp.Employee;
import trythis.comp.InvoiceItem;
import trythis.shape.Circle;
import trythis.shape.Rectangle;

public class TryThis {
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(2);

		System.out.println("circle1 = " + circle1);
		System.out.println("circle2 = " + circle2);

		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle(3, 4);
		System.out.println("rect1 = " + rect1);
		System.out.println("rect2 = " + rect2);

		Employee emp1 = new Employee(1, "코난", 25000000);
		System.out.println("emp1 = " + emp1);
		Employee emp2 = new Employee(1, "코난", 25000000);
		Employee emp3 = new Employee(1, "코난", 25000000);

		InvoiceItem it1 = new InvoiceItem("item1", "PongPong", 5, 3000);
		System.out.println("it1 = " + it1);
	}
}
