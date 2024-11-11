package thread;

public class ThreadMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		// Thread.currentThread().setDaemon(true);

		MyThread myThread = new MyThread();
		MyThread myThread2 = new MyThread();
		Thread yourThread = new Thread(new YourThread());
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread3 started...");
			}
		});
		Thread thread4 = new Thread(() -> {
			System.out.println("Thread4 started...");
			for (int i = 1; i <= 7; i++) {
				try {
					Thread.sleep(500);
					if (i >= 2) {
						System.out.println("-- State=" + yourThread.getState());
						System.out.println("-- Your.interrupt = " + yourThread.isInterrupted());

						if (i == 2) {
							yourThread.interrupt();
						}
						// 	System.out.println(1 / 0);
					}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println("Thread4 = " + i);
			}
		});

		// myThread.setPriority(Thread.MIN_PRIORITY);
		// yourThread.setPriority(Thread.MAX_PRIORITY);

		myThread.setDaemon(true);
		// yourThread.setDaemon(true);

		// myThread.join(2000);
		myThread.start();

		System.exit(0);
		yourThread.start();
		myThread2.start();
		// myThread2.waiting();

		// thread3.start();
		thread4.start();
		System.out.println("Main end.");
	}
}
