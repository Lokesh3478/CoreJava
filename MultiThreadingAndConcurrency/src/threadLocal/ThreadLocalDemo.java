package threadLocal;

import java.util.ArrayList;
class CustomerThread extends Thread{
	static private int id;
    int hashId = 0;
    ThreadLocal<Integer> tl = new ThreadLocal<>() {
    	public Integer initialValue() {
    		return 234;
    	}
    };
	public CustomerThread(String name) {
		super(name);
        synchronized (CustomerThread.class) {
            id++;
        hashId = String.valueOf(name + id).hashCode();
        tl.set(hashId);
        }
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" id "+tl.get());
	}
}
public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadLocal t1 = new ThreadLocal() {
			public Object initialValue() {
				return "Hello World";
			}
		};
		System.out.println(t1.get());
		ArrayList<String>details = new ArrayList<>();
		details.add("LOKESH");
		details.add("2nnf9er93fr3");
		details.add("panapakkam");
		t1.set(details);
		System.out.println(t1.get());
		t1.remove();
		System.out.println(t1.get());

		
		CustomerThread c1 = new CustomerThread("user1234");
		CustomerThread c2 = new CustomerThread("user4566");
		CustomerThread c3 = new CustomerThread("user1344");
		CustomerThread c4 = new CustomerThread("user1234");
		CustomerThread c5 = new CustomerThread("user3122");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}

}
