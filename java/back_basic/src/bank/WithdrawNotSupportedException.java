package bank;

public class WithdrawNotSupportedException extends AccountException {
	public WithdrawNotSupportedException() {
		super("출금할 수 없는 통장입니다!");
	}
}
