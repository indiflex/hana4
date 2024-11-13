package bank;

public interface Transferable {
	public void transfer(Account account) throws TransferNotSupportedException;
}
