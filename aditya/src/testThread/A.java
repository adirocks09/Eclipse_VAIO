package testThread;

public class A {

	synchronized void foo(B b){
		String name=Thread.currentThread().getName();
		System.out.println(name + "entered A.foo");
		
		try{
			//Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		System.out.println(name + "trying to call B.last");
		b.last();

	}
	
	synchronized void last(){
		System.out.println("inside A. last");
	}
}
