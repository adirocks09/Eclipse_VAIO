package testThread;

public class Deadlock implements Runnable {
	A a = new A();
	B b = new B();

	//source : https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
	//When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object 
	//and releases it when the method returns. The lock release occurs even if the return was caused by an uncaught exception.
	//You might wonder what happens when a static synchronized method is invoked, since a static method is associated with a class, not an object. In this case, the thread acquires the intrinsic lock for the Class object associated with the class. 
	//Thus access to class's static fields is controlled by a lock that's distinct from the lock for any instance of the class.
	
	public Deadlock() {
		Thread.currentThread().setName("main Thread");
		Thread t = new Thread(this, "racing thread");
		t.start();
		a.foo(b); // Main thread locks a : Main Thread invokes synchronised method 'foo' on the object 'a' and thus gets lock on 'a'
		System.out.println("back in main thread");
	}

	@Override
	public void run() {
		b.bar(a);  // Racing Thread locks b : Racing Thread invokes synchronised method 'bar' on the object 'b' and thus gets lock on 'b'
		System.out.println("back in other thread");

	}

	public static void main(String args[]) {
		new Deadlock();
	}
}
