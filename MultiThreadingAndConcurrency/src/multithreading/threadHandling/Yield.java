package multithreading.threadHandling;
import multithreading.Thread1;
public class Yield {

	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(
				   ()->{
					  for(int i=0;i<10;i++) {
						  System.out.println("yielded child thread");
						  Thread.yield();
					  }
				  }
				);
		t1.setPriority(10);
		t1.start();

   }
}