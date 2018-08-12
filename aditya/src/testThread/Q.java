package testThread;

public class Q {
	int n;
	volatile boolean valueSet = false;


	synchronized int get() {
		System.out.println("--------------------------------");
		System.out.println("Consumer gained lock on Q");
		System.out.println("Got :  " + n);
		System.out.println("Consumer left lock on Q");
		System.out.println("--------------------------------");
		return n;
	}



	synchronized void put(int n) {
		System.out.println("--------------------------------");
		System.out.println("Producer gained lock on Q");
		this.n = n;
		System.out.println("Put :  " + n);	
		System.out.println("Producer left lock on Q");
		System.out.println("--------------------------------");
	}

}
