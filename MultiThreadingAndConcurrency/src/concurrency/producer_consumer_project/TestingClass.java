package concurrency.producer_consumer_project;
public class TestingClass {
	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			StackCreation stk = new StackCreation(i);
			stk.start();
		}
	}

}
