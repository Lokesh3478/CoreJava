package threadLocal;
class ParentThread extends Thread{
	static ThreadLocal<String> normaltl = new ThreadLocal<>();
	static InheritableThreadLocal<String> inheritLocal= new InheritableThreadLocal<>();
	static InheritableThreadLocal<String> customChildValue = new InheritableThreadLocal<>() {
		protected String childValue(String parentValue) {
		       return "CustomizedChildValue";	
			
		}
	};
	@Override
	public void run() {
		normaltl.set("Parent Value");
		inheritLocal.set("Inherited Local value");
		ChildThread c1 = new ChildThread();
		c1.start();	
	}
class ChildThread extends Thread{
	public void run() {
		ThreadLocal<String> l = new ThreadLocal<String>();
		System.out.println("Child Thread"+ParentThread.normaltl+" "+ParentThread.inheritLocal.get()+" "+ParentThread.customChildValue.get());
	}
}
}
public class ThreadDemo2 {
	public static void main(String[] args) {
		ParentThread p1 = new ParentThread();
		p1.start();
	}
	
}
