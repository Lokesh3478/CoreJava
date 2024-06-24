package multithreading.threadHandling;

public class Sleep {

	public static void main(String[] args) {
		Thread t1 = new Thread(
				    ()->{
				    	for(int i=0;i<5;i++) {
				    		try {
				    			Thread.sleep(1000,100);
				    		}
				    		catch(Exception e) {}
				    		System.out.println("Slide"+i);
				    	}
				    }
				);
		t1.start();

	}

}
