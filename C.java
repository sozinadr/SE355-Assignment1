import java.io.*;
import java.net.*;

public class C {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 900);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("NewFile1.pdf"));
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
