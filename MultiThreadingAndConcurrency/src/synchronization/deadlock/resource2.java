package synchronization.deadlock;

public class resource2 {
	public synchronized void m2(resource1 lock) {
		System.out.println("Thread with resource2 lock starts execution");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e) {}
		System.out.println("Thread with resource2 lock waiting for resource1 lock");
		lock.last();
	}
	public synchronized void last() {
		System.out.println("From resource 2 last method");
	}
}
