package testThread;

public class ThreadApp {

	public static void main(String[] args) {

		/*
		Person p = new Person(10,"Ram");   // Threads calling same object
		Thread1 ob1=new Thread1(p,"one.one");
		Thread2 ob2=new Thread2(p,"one.two");
		*/
		
		/*
		Person p1 = new Person(10,"Ram");    // Threads calling different objects
		Person p2 = new Person(20,"Shyam");
		Thread1 ob3=new Thread1(p1,"two.one");
		Thread2 ob4=new Thread2(p2,"two.two");
		*/
		
		//synchronised(this) v/s synchronized(MyClass.class)
		//MyClass.class and this are different things, are different references to different objects.
		//this - is the reference to particular this instance of class, and
		//MyClass.class - is the reference to MyClass description object.
		//This synchronization blocks differs in that the first will synchronize all threads that deal concretely with this instance of MyClass,
		//and the second one will synchronize all threads independently of which object on which this method was called.
		
		/*
		Thread3 ob31=new Thread3("three.one");
		Thread3 ob32=new Thread3("three.two");   
		*/
		
		
		Person p4 = new Person(30,"GhanShyam");   // Threads calling same object
		Thread4 ob5=new Thread4(p4,"four.one");
		Thread4 ob6=new Thread4(p4,"four.two");
		
		
		/*
		Person p5 = new Person(15,"Sonu");   // Threads calling different references for the same object, result is same as above
		Person p6 = p5;
		Thread4 ob7=new Thread4(p5,"four.three");
		Thread4 ob8=new Thread4(p6,"four.four");
		*/
		
		/*
		Person p5 = new Person(15,"Sonu");   // Threads calling different objects
		Person p6 = new Person(25,"Monu");
		Thread4 ob7=new Thread4(p5,"four.three");
		Thread4 ob8=new Thread4(p6,"four.four");
		*/
		
		
	}
}
