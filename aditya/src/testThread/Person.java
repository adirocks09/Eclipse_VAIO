package testThread;

public class Person {
	private int age;
	private String name;

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printInfo(String threadName) {
		
		synchronized (this) {
            System.out.println("-------------------"+threadName+"  STARTS------------------------\n");
			System.out.println("Thread " + threadName + " acquired lock");
			System.out.println(threadName);
			System.out.println("Person [age=" + age + ", name=" + name + "]");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(threadName + " : Synchronised Block  completed");
			System.out.println("Thread " + threadName + " releasing lock\n");
            System.out.println("-------------------"+threadName+"  ENDS--------------------------\n");

		}
	}
}
