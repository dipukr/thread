package thread;

import java.util.concurrent.ThreadFactory;

public class Main {
	public static void main(final String[] args) {
		if (args.length != 0)
			System.out.println(args[0]);
		ThreadFactory factory = Thread.ofVirtual().factory();
		factory.newThread(() -> main(new String[] {"hello"})).start();;
	}
}
