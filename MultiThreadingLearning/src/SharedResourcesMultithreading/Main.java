package SharedResourcesMultithreading;

public class Main {
	public static void main(String[] args) {
		System. out.println("Main method start");
		
		SharedResource sharedResource = new SharedResource();

		// producer thread
		Thread producerThread = new Thread(new ProduceTask(sharedResource));
		// consumer thread
		Thread consumerThread = new Thread(new ConsumeTask(sharedResource));
		
		//here the both the thread works on the same shared resource
		
		//thread is in "RUNNABLE state"
		producerThread.start();
		consumerThread.start();

		System.out.println("Main method end");
	}
}
/*
 	//Or use lambda expression, instead of creating ProduceTask and ConsumeTask class

	Thread consunerThread = new Thread(() -> {
	System.out.printin("Consumer Thread: "+ Thread.currentThread().getName());
	sharedResource.consumeItem();
	});

*/
