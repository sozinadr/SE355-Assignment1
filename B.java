import java.io.*;
import java.net.*;

public class B {
    public static void main(String[] args) {
        while (true) {
            
            try {
                ServerSocket s = new ServerSocket(1002);
                Socket s1 = s.accept();
                System.out.println("Connection Established");
                BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());
                int sizeOfData = 1024; // 1KB
                byte[] data = new byte[sizeOfData]; // create a byte array of size 1KB
                byte[][] dataB = new byte[100][]; // 100 packets of ?? bytes
                int byteCount = 0; // count the number of bytes read

                while (true) {

                    int byteRead = bis.read();
                    if (byteRead == -1) { // end of stream
                        break;
                    }
                    data[byteCount++] = (byte) byteRead; // store the byte in the byte array
                    if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
                        for (int i = 0; i < dataB.length; i++) {
                            for (int j = 0; j < dataB[i].length; j++) {
                                dataB[i][j] = data[j]; // [0][j] = data[j]
                            }
                        }
                    }
                    
                    // int byteRead = bis.read();
                    // if (byteRead == -1) { // end of stream
                    //     break;
                    // }
                    // data[byteCount++] = (byte) byteRead; // store the byte in the byte array
                    // if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
                    //     // write the data to the file
                    //     FileOutputStream fos = new FileOutputStream("B.txt", true);
                    //     for (int i = 0; i < data.length; i++) { // write the data to the file
                    //         fos.write(data[i]);
                    //     }
                    //     byteCount = 0; // reset the byte count
                    //     data = new byte[sizeOfData]; // create a new byte array
                    //     fos.flush(); // flush the output stream
                    // }
                }
                // while (true) {
                // int bytes = bis.read();
                // if (bytes == -1) { // if the end of the stream is reached
                // data[byteCount++] = (byte) bytes;
                // Collections.addAll(dataB, data);
                // break;
                // }
                // }
    
                // how to store arrays of bytes in a linked list?
    
                // for (byte b : dataB) {
                // System.out.print(b);
                // }
    
                // while (dataB.listIterator() != null) {
                // System.out.print(((char) dataB.peek().byteValue()));
                // }
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
import java.io.*;
import java.net.*;
public class B {
    //byte[][] dataB = new byte[100][1024]; // 100 packets of 1024 bytes
    public static void main(String[] args) {
        while (true) {
            try {
                ServerSocket s = new ServerSocket(1002);
                Socket s1 = s.accept();
                System.out.println("Connection Established");
                BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());

                for (int i = 0; i < 1024; i++) {
                    int byteRead = bis.read();
                    if (byteRead == -1) { // end of stream
                        break;
                    }
                        FileOutputStream fos = new FileOutputStream("B.txt", true);
                        System.out.println((char)byteRead);
                        fos.write(byteRead);
                        fos.flush(); // flush the output stream
                }

                    // while (true) {
                    //     int byteRead = bis.read();
                    //     if (byteRead == -1) { // end of stream
                    //         break;
                    //     }
                    //     System.out.print((char)byteRead);
                    // }

                // while (true) {
                //     try { 
                //         Socket s2 = new Socket("localhost", 1003); // connect to C
                //         BufferedOutputStream bos = new BufferedOutputStream(s2.getOutputStream()); // get the output stream
                //         FileInputStream fis = new FileInputStream("B.txt"); // open the file
                //         int byteRead = 0; // count the number of bytes read
                //         while ((byteRead = fis.read()) != -1) { // read the file
                //             bos.write(byteRead); // write the byte to the output stream
                //         }
                //         bos.flush();
                //         s2.close();
                //         break;
                //     } catch (IOException e) {
                //         e.printStackTrace();
                //     }
                // }
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
*/