package AssignmentMultithreading;

public class ProducerConsumerLearning {
	public static void main(String[] args) {

		SharedResource sharedBuffer = new SharedResource(3);
	
		//creating producer thread using Lambda expression
		Thread producerThread = new Thread(() -> {
			try {
				for (int i = 1; i <= 6; i++) {
					sharedBuffer.produce(i);
				}
			} catch (Exception e) {
				//handle exception here
			}
		});
		
		//creating consumer thread using Lambda expression
		Thread consumerThread = new Thread(() -> {
			try {
				for (int i = 1; i <= 6; i++) {
					sharedBuffer.consume();
				}
			}catch(Exception e) {
				//handle exception here				
			}
		});
		
		producerThread.start();
		consumerThread.start();
		//it'll lock the shared resource locked either by cosumer thread or producer thread because they want
		//to use the same shared resource
	}
}
