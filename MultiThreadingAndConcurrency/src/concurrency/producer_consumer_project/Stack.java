package concurrency.producer_consumer_project;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Stack {
    private final int[] queue;
    private int size = 0;
    private int front = 0;
    private int rear = 0;
    private final int capacity;
    private static int count = 0;
    private int id;
    private static ReentrantLock staticLock = new ReentrantLock();
    private ReentrantLock objLock = new ReentrantLock();
    private Condition notFull = objLock.newCondition();
    private Condition notEmpty = objLock.newCondition();

    private static void incrementCounter() {
        count++;
    }

    private static int getCounter() {
        return count;
    }

    public Stack(int capacity) {
        staticLock.lock();
        try {
            this.capacity = capacity;
            this.id = capacity;
            this.queue = new int[capacity];
            incrementCounter();
            System.out.println("Buffer " + getCounter() + " created");
        } finally {
            staticLock.unlock();
        }
    }

    public void produce(int val) throws InterruptedException {
        objLock.lock();
        try {
            while (this.size == capacity) {
                notFull.await();
            }
            queue[rear] = val;
            rear = (rear + 1) % capacity;
            size++;
            System.out.println("Successfully Produced " + val + " in stack " +id);
            notEmpty.signal();
        } finally {
            objLock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        objLock.lock();
        try {
            while (this.size == 0) {
                notEmpty.await();
            }
            int val = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Successfully Consumed " + val + " from stack " + id);
            notFull.signal();
            return val;
        } finally {
            objLock.unlock();
        }
    }
}