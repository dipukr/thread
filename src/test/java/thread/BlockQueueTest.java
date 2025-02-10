package thread;

import com.github.javafaker.Faker;

public class BlockQueueTest {
	public static void main(final String[] args) throws Exception {
		var queue = new BlockQueue<String>();
		var faker = new Faker();
		Runnable producer = () -> {
			try {
				while (true) {
					Thread.sleep(100);
					String name = faker.animal().name();
					queue.put(name);
					System.out.printf("Produced: %s\n", name);
				}	
			} catch (Exception e) {}
		};
		Runnable consumer = () -> {
			try {
				while (true) {
					Thread.sleep(100);
					System.out.printf("Consumed: %s\n", queue.take());
				}
			} catch (Exception e) {}
		};
		var producerThread = new Thread(producer);
		var consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
		consumerThread.join();
		producerThread.join();
	}
}
