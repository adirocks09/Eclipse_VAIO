package testInterface;

public class A {
	
private int id;
 
 public A(int id) {
	super();
	this.id = id;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

protected void chk1(){
	 System.out.println("Aditya");
 }
 
// public void chk2(){
//	 System.out.println("Aditya");
// }
 
 public static void staticMethod(){
	 System.out.println("Aditya");
 }
}
