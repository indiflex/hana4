package com.hana.greetings;

public class Hi {
	public static void main(String[] args) {
		System.out.println("Hi!~");
		playSwitch();
		// System.out.println(add(10, 10));
		long l1 = 10;
		long l2 = 20;
		int i1 = 10;

		long long1 = (long)Integer.MAX_VALUE + 1;

		System.out.println(add(i1, long1));

		int[] users = {1, 2, 3, 4, 5};
		for (int i = 0; i < users.length; i++) {
			System.out.println(i);
			System.out.println(users[i]);
		}
		// 새로운 코멘트!!

		for (var user : users) {
			System.out.println("user = " + user);
		}
	}

	private static int add(int a, int b) {
		System.out.println("Int");
		return a + b;
	}

	private static long add(long a, long b) {
		System.out.println("long");
		return a + b;
	}

	private static void playSwitch() {
		int score = System.currentTimeMillis() % 2 == 0 ? 81 : 70;
		final String grade = score > 80 ? "A" : "C";
		switch (grade) {
			case "A", "B" -> {
				System.out.println("12");
				System.out.println("123");
			}
			case "C" -> {
				System.out.println("3");
			}
			default -> System.out.println("default!");
		}
	}
}
