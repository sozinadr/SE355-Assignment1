import java.io.*;
import java.net.*;
public class B {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1002);
            Socket s1 = s.accept();
            System.out.println("Connection Established");
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());
            System.out.println(bis.readAllBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
