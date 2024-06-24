package concurrency.producer_consumer_project;

public class StackCreation extends Thread {
	int size;
	Stack stk;
	ProducerThread p;
	ConsumerThread c;
	public StackCreation(int i) {
		this.size = i;
		this.stk = new Stack(size);
		p = new ProducerThread(stk);
		c = new ConsumerThread(stk);
	}
	@Override
	public void run() {
		p.start();
		c.start();
	}
	
}


