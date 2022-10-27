import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class F {
    static LinkedList<Byte> dataF = new LinkedList<Byte>();
    

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1006);
            Socket s1 = s.accept();
            System.out.println("Connection Established");
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());

            // while (true) {
            //     int bytes = bis.read();
            //     if (bytes == -1) {
            //         dataF.add((byte) bytes);
            //         break;
            //     }
            //     System.out.print((char) bytes);
            // }

            while (true) {
            }

            // for (int i = 0; i < dataF.size(); i++) {
            //     System.out.print((char) dataF.get(i).byteValue());
            // }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
