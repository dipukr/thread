package thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class FineLock implements Lock {
	
	private AtomicBoolean locked = new AtomicBoolean(false);

	@Override
	public void lock() {
		while (!locked.compareAndSet(false, true));
	}

	@Override
	public void unlock() {
		locked.set(false);
	}
}
