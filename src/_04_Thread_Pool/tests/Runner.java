package _04_Thread_Pool.tests;

public class Runner {

	
	
	
	
	
	
	public static void main(String[] args) {
		WorkQueue wq = new WorkQueue();
		for (int i = 0; i < 1000; i++) {
			int b = i;
			Job j = () -> {
				System.out.println("Printing " + b + " from fishie # "
						+ Thread.currentThread().getId());
			};
			wq.addJob(j);
		}
		wq.shutdown();
	}










}
