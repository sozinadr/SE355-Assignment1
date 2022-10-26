import java.io.*;
import java.net.*;
public class B {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(2000);
            Socket s1 = s.accept();
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("NewFile1.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
