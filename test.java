import java.net.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        try {
            int byteRead = 0;
            ServerSocket ss = new ServerSocket(1002);
            System.out.println("checkpoint 1");
            while (true) {
                try {
                    Socket s = ss.accept();
                    System.out.println("Connection Established");
                    BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
                    FileOutputStream fos = new FileOutputStream("C.cpp", true);
                    for (int i = 0; i < 1025; i++) {
                        byteRead = bis.read();
                        if (byteRead == 255) {
                            System.out.println("checkpoint 2");
                            break;
                        } 
                        fos.write(byteRead);
                        fos.flush();
                    }
                    System.out.println(byteRead);
                    if (byteRead == 255) {
                        System.out.println("checkpoint 3");
                        break;
                    } 
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("checkpoint 4");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
