package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class KeyboardReader implements Runnable {
    //InputStream userInput = new InputStreamreader(System.in);
    Socket socket;

    public KeyboardReader(Socket socket){
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            int readByte;
            while ((readByte = System.in.read()) != -1) {
                out.write(readByte);
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}