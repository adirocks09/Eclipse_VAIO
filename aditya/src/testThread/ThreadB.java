package testThread;

public class ThreadB extends Thread{  
	Table t;  
	ThreadB(Table t){  
	this.t=t;  
	start();
	}  
	public void run(){  
	t.syncPrintMsg("Aditya"); // ThreadB calls synchronized method on object t and hence it has to wait for another thread to release lock on object, 
	                          //so that it can gain lock on Object t and call the synchronized method
	}
}