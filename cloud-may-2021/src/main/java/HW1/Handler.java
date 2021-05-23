package HW1;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler implements Runnable, Closeable {
    private final Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Serzh\\IdeaProjects\\cloud-may-2021\\src\\main\\text.txt");
             FileOutputStream fos = new FileOutputStream("C:\\Users\\Serzh\\IdeaProjects\\cloud-may-2021\\src\\main\\text_dump.txt")) {
            int b = 0;
            byte[] buffer = new byte[1024];
            while ((b = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, b);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void close() throws IOException {
socket.close();
    }
}
