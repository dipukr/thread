package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Dictionary {
	
	private ReadWriteLock rwlock = new ReentrantReadWriteLock();
	private Map<String, String> dict = new HashMap<>();
	private Lock readLock = rwlock.readLock();
	private Lock writeLock = rwlock.writeLock();
	
	public String get(String key) {
		readLock.lock();
		try {
			return dict.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public void put(String key, String val) {
		writeLock.lock();
		try {
			dict.put(key, val);
		} finally {
			writeLock.unlock();
		}
	}
}
