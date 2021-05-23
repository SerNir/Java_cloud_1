package HW1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8585);
        System.out.println("Server start!");

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("client connected");
                Handler handler = new Handler(client);
                new Thread(handler).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}