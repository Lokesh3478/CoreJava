package synchronization.deadlock;

public class resource1 {
	public synchronized void m2(resource2 lock) {
		System.out.println("Thread with resource1 lock starts execution");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e) {}
		System.out.println("Thread with resource1 lock waiting for resource2 lock");
		lock.last();
	}
	public synchronized void last() {
		System.out.println("From resource1 last method");
	}
}
