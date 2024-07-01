package ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable{
	int num;
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" executes sum of "+this.num);
		int sum = 0;
		for(int i =1;i<=num;i++) {
			sum+=i;
		}
		return sum;
	}
}
public class FutureCallableDemo {

	public static void main(String[] args) throws Exception {
		MyCallable[]jobs = new MyCallable[] {
				new MyCallable(10),
				new MyCallable(11),
				new MyCallable(34),
				new MyCallable(60)
		};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(MyCallable job : jobs) {
			Future f = service.submit(job);
			System.out.println(f.get());
		}

	}

}
