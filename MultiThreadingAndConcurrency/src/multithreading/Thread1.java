package multithreading;

public class Thread1 extends Thread {
	//Overriding start method is not advisable ,
	//but calling thread.start() will create the user 
	//thread
	public static Thread mainThread;
	public void start() {
		super.start();
		System.out.println("overriden start method");
	}
	@Override
	public void run() {
		/*To check priority of child threads
		 * created in another child Thread
		 * */
//		Thread t2 = new Thread(new Thread2());
//		t2.start();
//		synchronized (this) {
//			for(int i =0;i<5;i++) {
//				System.out.println("From sync block Thread1 "+i);
//			}
//		}
		for(int i =0;i<5;i++) {
			try {
				mainThread.join();
			}
			catch(InterruptedException e) {}
			System.out.println(i+" "+Thread.currentThread()+" Thread1");
		}
	}
}
