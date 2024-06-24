package multithreading;

public class ThreadPriority {
	//Maximum Priority = 10
	//Minimum Priority = 1
	//Normal Priority = 5
	public static void main(String[] args) {
		System.out.println("Thread main Priority "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(7);
		Thread1 t1 = new Thread1();
		t1.start();
		System.out.println("Thread 1 Priority "+Thread.currentThread().getPriority());
	}
}
