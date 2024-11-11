package thread;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("MyThread Started...");
		System.out.println(Thread.currentThread().getName());

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("My.interrupt = " + isInterrupted());
				// if (i > 1) {
				// 	System.out.println(1 / 0);
				// }
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("MyThread - " + i);
		}
		// System.out.println("MyThread end.");
	}

	public synchronized void waiting() throws InterruptedException {
		// 	Thread.currentThread().wait();
		wait();
	}
}
