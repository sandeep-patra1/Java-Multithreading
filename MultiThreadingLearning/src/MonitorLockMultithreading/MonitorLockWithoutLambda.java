package MonitorLockMultithreading;

public class MonitorLockWithoutLambda implements Runnable{
	
	MonitorLockExample obj;
	
	public MonitorLockWithoutLambda(MonitorLockExample obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.task1();
	}

}
