package testThread;

public class TestApp {

	public static void main(String args[]) {

		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}
}
