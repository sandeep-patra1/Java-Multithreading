package MultithreadingLearningUsingRunnable;

public class MultiThreadinglearn implements Runnable {

	@Override
	public void run() {
		System.out.println("Code executed by thread : "+Thread.currentThread().getName());
		
	}
	
}
