package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	public PrintJob(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(name+" started by "+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {}
		System.out.println(name+" ended by "+Thread.currentThread().getName());
	}
}

public class Demo1 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		PrintJob[]jobs = new PrintJob[] {
				new PrintJob("Lokesh"),
				new PrintJob("Lalith"),
				new PrintJob("Lohesh"),
				new PrintJob("Kalyaan"),
				new PrintJob("Likesh"),
				new PrintJob("Kanagavel")
		};
		for(PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

}
