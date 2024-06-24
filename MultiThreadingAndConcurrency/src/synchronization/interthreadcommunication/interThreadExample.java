package synchronization.interthreadcommunication;

public class interThreadExample {
    public static void main(String[] args) {
        Buffer b1 = new Buffer(5);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    b1.produce(i);
                    //System.out.println("Successfully Produced " + i);
                } catch (InterruptedException e) {
                    //Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    int val = b1.consume();
                    //System.out.println("Successfully Consumed " + val);
                } catch (InterruptedException e) {
                    //Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
