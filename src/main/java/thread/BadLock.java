package thread;

public class BadLock implements Locker {

	private volatile boolean locked;
	
	public BadLock() {
		this.locked = false;
	}
	
	@Override
	public void lock() {
		while (locked)
			System.out.println("Another thread holding the lock.");
		locked = true;
	}

	@Override
	public void unlock() {
		this.locked = false;
	}
}
