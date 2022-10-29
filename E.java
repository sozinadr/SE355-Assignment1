import java.io.*;
import java.net.*;

public class E {
    public static void main(String[] args) {
        try {
            int byteRead = 0;
            ServerSocket ss = new ServerSocket(1005);
            while (true) {
                try {
                    Socket s = ss.accept();
                    System.out.println("Connection Established");
                    BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
                    FileOutputStream fos = new FileOutputStream("E.cpp", true);
                    for (int i = 0; i < 1024; i++) {
                        byteRead = bis.read();
                        if (byteRead == 255 || byteRead == -1) {
                            break;
                        } 
                        fos.write(byteRead);
                        fos.flush();
                    }
                    if (byteRead == 255 || byteRead == -1) {
                        break;
                    } 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // send data back to A
            while (true) {
                try {
                    Socket s = new Socket("localhost", 1001);
                    BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
                    FileInputStream fis = new FileInputStream("B.cpp");
                    int byteRead2 = 0;
                    while (true) {
                        byteRead2 = fis.read();
                        if (byteRead2 == -1) {
                            break;
                        }
                        bos.write(byteRead2);
                        bos.flush();
                    }
                    bos.write(255);
                    bos.flush();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









//         try {
//             ServerSocket s = new ServerSocket(1005);
//             Socket s1 = s.accept();
//             System.out.println("Connection Established");
//             BufferedInputStream bis = new BufferedInputStream(s1.getInputStream());
//             int sizeOfData = 1024; // 1KB
//             byte[] data = new byte[sizeOfData]; // create a byte array of size 1KB
//             int byteCount = 0; // count the number of bytes read

//             while (true) {
//                 int byteRead = bis.read();
//                 if (byteRead == -1) { // end of stream
//                     break;
//                 }
//                 data[byteCount++] = (byte) byteRead; // store the byte in the byte array
//                 if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
//                     // write the data to the file
//                     FileOutputStream fos = new FileOutputStream("E.txt", true);
//                     for (int i = 0; i < data.length; i++) { // write the data to the file
//                         fos.write(data[i]);
//                     }
//                     byteCount = 0; // reset the byte count
//                     data = new byte[sizeOfData]; // create a new byte array
//                     fos.flush(); // flush the output stream
//                 }
//             }

//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }