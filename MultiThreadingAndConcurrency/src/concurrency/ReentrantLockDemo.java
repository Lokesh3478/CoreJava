package concurrency;

import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread{
	static ReentrantLock l = new ReentrantLock();
	MyThread(String name){
		super(name);
	}
	public void run(){
		if(l.tryLock()) {
			System.out.println(Thread.currentThread().getName()+" got lock");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			l.unlock();
		}
		else {
			System.out.println(Thread.currentThread().getName()+" performing alternative operations");
		}
	}
}
public class ReentrantLockDemo {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("FirstThread");
		MyThread t2 = new MyThread("SecondThread");
		t1.start();
		t2.start();
	}

}
