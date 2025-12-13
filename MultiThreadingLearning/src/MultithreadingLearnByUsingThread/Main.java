package MultithreadingLearnByUsingThread;

public class Main {
	public static void main(String[] args) {
		System.out.println("Going inside main thread : "+Thread.currentThread().getName());
		MultithreadingLearn thread = new MultithreadingLearn();
		thread.start();
		System.out.println("Finish Main thread : "+Thread.currentThread().getName());
	}
}
