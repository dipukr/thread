package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;

public class Counter {

	private Lock lock = new ReentrantLock();
	private int count = 0;
	
	public Counter(int start) {
		this.count = start;
	}
	
	public void increment() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}
	
	public void incrementAsync() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
