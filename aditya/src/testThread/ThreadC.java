package testThread;

public class ThreadC extends Thread{  
	Table t;  
	ThreadC(Table t){  
	this.t=t;  
	start();
	}  
	public void run(){ 
	
	t.printMsg("Anand"); // Thread C calls non synchronized method on Object t 
	                   //and thus it does not require lock on the object t to call this method
	
	synchronized(t){   // Thread C has to wait to get lock on the object t to execute the synchronized block statements
		System.out.println("Ravi");
	}
	}
}