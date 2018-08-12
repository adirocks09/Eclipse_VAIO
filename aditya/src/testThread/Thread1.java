package testThread;

public class Thread1 implements Runnable {

	Thread th1;
	Person p1;
	String name;

	Thread1(Person p1, String name) {
		this.p1 = p1;
		this.name=name;
		th1 = new Thread(this, name);
		System.out.println("Started : "+name);
		th1.start();
	}

	
	@Override
	public void run() {
		int i = 1;
		synchronized (p1) {
			// Thread1 maintains lock on the Person Object until synchronised block is completed
			while (i < 10) {
				System.out.println(p1.getName());
				try {
					th1.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			
			for(int j=3 ; j>=1; j--){
				System.out.println(j);
			}
			
			System.out.println("Thread 1 :releasing lock on Person Object");
			System.out.println("Thread 1 : Synchronised Block  completed");
		}
		
		System.out.println("Thread 1 : Run Method for completed");

	}

	
}
