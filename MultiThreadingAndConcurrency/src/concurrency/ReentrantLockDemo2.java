package concurrency;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThread1 extends Thread{
	static ReentrantLock l = new ReentrantLock();
	public MyThread1(String name) {
		super(name);
	}
	public void run(){
		do {
			try {
				if(l.tryLock(5000l,TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName()+" got lock");
					try {
						Thread.sleep(30000);
					}
					catch(Exception e) {}
					System.out.println(Thread.currentThread().getName()+" awaken");
					l.unlock();
					break;
				}
				else {
					System.out.println(Thread.currentThread().getName()+" perfomring alter operations");
				}
			}
			catch(Exception e) {}
		}while(true);
	}
}

public class ReentrantLockDemo2 {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("first thread");
		MyThread1 t2 = new MyThread1("second thread");
		t1.start();
		t2.start();
	}

}
