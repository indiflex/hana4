package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Account {
	public static final List<Account> accounts = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

	protected final String accountName;

	protected final int accountId;
	protected final String owner;
	protected int balance;

	public int getAccountId() {
		return accountId;
	}

	public Account(String accountName, int accountId, String owner, int balance) {
		this.accountName = accountName;
		this.accountId = accountId;
		this.owner = owner;
		this.balance = balance;
		accounts.add(this);
	}

	private void setTransferTargetAccount(Account account) {
		try {
			int amount = scanInt("%s에 보낼 금액은?", 2);
			account.withdraw(amount);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void transfer() throws TransferNotSupportedException {
		try {
			((Transferable)this).transfer();
		} catch (ClassCastException e) {
			throw new TransferNotSupportedException();
		}
	}

	public void withdraw() {
		this.withdraw(-1);
	}

	public void withdraw(int amount) {
		try {
			if (amount == -1) {
				amount = scanInt("출금하실 금액은?", 2);
				if (amount > balance) {
					throw new InsufficentException();
				}
			}

			balance -= amount;
			System.out.printf("%s 통장에서 %,d원이 출금되었습니다.", accountName, amount);
			System.out.printf("%s 통장의 잔액은 %,d원입니다.", accountName, balance);

		} catch (InterruptedException e) {
			System.out.printf("잔액이 부족합니다!(잔액: %,d)%n", balance);
			withdraw();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			withdraw();
		}
	}

	public void deposit() {
		try {
			int amount = scanInt("입금하실 금액은?", 2);
			balance += amount;
			System.out.printf("%s 통장에서 %,d원이 입금되었습니다.", accountName, amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			deposit();
		}
	}

	private void setCurrentAccount(Account account) {
		account.printInfo();
	}

	protected void printInfo() {
		printInfo("잔액");
	}

	protected void printInfo(String balanceMsg) {
		System.out.printf("%s (계좌번호: %d, %s: %d, 예금주: %s)%n", accountName, accountId, balanceMsg, balance, owner);
	}

	public void startMenu() throws Exception {
		String msg = "통장을 선택하세요 %s ".formatted(accounts);
		int accId = scanInt(msg, 0);
		accounts.stream().filter(a -> a.getAccountId() == accId).findFirst().ifPresent(this::setCurrentAccount);
	}

	public void choiceMenu() {
		this.choiceMenu("원하시는 업무는?", "입금");
	}

	public void choiceMenu(String preMsg, String plusMsg) {
		try {
			String job = scan("%s (+: %s, -: 출금, T: 이체, I: 정보) ".formatted(preMsg, plusMsg), 1);

			switch (job) {
				case "+" -> deposit();
				case "-" -> withdraw();
				case "T", "t" -> transfer();
				case "I", "i" -> printInfo();
				default -> {
					throw new Exception("다시 선택해 주세요!");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			choiceMenu(preMsg, plusMsg);
		}
	}

	public int scanInt(String msg, int depth) throws Exception {
		return Integer.parseInt(this.scan(msg, depth));
	}

	public String scan(String msg, int depth) throws Exception {
		System.out.print(msg);
		String ret = scanner.nextLine();
		if (ret.equals("0") || ret.isEmpty()) {
			if (depth == 0) {
				System.exit(0);
			} else if (depth == 1) {
				startMenu();
			} else if (depth == 2) {
				choiceMenu();
			} else {
				throw new Exception();
			}
		}

		return ret;
	}

	public List<Account> exceptMe() {
		// return accounts.stream().filter(a -> a.getAccountId() != this.getAccountId()).toList();
		return accounts.stream().filter(a -> !a.equals(this)).toList();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account)o;
		return accountId == account.getAccountId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(accountId);
	}

	@Override
	public String toString() {
		return "%d: %s".formatted(accountId, accountName);
	}
}
