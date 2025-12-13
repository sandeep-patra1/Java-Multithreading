package threadPoolExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		
		//1st create a threadpool executor object
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, 
				new ArrayBlockingQueue<Runnable>(2), new CustomThreadFactory(), new CustomRejectHandler());
		
		//4th submit this using runnable lambda or create a separate runnable class
		for(int i=1; i<=4; i++) {
			 executor.submit(() -> {
				 //assuming this takes time so,
				 try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				 
				 System.out.println("Task processed by: "+Thread.currentThread().getName());
			 });
		}
		//5th shutdown
		executor.shutdown();
	}

}

//2nd explain our own ThreadFactory or can use the default thread factory
//Executor.defaultThreadFactory()
class CustomThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		 Thread thread = new Thread(r);
		 //set threadpriority to normal
		 thread.setPriority(Thread.NORM_PRIORITY);
		 thread.setDaemon(false);
		 //thread.setName(null);
		 return thread;
	}
	
}

//3rd create custom rejection execution handler
class CustomRejectHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task Rejected: "+r.toString());
	}
	
}
