package synchronization.deadlock;

public class Main {

	public static void main(String[] args) {
		resource1 r1 = new resource1();
		resource2 r2 = new resource2();
		Thread t1 = new Thread(
				    ()->{
				        r1.m2(r2);  	
				    }
				);
		//Deadlock situation
		//t1.start(); r1.m2(r2);
		//Deadlock prevention
		r2.m2(r1);
		Thread.currentThread().stop();
		r1.m2(r2);

	}

}
