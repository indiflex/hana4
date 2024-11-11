package trythis;

import java.util.Random;

public class Vote extends Thread {
	private static final int LIMIT = 100;
	private final Random rand = new Random();

	private final String district;
	private int process;

	public Vote(String district) {
		this.district = district;
		this.process = 0;
	}

	@Override
	public void run() {
		int incRate = rand.nextInt(5) + 1;
		// while (this.process < LIMIT) {
		for (int i = 0; i < LIMIT; i++) {
			this.process += incRate;
			if (this.process >= LIMIT) {
				this.process = LIMIT;
				this.printProcess(incRate);
				break;
			}

			try {
				this.printProcess(incRate);
				Thread.sleep(rand.nextInt(1000));
			} catch (InterruptedException e) {
				// throw new RuntimeException(e);
				Thread.currentThread().interrupt();
			}
		}
	}

	private void printProcess(int incRate) {
		System.out.printf("%s 개표율: %d%% (개표증가율: %d) %s%n", district, process, incRate, "*".repeat(process));
	}

	public static void main(String[] args) {
		Vote v1 = new Vote("제1지역구");
		Vote v2 = new Vote("제2지역구");
		Vote v3 = new Vote("제3지역구");
		v1.start();
		v2.start();
		v3.start();
	}
}
