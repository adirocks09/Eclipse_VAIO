package testThread;

public class B {

	synchronized void bar(A a){
		String name=Thread.currentThread().getName();
		System.out.println(name + "entered B.bar");
		
		try{
			//Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		System.out.println(name + "trying to call A.last");
		a.last();

	}
	
	synchronized void last(){
		System.out.println("inside B. last");
	}
}
