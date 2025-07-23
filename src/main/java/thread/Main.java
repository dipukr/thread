package thread;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	public static void main(final String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(10);
		final Runnable producer = () -> {
			while (true) {
				try {
					String data = Objects.toString(System.currentTimeMillis());
					bq.put(data);
					System.out.println("Produced: "+data);
				} catch (InterruptedException e) {
					System.out.println("Producer interrupted: "+Thread.currentThread().getName());
				}
			}
		};
		final Runnable consumer = () -> {
			while (true) {
				try {
					System.out.println("Comsumed: "+bq.take());
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Consumer interrupted: "+Thread.currentThread().getName());
				}
			}
		};
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
	}
}
