package oop;

import java.util.Scanner;

public class Account {
	private final int accountNo;
	private final String name;
	private double balance;
	private Scanner scan;

	public Account(int accountNo, String name, double balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	private void deposit() {
		System.out.print("입금할 금액은? ");
		double amt = scan.nextDouble();
		this.balance += amt;
		System.out.printf("%.1f원이 입금되었습니다!\n", amt);
		this.checkBalance();
	}

	private void withdraw() {
		System.out.print("출금할 금액은? ");
		double amt = scan.nextDouble();
		if (this.balance < amt) {
			System.out.println("\n잔액이 부족합니다!!");
			return;
		}
		this.balance -= amt;
		System.out.printf("%.1f원이 출금되었습니다!\n", amt);
		this.checkBalance();
	}

	public void checkBalance() {
		System.out.printf("%s님의 잔액은 %.1f원 입니다.\n\n", this.name, this.balance);
	}

	private void display() {
		// String.format()
		String output = """
			------------------------------
			계좌번호: %d
			예금주: %s
			잔액: %.1f원
			------------------------------
			""".formatted(this.accountNo, this.name, this.balance);
		final int hyphenCnt = 15;
		System.out.println(output);
	}

	public void login() {
		if (this.scan == null) {
			this.scan = new Scanner(System.in);
		}

		// this.action();
		this.display();
	}

	public void action() {
		if (this.scan == null) {
			System.out.println("먼저 로그인하세요!");
			return;
		}

		while (true) {
			System.out.print("\nCommand(+:입금, -:출금, q:종료) : ");
			String cmd = scan.next();
			scan.skip(".*");

			switch (cmd) {
				case "+" -> this.deposit();
				case "-" -> this.withdraw();
				case "q" -> {
					return;
				}

				default -> System.out.println("잘 못된 명령입니다!");
			}
		}
	}

	public void logout() {
		if (this.scan != null) {
			this.scan.close();
		}
		this.display();
	}

}

class T {
	public static void main(String[] args) throws Exception {
		Account acc = new Account(1111, "Hong", 0);

		acc.login();
		acc.action();
		acc.logout();
	}
}
