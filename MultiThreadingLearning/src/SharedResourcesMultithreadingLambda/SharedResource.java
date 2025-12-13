package SharedResourcesMultithreadingLambda;

public class SharedResource {
	boolean isItemPresent = false;

	public synchronized void addItem(){
		isItemPresent = true;
		System.out.println("Producer thread calling the notify method");
		notifyAll();
	}
	public synchronized void consumeItem(){

		System.out.println("Consumer thread inside consumeItem method");
		if(!isItemPresent){
			try {
				System.out.println("Consumer thread is waiting");
				wait();	//release all the monitor lock here
			}catch (Exception e){
				//exception handling goes here
			}
		}
		System.out.println("Consumer thread consume the item");
		isItemPresent = false;
	}
}
