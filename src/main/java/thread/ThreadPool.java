package thread;

import java.util.List;

public class ThreadPool {

	private BlockQueue<Worker> workerThreads;
	private List<Runnable> tasks;
	
	public ThreadPool(int threadCount) {
		this.workerThreads = new BlockQueue<>(threadCount);
	}
	
	public void shutdown() {
		
	}
	
	public void waitTillTasksFinished() {
		
	}
}
