package thread;

public class Demo {
	public static void main(String[] args) throws Exception {
		var demo = new Demo();
		synchronized (demo) {
			demo.wait();
		}
		System.out.println("hello");
	}
}
