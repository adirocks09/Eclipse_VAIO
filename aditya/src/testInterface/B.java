package testInterface;

public class B extends A {

	public B(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public void chk1(){
		System.out.println("Anand");
		staticMethod();
	}
	
	public static void chk2(){
		System.out.println("Anand");
		staticMethod();
	}
	
	void chk2(String s){
		System.out.println("Anand");
		staticMethod();
	}
	
	 public static void staticMethod(){
			System.out.println("Anand");
	 }
	 
	 public void main(String args[]){
		 
	 }
	
}
