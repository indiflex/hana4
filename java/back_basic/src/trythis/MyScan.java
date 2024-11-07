package trythis;

import java.io.InputStream;
import java.util.Scanner;

// MyScan ms = new MyScan();
public class MyScan {
	private final Scanner scan;

	public MyScan() {
		this(System.in);
	}

	public MyScan(InputStream is) {
		this.scan = new Scanner(is);
	}

	// private String name;
	public static void main(String[] args) {
		MyScan ms = new MyScan();
		// ms.scanUserInfo();
		ms.scanTemp();
	}

	private int scanning(String inputMessage) {
		System.out.print(inputMessage);
		return scan.nextInt();
	}

	private void scanTemp() {
		final int currTemp = 20;
		// System.out.print("수심: ");
		// int deep = scan.nextInt();
		int deep = scanning("수심은? ");
		double result = currTemp - Math.floor((double)deep / 10) * 0.7;
		System.out.println(result);
	}

	private void scanUserInfo() {
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Addr: ");
		String addr = scan.nextLine();
		int age = scanning("Age: ");
		System.out.print("Height: ");
		double height = scan.nextDouble();

		System.out.printf("name is %s, addr is %s, age is %d years old, height is %4.1f", name, addr, age, height);
	}

}
