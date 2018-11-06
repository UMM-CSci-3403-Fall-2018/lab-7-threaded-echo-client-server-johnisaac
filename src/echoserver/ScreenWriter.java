package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class ScreenWriter implements Runnable {

    InputStream in;
    Socket socket;

    public ScreenWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = socket.getInputStream();
            int readByte;
            while ((readByte = in.read()) != -1) {
                System.out.write(readByte);
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }


}