package bank;

public class OneHanaBank {
	public static void main(String[] args) {
		Account free = new FreeAccount("자유입출금", 1, "홍길동", 0);
		Account saving = new SavingAccount("정기예금", 2, "홍길동", 50000000);
		Account minus = new MinusAccount("마이너스", 3, "홍길동", 0);

		try {
			free.startMenu();
			// free.withdraw();
			// saving.printInfo();
			// System.out.println(SavingAccount.findRate(15));
			// System.out.println(SavingAccount.findRate(36));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// saving.transfer();
		// saving.printInfo();
	}
}
