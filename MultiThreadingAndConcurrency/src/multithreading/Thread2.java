package multithreading;

public class Thread2 implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Thread 2 Priority "+Thread.currentThread().getPriority());
//		synchronized (this) {
//			for(int i =0;i<5;i++) {
//				System.out.println("From sync block Thread2 "+i);
//			}
//		}
		for(int i =0;i<5;i++) {
			System.out.println(i+" "+Thread.currentThread()+" Thread2");
		}

	}

}
