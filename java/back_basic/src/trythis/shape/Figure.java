package trythis.shape;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;

public class Figure<T extends Shape & Resizable> {
	T figure;
	static int sid;
	// static T id;

	public Figure(T figure) {
		this.figure = figure;
		// T[] figures = new T[10];
		// String str = "ABC"; // auto-boxing
		// Integer intgr = 123;
		// int inum = intgr; // unboxing
		// System.out.println("inum = " + inum);
	}

	public void print() {
		// Object[] stars = new String[10];
		// List<Object> list = new ArrayList<String>();

		// ArrayList<Integer>[] list = new ArrayList[10];
		// list[0] = new ArrayList<Integer>();
		// list[0] = new ArrayList<>();
		// list[0].add(0);
		// List<Integer> list = new ArrayList<Integer>();
		double perimeter = 0;
		if (this.figure instanceof Circle circle) {
			perimeter = circle.getPerimeter();
		} else if (this.figure instanceof Rectangle rect) {
			perimeter = rect.getPerimeter();
		}
		System.out.printf("Perimeter=%.1f, Area=%.1f%n", perimeter, this.figure.calArea());
	}

	public static void main(String[] args) {
		ColorCircle circle = new ColorCircle(1, "green");
		Rectangle rectangle = new Rectangle(1, 2);

		Figure<ColorCircle> figure1 = new Figure<>(circle);
		figure1.print();
		Figure<Rectangle> figure2 = new Figure<>(rectangle);
		figure2.print();

		StringBuilder sb = new StringBuilder("ABC");
		sb.append("sadfadfadsfafasfdsfafaddfa");
		System.out.println(sb.capacity() + ":" + sb.toString().length());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		Calendar calendar = Calendar.getInstance();
		System.out.println(sdf.format(calendar.getTime()));

		String query = "name=conan&addr=ran's&age=10";
		StringTokenizer tokenizer = new StringTokenizer(query, "&=");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}

		String dadakie = "홍길동/장화/홍련/콩쥐/팥쥐";
		StringTokenizer tokenizer1 = new StringTokenizer(dadakie, "/");
		try {
			String tmp;
			while ((tmp = tokenizer1.nextToken()) != null) {
				System.out.println("tmp = " + tmp);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		Random rand1 = new Random(3333L);
		for (int i = 0; i < 10; i++) {
			if (i < 7) {
				rand1.setSeed(3333L);
			}
			System.out.println(rand1.nextInt(5) + 1);
		}

		System.out.println("----------------------");
		Date now = new Date();
		System.out.println("now.getTime() = " + now.getTime());
		String strNow1 = now.toString();
		System.out.println(strNow1);

		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 - w - W");
		String strNow2 = fmt.format(now);
		System.out.println(strNow2);
		System.out.println("----------------------");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);

		System.out.printf("%d-%02d-%02d%n", year, month + 1, date);
		System.out.println(fmt.format(cal.getTime()));
		cal.add(Calendar.DATE, -5);
		System.out.println(fmt.format(cal.getTime()));
	}

}
