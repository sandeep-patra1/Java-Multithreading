package SharedResourcesMultithreading;

public class SharedResource {
	boolean itemAvailable = false;	//not available
	
	//synchronized put the Monitor Lock
	public synchronized void addItem() {
		itemAvailable = true; 
		System.out.println("Item added By: "+ Thread.currentThread().getName()+" and invoking "
				+ "all Thread which are waiting");
		notifyAll();
	}
	
	public synchronized void consumeItem() {
		System.out.println("consumeItem() is invoked By: "+Thread.currentThread().getName());
		
		//using while Loop to avoid "spurious wake-up", sometimes because of system noise
		while (!itemAvailable) {
			try {
				System.out.println("Thread "+Thread.currentThread().getName()+" is waiting now");
				wait(); //It releases the Monitor Lock
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Item consumed By "+Thread.currentThread().getName());
		itemAvailable = false;
	}
}
