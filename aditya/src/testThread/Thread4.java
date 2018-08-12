package testThread;

public class Thread4 implements Runnable {

	Thread th4;
	Person p4;
	String name;

	Thread4(Person p4, String name) {
		this.p4 = p4;
		this.name = name;
		th4 = new Thread(this, name);
		System.out.println("Started : " + name);
		th4.start();
	}

	// synchronized block not used
	@Override
	public void run() {
		int i = 1;
			while (i < 5) {
				p4.printInfo(name);
				try {
					th4.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
	}

}
