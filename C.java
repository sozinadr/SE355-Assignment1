import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class C {
    static LinkedList<Byte> dataC = new LinkedList<Byte>();

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1003);
            Socket s1 = s.accept();
            System.out.println("Connection Established");
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());

            while (true) {
                int bytes = bis.read();
                if (bytes == -1) {
                    dataC.add((byte) bytes);
                    break;
                }
                System.out.print((char) bytes);
            }

            // for (int i = 0; i < dataC.size(); i++) {
            //     System.out.print((char) dataC.get(i).byteValue());
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
