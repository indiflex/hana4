package trythis;

import java.util.Scanner;

// MyScan ms = new MyScan();
public class MyScan {
	// private String name;
	public static void main(String[] args) {
		// scanUserInfo();
		scanTemp();
	}

	private static void scanTemp() {
		final int currTemp = 20;
		Scanner scan = new Scanner(System.in);
		System.out.print("수심: ");
		int deep = scan.nextInt();
		double result = currTemp - Math.floor((double)deep / 10) * 0.7;
		System.out.println(result);
	}

	private static void scanUserInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Addr: ");
		String addr = scan.nextLine();
		System.out.print("Age: ");
		int age = scan.nextInt();
		System.out.print("Height: ");
		double height = scan.nextDouble();

		System.out.printf("name is %s, addr is %s, age is %d years old, height is %4.1f", name, addr, age, height);
	}

}
