package concurrency;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class Main {

	public static void main(String[] args) {
		ReentrantLock l = new ReentrantLock();
		l.lock();
		System.out.println(l.isLocked());
		System.out.println(l.isHeldByCurrentThread());
		l.lock();
		System.out.println(l.getHoldCount());
		l.unlock();
		Thread t1 = new Thread(
				    ()->{
				    	try {
							if(l.tryLock(10,TimeUnit.SECONDS)) {
								System.out.println(l.isHeldByCurrentThread());
								System.out.print("GOT LOCK");
							}
							else {
								System.out.println("No use");
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
				);
		t1.start();
		System.out.println(l.getQueueLength());
		l.unlock();
		System.out.println(l.isLocked());
	}

}
