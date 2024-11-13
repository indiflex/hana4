package bank;

public class TransferNotSupportedException extends AccountException {
	public TransferNotSupportedException() {
		super("이체할 수 없는 통장입니다!");
	}
}
