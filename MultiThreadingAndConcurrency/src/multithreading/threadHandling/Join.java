package multithreading.threadHandling;
import multithreading.*;
public class Join {
		public static void main(String[] args)throws Exception {
//			Thread t2 = new Thread(
//					   ()->{
//						  for(int i=0;i<10;i++) {
//							  System.out.println("joined to waiting stage - child thread");
//							  try {
//								  Thread.sleep(2000);
//							  }catch(Exception e) {}
//						  }
//					  }
//					);
//			t2.setPriority(10);
//			t2.start();
//			t2.join(10000l);
//			
//			Thread1.mainThread = Thread.currentThread();
//			Thread t1 = new Thread1();
//			t1.start();
//			Thread.currentThread().join();
//			//t1.join();Deadlock Situation if both thread join each other to waiting state
//			for (int i = 0; i < 5; i++) {
//				Thread.currentThread().setPriority(1);
//				System.out.println("main thread");
//				try {
//					Thread.sleep(1000);
//				}
//				catch(Exception e) {}
//				}
			//Thread calling join() method on the same thread, its another case of deadlock
			Thread t4 = new Thread(
					   ()->{
						   try {
							   Thread.currentThread().join();
						   }
						   catch(InterruptedException e) {}
						   for(int i=0;i<5;i++) {
							   System.out.println("LLL");
						   }
					   }
					);
			t4.start();
			
			
	}
}
