
public class MyThread implements Runnable {

	private int number;

	public MyThread(int number) {
		this.number=number;
	}
	
	@Override
	public void run() {
	    System.out.println(Thread.currentThread().getName() + " executing:");
	    for(int i = 1; i <= 10; i++) {
	        System.out.println(number + " * " + i + " = " + (number * i));
	    }
        System.out.println(Thread.currentThread().getName() + " finished...");
	}

	

}
