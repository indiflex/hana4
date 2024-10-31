package trythis;

import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Score: ");
		int score = scan.nextInt();

		switch (score / 10) {
			case 10, 9 -> System.out.println('A');
			case 8 -> System.out.println('B');
			case 7 -> System.out.println('C');
			case 6 -> System.out.println('D');
			default -> System.out.println('F');
		}
	}
}
