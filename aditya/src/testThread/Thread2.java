package testThread;

public class Thread2 implements Runnable {

	Thread th2;
	Person p2;
    String name;

	Thread2(Person p2, String name) {
		this.p2 = p2;
		this.name=name;
		th2 = new Thread(this, name);
		System.out.println("Started : "+name);
		th2.start();
	}

	@Override
	public void run() {
		int i = 1;
		
		synchronized (p2) {
			while (i < 10) {
				System.out.println(p2.getAge());
				try {
					th2.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			
			for(int j=3 ; j>=1; j--){
				System.out.println(j);
			}
			
			System.out.println("Thread 2 :releasing lock on Person Object");
			System.out.println("Thread 2 : Synchronised Block  completed");
		}

		
		System.out.println("Thread 2 : Run Method for completed");

	}

}
