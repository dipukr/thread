package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Dictionary {
	private ReadWriteLock rwlock = new ReentrantReadWriteLock(true);
	private Map<String, String> dict = new HashMap<>();
	private Lock write = rwlock.writeLock();
	private Lock read = rwlock.readLock();
	
	public String get(String key) {
		read.lock();
		try {
			return dict.get(key);
		} finally {
			read.unlock();
		}
	}
	
	public void put(String key, String val) {
		write.lock();
		try {
			dict.put(key, val);
		} finally {
			write.unlock();
		}
	}
}
