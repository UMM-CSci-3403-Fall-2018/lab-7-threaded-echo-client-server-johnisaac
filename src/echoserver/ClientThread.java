package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread implements Runnable {

    InputStream in;
    OutputStream out;

    public ClientThread(InputStream input, OutputStream output) {
        this.in = input;
        this.out = output;
    }

    @Override
    public void run() {

        try {
            int readByte;
            while ((readByte = System.in.read()) != -1) {
                out.write(readByte);
                int socketByte = in.read();
                System.out.write(socketByte);
            }
            System.out.flush();
        } catch (IOException e) {

        }
    }


}