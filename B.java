import java.io.*;
import java.net.*;
public class B {
    //byte[][] dataB = new byte[100][1024]; // 100 packets of 1024 bytes
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(1002);
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
                    FileOutputStream fos = new FileOutputStream("B.txt", true);
                    for (int i = 0; i < data.length; i++) { // write the data to the file
                        fos.write(data[i]);
                    }
                    byteCount = 0; // reset the byte count
                    data = new byte[sizeOfData]; // create a new byte array
                    fos.flush(); // flush the output stream
                }
            }
            // while (true) {
            //     int bytes = bis.read();
            //     if (bytes == -1) { // if the end of the stream is reached
            //         data[byteCount++] = (byte) bytes;
            //         Collections.addAll(dataB, data);
            //         break;
            //     }
            // }

            // how to store arrays of bytes in a linked list?

            // for (byte b : dataB) {
            //     System.out.print(b);
            // }

            // while (dataB.listIterator() != null) {
            //     System.out.print(((char) dataB.peek().byteValue()));
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
