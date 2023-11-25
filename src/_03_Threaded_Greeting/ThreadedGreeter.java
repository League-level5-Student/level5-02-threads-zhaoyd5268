package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	// member variables
	
	int v;
	
	public ThreadedGreeter(int v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (v <= 50) {
			Thread newT = new Thread(()->  {
				System.out.println("Hello from thread #" + v);
			});
			newT.start();
			ThreadedGreeter tg = new ThreadedGreeter(v+1);
			tg.run();
		}
		
		
		
	}

}
