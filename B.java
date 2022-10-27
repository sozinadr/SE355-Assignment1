import java.io.*;
import java.net.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
public class B {
    static LinkedList<Byte> dataB = new LinkedList<>();
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1002);
            Socket s1 = s.accept();
            System.out.println("Connection Established");
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());
            int sizeOfData = 1024; // 1KB
            Byte[] data = new Byte[sizeOfData]; // create a byte array of size 1KB
            int byteCount = 0; // count the number of bytes read

            while (true) {
                int bytes = bis.read();
                if (bytes == -1) { // if the end of the stream is reached
                    data[byteCount++] = (byte) bytes;
                    Collections.addAll(dataB, data);
                    break;
                }
            }

            // how to store arrays of bytes in a linked list?

            for (byte b : dataB) {
                System.out.print(b);
            }

            // while (dataB.listIterator() != null) {
            //     System.out.print(((char) dataB.peek().byteValue()));
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
