import java.io.*;
import java.net.*;
public class B {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1002);
            Socket s1 = s.accept();
            System.out.println("Connection Established");
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());

            while (true) {
                int i = bis.read();
                if (i == -1) {
                    break;
                }
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
