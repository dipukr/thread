package thread;

import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<E> {

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	private Queue<E> queue = new LinkedList<E>();
	private int max = 100;

	public void put(E e) throws Exception {
		lock.lock();
		try {
			while (queue.size() == max)
				notFull.wait();
			queue.offer(e);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public E take() throws Exception {
		lock.lock();
		try {
			while (queue.isEmpty())
				notEmpty.wait();
			E val = queue.poll();
			notFull.signalAll();
			return val;
		} finally {
			lock.unlock();
		}
	}
	
	public int size() {
		return queue.size();
	}
}