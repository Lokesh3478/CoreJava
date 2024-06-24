package concurrency.producer_consumer_project;

public class ConsumerThread extends Thread {
    Stack stk;
    public ConsumerThread(Stack stk) {
        this.stk = stk;
    }

    public void run() {
        for (int i = 1; i <=10; i++) {
        	try {
        		Thread.sleep(1000);
        		int val = stk.consume();
        	}
        	catch(Exception e) {}
        }
    }
}
