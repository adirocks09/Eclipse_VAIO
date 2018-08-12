package testThread;

public class Table {
	synchronized void syncPrintTable(int n) {// synchronized method
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	synchronized void syncPrintMsg(String message){ // synchronized method
		for (int i =1;i<=5;i++){
			System.out.println(message);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	void printMsg(String message){  // non synchronized method
		for (int i =1;i<=5;i++){
			System.out.println(message);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	}
}
