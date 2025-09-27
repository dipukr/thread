package thread;

public class Dead {
	public static void main(String[] args) throws Exception {
		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		Thread first = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread1: locked resource1");
					// Pause for a bit, simulating some file IO or something
					// Basically want to give the other thread a chance to run
					try { 
						Thread.sleep(100);
					} catch (InterruptedException e) {}
					synchronized (resource2) {
						System.out.println("Thread1: locked resource2");
					}
				}
			}
		};

		Thread second = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread2: locked resource2");
					try {
						Thread.sleep(100); 
					} catch (InterruptedException e) {}
					synchronized (resource1) {
						System.out.println("Thread2: locked resource1");
					}
				}
			}
		};
		first.start();
		second.start();
	}
}