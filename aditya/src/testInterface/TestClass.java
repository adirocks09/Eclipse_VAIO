package testInterface;

public class TestClass implements InterfaceB{

	@Override
	public String name() {  
		return "Aditya";
	}

	@Override
	public int age() {  
		return 25;
	}
	
	public double salary(){   //class method
		return 10000;
	}
}
