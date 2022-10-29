import java.net.*;
import java.io.*;


public class test {
    public static void main(String[] args) {
        try {
            int byteRead = 0;
            ServerSocket ss = new ServerSocket(1002);
            System.out.println("checkpoint 1");
            while (byteRead != -1) {
                try {
                    Socket s = ss.accept();
                    System.out.println("Connection Established");
                    BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
                    for (int i = 1; i <= 1024; i++) {
                        byteRead = bis.read();
                        if (byteRead == -1) break;
                        System.out.print((char)byteRead);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
