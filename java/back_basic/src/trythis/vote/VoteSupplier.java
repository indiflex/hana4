package trythis.vote;

public class VoteSupplier extends Thread {
	private final VoteManager vm;

	public VoteSupplier(VoteManager vm) {
		this.vm = vm;
	}

	@Override
	public void run() {
		for (int i = 0; i < VoteManager.TOTAL_VOTERS / 2; i++) {
			try {
				Thread.sleep(200);
				vm.supply();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
