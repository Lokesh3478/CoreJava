package ExceptionTest;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Test {
	
	//CheckedException
	public static void checkedDemo()throws Exception {
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter("abc.txt"));
		bw.write("Hello");
		bw.close();
	}
	
	//try with multiple catch block
	public static void multipleCatch(int n,String str) {
		try {
            // This code may throw various exceptions
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[n]); // This will throw ArrayIndexOutOfBoundsException
            System.out.println(str+" "+str.length()); // This will throw NullPointerException

        } catch (ArrayIndexOutOfBoundsException e) {
        	e.printStackTrace();
        } catch (NullPointerException e) {
        	e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void main(String[] args)throws Exception {
		//Default Exception Handling
		doStuff();
		
		
		//CheckedException
		checkedDemo();
		
		//Methods to print Exception message
		try {
			System.out.println(10/0);
		}
		catch(Exception e) {
			System.out.println("Name of Exception-description-stack trace of where exception occured-Print Stack trace");
			e.printStackTrace();
			System.out.println("Name of exception and description - e.toString()");
			System.out.println(e.toString());
			System.out.println("get Message to print description alone");
			System.out.println(e.getMessage());
			
		}
//		multipleCatch(5, null);
//		multipleCatch(0,null);
//		multipleCatch(0,"hello");
		
	}
	public static void doStuff() {
		System.out.println("Doing stuff");
		doMoreStuff();
	}
	public static void doMoreStuff(){
		System.out.println(10/0);
	}
}
