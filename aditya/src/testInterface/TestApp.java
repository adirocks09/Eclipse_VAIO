package testInterface;

public class TestApp {

	public static void main(String[] args) {

		InterfaceB obj= new TestClass();
		System.out.println(obj.name());
		System.out.println(obj.age());
		
		InterfaceA obj2= new TestClass();
		System.out.println(obj2.name());
		//System.out.println(obj2.age());   //gets Error
		
		System.out.println(C.a.getId());

	}

}
