package MultithreadingLearningUsingRunnable;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Going Inside Main thread : "+Thread.currentThread().getName());
		MultiThreadinglearn runnableObj = new MultiThreadinglearn();
		//Thread thread = new Thread(runnableObj);	//Thread created and pass the runnable Obj
		Thread thread = new Thread(runnableObj,"MyThread-1");	//Thread created and pass the runnable Obj
		
		thread.start();		//internally call the run()
		thread.join(); // main waits here until Worker-1 finishes
		//thread.setName("MyThread-1");
		System.out.println("Finish main thread : "+Thread.currentThread().getName());
	}
}
