package multithreading;

public class ThreadTesting {
    public static void main(String args[]) {
        // Loop to create multiple instances of Stack
        for (int a = 0; a < 6; a++) {
            // Create a new instance of Stack with capacity 5
            Stack stk = new Stack(5);

            // Thread for pushing values into the stack
            new Thread(() -> {
            	System.out.println("Instance " + Stack.getCounter()+" started");
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Pushed Value " + i + " " + stk.push(i));
                }
            }).start();

            // Thread for popping values from the stack
            new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Popped Value " + stk.pop());
                }
                System.out.println("Instance " + Stack.getCounter()+" ended");
            }).start();

            // Print the current instance count of Stack
        }
    }
}
