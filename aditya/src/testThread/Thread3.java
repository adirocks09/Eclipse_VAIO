package testThread;

public class Thread3 implements Runnable {

	Thread th3;
	String name;

	Thread3(String name) {
		th3 = new Thread(this, name);
		this.name=name;
		System.out.println("Started : "+name);
		th3.start();
	}

	//synchronised(this) v/s synchronized(MyClass.class)
	//MyClass.class and this are different things, are different references to different objects.
	//this - is the reference to particular this instance of class, and
	//MyClass.class - is the reference to MyClass description object.
	//This synchronization blocks differs in that the first will synchronize all threads that deal concretely with this instance of MyClass,
	//and the second one will synchronize all threads independently of which object on which this method was called.
	
	@Override
	public void run() {
		int i = 1;
		synchronized (Thread3.class) {
			while (i < 10) {
				System.out.println(this.name);
				try {
					th3.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			System.out.println("Thread 3 : Synchronised Block  completed");
			System.out.println("Thread 3 : Releasing Lock");
		}
	}
}
