package concurrency.producer_consumer_project;

public class ProducerThread extends Thread {
    Stack stk;
    public ProducerThread(Stack stk) {
        this.stk = stk;
    }

    public void run() {
        for (int i = 1; i <=10; i++) {
        	try {
	        	Thread.sleep(1000);
	            stk.produce(i);
        	}
        	catch(Exception e) {}
        }
    }
}
