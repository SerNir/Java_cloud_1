package io;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8192);
      log.debug("Server start");
        while(true){
            try {

                Socket socket = server.accept();
                System.out.println("Client accepted");
                Handler handler = new Handler(socket);
                new Thread(handler).start();
            }catch (Exception e){
                System.err.println("Connection was broken");
            }
        }

    }
}
