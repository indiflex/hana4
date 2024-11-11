package thread;

public class YourThread implements Runnable {
	@Override
	public void run() {
		System.out.println("YourThread Started...");
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
				// if (i > 2) {
				// 	System.out.println(1 / 0);
				// }
			} catch (InterruptedException e) {
				System.out.println("YourERR>>" + e);
				// throw new RuntimeException(e);
			}
			System.out.println("YourThread = " + i);
		}
		System.out.println("YourThread end.");
	}

}
