package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException, InterruptedException {
		Socket socket = new Socket("localhost", PORT_NUMBER);

		InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();

		Thread keys = new Thread(new KeyboardReader(socket));
		keys.start();

		Thread writer = new Thread(new ScreenWriter(socket));
		writer.start();

		keys.join();
		writer.join();

		/*InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();
		int readByte;
		while ((readByte = System.in.read()) != -1) {
			socketOutputStream.write(readByte);
			int socketByte = socketInputStream.read();
			System.out.write(socketByte);
		}
		System.out.flush();*/

	}
}