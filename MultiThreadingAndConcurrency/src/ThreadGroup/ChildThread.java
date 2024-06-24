package ThreadGroup;

public class ChildThread extends Thread {
	ChildThread(ThreadGroup g,String name){
		super(g,name);
	}
	@Override
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {}
		super.run();
	}
}
