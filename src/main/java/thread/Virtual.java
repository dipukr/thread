package thread;

import java.util.concurrent.ThreadFactory;

public class Virtual {
	public static void task() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
	}
	public static void main(final String[] args) throws Exception {
		new Thread(() -> task()).start();
		ThreadFactory factory = Thread.ofVirtual().factory();
		Thread thread = factory.newThread(Virtual::task);
		System.out.println(thread.isVirtual());
		System.out.println("leaving");
	}
}
