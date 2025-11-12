package thread;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URI;

public class Download implements Runnable {
	private String url;
	
	public Download(String url) {
		this.url = url;
	}
	
	@Override
	public void run() {
		try (var inputStream = URI.create(url).toURL().openStream()) {
			var inStream = new BufferedInputStream(inputStream);
			var outStream = new FileOutputStream(url);
			byte[] buffer = new byte[1024];
			while (true) {
				int count = inStream.read(buffer, 0, 1024);
				if (count == -1) break;
				outStream.write(buffer, 0, count);
			}
			outStream.close();
		} catch (Exception e) {
			System.out.println("ERROR: Download failed");
		}
	}
	
	public static void main(String[] args) {
		for (String arg: args) {
			var download = new Download(arg);
			Thread thread = new Thread(download);
			thread.start();
		}
	}
}
