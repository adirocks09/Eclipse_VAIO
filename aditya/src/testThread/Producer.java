package testThread;

public class Producer implements Runnable {
	Q q1;

	Producer(Q q1) {
		this.q1 = q1;
		new Thread(this, "Producer").start();

	}

	// @Override
	// public void run() {
	// synchronized(q1){
	// int i=0;
	// while(true){
	// q1.put(i++);
	// }
	// }
	// }

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q1.put(i++);
		}
	}

}
