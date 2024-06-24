package multithreading;

public class Stack {
    private int arr[];
    private int top = -1;
    private static int count = 0; // Static variable to count instances of Stack

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        this.arr = new int[size];
        incrementCount(); // Increment instance count when a new Stack is created
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top < 0;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top >= arr.length - 1;
    }

    // Method to push an element onto the stack
    public synchronized boolean push(int val) {
        if (this.isFull()) return false; // Check if stack is full
        ++top; // Increment top pointer
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        arr[top] = val; // Push value onto the stack
        return true;
    }

    // Method to pop an element from the stack
    public synchronized int pop() {
        if (this.isEmpty()) return Integer.MIN_VALUE; // Check if stack is empty
        int val = arr[top]; // Get value from top of stack
        arr[top] = Integer.MIN_VALUE; // Clear element from stack
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        top--; // Decrement top pointer
        return val; // Return popped value
    }

    // Method to get the current count of Stack instances
    public synchronized static int getCounter() {
        return count;
    }

    // Method to increment the instance count
    private static void incrementCount() {
        count++;
    }
}
