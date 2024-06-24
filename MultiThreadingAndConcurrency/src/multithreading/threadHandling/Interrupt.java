package multithreading.threadHandling;

public class Interrupt {
     public static void main(String[] args) {
		Thread t1 = new Thread(
				   ()->{
					   for(int i=0;i<=10;i++) {
						   if(i>=4) {
							   try {
								   System.out.println("My time has come");
								   Thread.sleep(500);
							   }
							   catch(Exception e) {}
						   }
						   else {
						   System.out.println("I am invetiable");
						   }
					   }
				   }
				);
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t1.interrupt();//WILL INTERRUPT THE THREAD AND RAISE A EXCEPTION 
		for(int i=0;i<10;i++) {
			System.out.println("But I am Ironman");
		}
	}
}
