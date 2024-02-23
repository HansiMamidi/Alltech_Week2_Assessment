import java.util.Scanner;

public class MultiThreading {

	public static void main(String[] args) {
		int first, second, third;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number for low priority thread execution");
		first = sc.nextInt();
		System.out.println("Enter a number for medium priority thread execution");
		second = sc.nextInt();
		System.out.println("Enter a number for high priority thread execution");
		third = sc.nextInt();
		
		MyThread t1 = new MyThread(first);
		MyThread t2 = new MyThread(second);
		MyThread t3 = new MyThread(third);
		
		Thread SlowThread = new Thread(t1);
		Thread MediumThread = new Thread(t2);
		Thread FastThread = new Thread(t3);
		
		// Set thread names
        SlowThread.setName("SlowThread");
        MediumThread.setName("MediumThread");
        FastThread.setName("FastThread");
		
		// Set thread priorities
		FastThread.setPriority(Thread.MAX_PRIORITY);  // Priority 1
		MediumThread.setPriority(2);  // Priority 2
		SlowThread.setPriority(Thread.MIN_PRIORITY);  // Priority 3
		
		SlowThread.start();
		MediumThread.start();
		FastThread.start();
		try {
	
			FastThread.join();
			MediumThread.join();
			SlowThread.join();

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
