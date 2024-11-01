package trythis;

import java.util.Arrays;
import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		System.out.println("args=" + Arrays.toString(args));
		if (args.length == 0) {
			System.out.println("No arguments provided");
			return;
		}

		int[] scores = new int[args.length];

		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			scores[i] = Integer.parseInt(args[i]);
			sum += scores[i];
		}
		System.out.println("숫자들의 합은 " + sum);
		System.out.println("숫자들의 평균은 " + sum / args.length);

		// scanStrNum();
		// int[] nums = {1, 2, 3};
		// callByRef(nums);
		// scanGrade();
		// System.out.println("nums = " + Arrays.toString(nums));
	}

	private static void scanStrNum() {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열: ");
		String str = scan.nextLine();
		System.out.print("출력횟수: ");
		int cnt = scan.nextInt();

		System.out.println(str.repeat(cnt));

	}

	private static void callByRef(int[] scores) {
		scores[1] = 100;
		System.out.println("scores = " + Arrays.toString(scores));
	}

	private static void scanGrade() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생수: ");
		int studentCnt = scan.nextInt();
		int[] grades = new int[studentCnt];
		for (int i = 0; i < studentCnt; i++) {
			System.out.printf("%d번째 학생의 점수는?", i + 1);
			grades[i] = scan.nextInt();
		}

		System.out.printf("%d명의 학생 점수는 다음과 같습니다\n%s", studentCnt, Arrays.toString(grades) + "\n");

		for (int i = 0; i < studentCnt; i++) {
			System.out.printf("%d번 째 학생의 등급은 %s 입니다.\n", i + 1, getGrade(grades[i]));
		}
	}

	private static char getGrade(int score) {
		char grade = 'F';
		switch (score / 10) {
			case 10, 9 -> grade = 'A';
			case 8 -> grade = 'B';
			case 7 -> grade = 'C';
			case 6 -> grade = 'D';
		}

		return grade;
	}
}
