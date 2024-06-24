package synchronization;

import multithreading.Stack;

public class Main {
	public static void main(String[] args) {
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

	}
}
