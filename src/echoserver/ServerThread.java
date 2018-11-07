package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            int b;
            while ((b = in.read()) != -1){
                out.write(b);
            }
            socket.shutdownOutput();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}