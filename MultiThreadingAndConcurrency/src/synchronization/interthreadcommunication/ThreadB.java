package synchronization.interthreadcommunication;

public class ThreadB extends Thread {
	int total = 0;
	@Override
	public void run() {
		synchronized (this) {	
			for(int i =0;i<=100;i++) {
				total+=i;
			}
			System.out.println("Child Thread Giving Notification to main thread");
			this.notify();
		}
	}
}
