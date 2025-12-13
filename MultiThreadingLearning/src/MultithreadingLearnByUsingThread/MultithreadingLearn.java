package MultithreadingLearnByUsingThread;

public class MultithreadingLearn extends Thread{
	@Override
	public void run() {
		System.out.println("Code executed by thread : "+Thread.currentThread().getName());
	}
}
