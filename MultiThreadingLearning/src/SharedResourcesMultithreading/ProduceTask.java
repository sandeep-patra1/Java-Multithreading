package SharedResourcesMultithreading;

public class ProduceTask implements Runnable{
	
	SharedResource sharedResource;

	ProduceTask(SharedResource resource){
		this.sharedResource = resource;
	}
	
	@Override
	public void run() {
		System.out.println( "Producer thread: " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000l);
		}catch (Exception e){
		//handte any exception here
		}
		sharedResource.addItem();
	}
}