package thread;

import java.util.LinkedList;
import java.util.Queue;

public class Monitor {

	private Lock lock;
	private Queue<Thread> waitQueue;
	private Queue<Thread> entryQueue;
	
	public Monitor() {
		this.lock = new FineLock();
		this.waitQueue = new LinkedList<>();
		this.entryQueue = new LinkedList<>();
	}
}
