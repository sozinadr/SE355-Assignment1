import java.io.*;
import java.net.*;

public class F {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1006);
            Socket s1 = s.accept();
            System.out.println("Connection Established");
            BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());
            int sizeOfData = 1024; // 1KB
            byte[] data = new byte[sizeOfData]; // create a byte array of size 1KB
            int byteCount = 0; // count the number of bytes read

            while (true) {
                int byteRead = bis.read();
                if (byteRead == -1) { // end of stream
                    break;
                }
                data[byteCount++] = (byte) byteRead; // store the byte in the byte array
                if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
                    // write the data to the file
                    FileOutputStream fos = new FileOutputStream("F.txt", true);
                    for (int i = 0; i < data.length; i++) { // write the data to the file
                        fos.write(data[i]);
                    }
                    byteCount = 0; // reset the byte count
                    data = new byte[sizeOfData]; // create a new byte array
                    fos.flush(); // flush the output stream
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}