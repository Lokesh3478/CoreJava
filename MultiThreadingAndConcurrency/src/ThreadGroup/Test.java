package ThreadGroup;

public class Test {

	public static void main(String[] args) throws Exception {
		
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		ThreadGroup g = new ThreadGroup("First Group");
		System.out.println(g.getParent().getName());
		ThreadGroup g1 = new ThreadGroup(g,"SecondGroup");
		System.out.println(g1.getParent().getName());
		
		//Working with ThreadPriorities
		Thread t1 = new Thread(g,"First Thread");
	    System.out.println("Before adding to group "+t1.getPriority());
	    g.setMaxPriority(3);
	    System.out.println("After adding to group "+t1.getPriority());
		//Adding Higher Priority Thread
	    Thread t2 = new Thread(g,"SecondThread");
	    System.out.println("Adding higher priority thread "+t2.getPriority());
	    g.list();
	    
	    ThreadGroup parentGroup = new ThreadGroup("ParentGroup");
	    ThreadGroup childGroup = new ThreadGroup("childGroup");
	    ChildThread c1 = new ChildThread(parentGroup,"Child Thread 1");
	    ChildThread c2 = new ChildThread(parentGroup,"Child Thread 2");
	    c1.start(); c2.start();
	    System.out.println(parentGroup.activeCount());
	    System.out.println(parentGroup.activeGroupCount());
	    parentGroup.list();
	    Thread.sleep(10000);
	    System.out.println(parentGroup.activeCount());
	    System.out.println(parentGroup.activeGroupCount());
	    parentGroup.list();
	    
	    //Code Block to print All Threads
	    
	    ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
	    Thread[] k = new Thread[system.activeCount()];
	    system.enumerate(k);
	    for(Thread t : k) {
	    	System.out.println(t.getName()+" "+t.isDaemon());
	    }
		
		
		
		
		
		
		
		
		
		
//		System.out.println(Thread.currentThread());
//		System.out.println(Thread.currentThread().getId());
//		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getPriority());
//		System.out.println(Thread.currentThread().getClass());
//		System.out.println(Thread.currentThread().getContextClassLoader());
//		System.out.println(Thread.currentThread().getStackTrace());
//		System.out.println(Thread.currentThread().getState());
//		System.out.println(Thread.currentThread().getThreadGroup());
//		System.out.println(Thread.currentThread().getUncaughtExceptionHandler());
//		System.out.println(Thread.currentThread().getDefaultUncaughtExceptionHandler());
//		System.out.println(Thread.currentThread().getAllStackTraces());
//		System.out.println(Thread.currentThread().hashCode());
//		System.out.println(Test.class.getSuperclass());
			
	}

}
