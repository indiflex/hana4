package bank;

public class SavingAccount extends Account {
	private static final int[] MONS = {1, 3, 6, 9, 12, 24, 36, 48};
	private static final String[] RATES = {"3.0", "3.35", "3.4", "3.35", "3.35", "2.9", "2.9", "2.9"};

	public SavingAccount(String accountName, int accountId, String owner, int balance) {
		super(accountName, accountId, owner, balance);
	}

	@Override
	public void choiceMenu() {
		super.choiceMenu("계좌가 만기되었습니다.", "만기처리");
	}

	@Override
	protected void printInfo() {
		super.printInfo("예치금");
		for (int i = 0; i < RATES.length; i++) {
			System.out.printf("\t%d개월 이상: %s%%\n", MONS[i], RATES[i]);
		}
	}
}
