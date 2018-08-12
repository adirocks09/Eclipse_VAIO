package testThread;

public class ThreadA extends Thread{  
	Table t;  
	ThreadA(Table t){  
	this.t=t;  
	start();
	}  
	public void run(){  
	t.syncPrintTable(5);  // ThreadA calls synchronized method on object t and hence it acquires lock on object t
	                     // When a thread acquires lock on an object only that thread can call synchronised method on that object
	} 
}
