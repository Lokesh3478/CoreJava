package synchronization.interthreadcommunication;
public class Buffer {
    private final int[] queue;
    private int size = 0;
    private int front = 0;
    private int rear = 0;
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public synchronized void produce(int val) throws InterruptedException {
        while (size == capacity) {
            this.wait(); // Wait if the buffer is full
        }
        queue[rear] = val;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Successfully Produced " + val);
        this.notify(); // Notify all waiting threads
    }

    public synchronized int consume() throws InterruptedException {
        while (size == 0) {
            this.wait(); // Wait if the buffer is empty
        }
        int val = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Successfully Consumed " + val);
        this.notify(); // Notify all waiting threads
        return val;
    }
}