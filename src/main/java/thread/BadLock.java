package thread;

public class BadLock implements Lock {

	private volatile boolean locked;
	
	public BadLock() {
		this.locked = false;
	}
	
	@Override
	public void lock() {
		while (this.locked);
		this.locked = true;
	}

	@Override
	public void unlock() {
		this.locked = false;
	}
}
