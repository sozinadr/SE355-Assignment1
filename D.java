import java.io.*;
import java.net.*;

public class D {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1004);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("NewFile1.pdf"));
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
