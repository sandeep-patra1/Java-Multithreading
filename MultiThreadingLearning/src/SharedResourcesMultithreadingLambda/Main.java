package SharedResourcesMultithreadingLambda;

public class Main {
	public static void main(String[] args) {
		
		SharedResource sharedResourceObj = new SharedResource();
		
		Thread producerThread = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			sharedResourceObj.addItem();
		});
		Thread consumerThread = new Thread(() -> {
			sharedResourceObj.consumeItem();
		});
		
		producerThread.start();
		consumerThread.start();
	}
}
