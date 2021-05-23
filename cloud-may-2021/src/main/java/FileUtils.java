
import java.io.*;

public class FileUtils {
    public static void main(String[] args) throws IOException {
        long a = System.currentTimeMillis();
        try (
                InputStream is = new FileInputStream("src/main/img.jpg");
                OutputStream os = new FileOutputStream("img_copy.jpg");
        ) {
            int b = 0;
            byte [] buffer = new byte[8192];
            while ((b = is.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }
            System.out.println(System.currentTimeMillis()-a);

        }
    }
}