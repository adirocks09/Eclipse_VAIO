package testThread;

public class TestApp2 {

	public static void main(String[] args) {

		Table t =new Table();
		ThreadA a =new ThreadA(t);
		ThreadB b =new ThreadB(t);
		ThreadC c=new ThreadC(t);

	}
	
	// ThreadA calls synchronized method on object t and hence it acquires lock on object t
    // When a thread acquires lock on an object only that thread can call synchronised method on that object
	
	// Since ThreadB also calls synchronized method on object t, it doesnot start immediately and  has to wait for thread A to complete and release lock on object.
	//Thread B cannot call a synchronised method of an object until it gains lock on that object
	//Once it gains the loack after Thread A is finished it starts executing
	
	// Thread C calls non synchronized method on Object t and thus doesnt need lock on object t and thus it starts immediately
	//but it has to wait for Thread A and Thread B to finish to gain lock on object t in order to execute the synchronized block
    

// output
//	5
//	Anand
//	10
//	Anand
//	15
//	Anand
//	20
//	Anand
//	25
//	Anand
//	Aditya
//	Aditya
//	Aditya
//	Aditya
//	Aditya
//  Ravi	
	
	
}
