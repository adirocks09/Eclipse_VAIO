package testThread;

public class Consumer implements Runnable {
	Q q2;

	Consumer(Q q2) {
		this.q2 = q2;
		new Thread(this, "Consumer").start();

	}

	// @Override
	// public void run() {
	// synchronized (q2) {
	// while (true) {
	// q2.get();
	// }
	// }
	// }

	@Override
	public void run() {
		while (true) {
			q2.get();
		}
	}

}
