package bank;

public class FreeAccount extends Account implements Transferable, Withdrawable {
	public FreeAccount(String accountName, int accountId, String owner, int balance) {
		super(accountName, accountId, owner, balance);
	}

	public void transfer() {
		// try {
		// 	int accId = scanInt("어디로 보낼까요? %s".formatted(exceptMe()), 2);
		// 	accounts.stream()
		// 		.filter(a -> a.getAccountId() == accId)
		// 		.findFirst()
		// 		.ifPresent(super::setTransferTargetAccount);
		// } catch (Exception e) {
		// 	transfer();
		// }

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
}
