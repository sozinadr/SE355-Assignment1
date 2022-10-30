import java.io.*;
import java.net.*;

public class D {
    public static void main(String[] args) {
        try {
            int byteRead = 0;
            ServerSocket ss = new ServerSocket(1004);
            FileOutputStream fos = new FileOutputStream("D.cpp", true);
            FileInputStream fis = new FileInputStream("D.cpp");
            while (true) {
                try {
                    Socket s = ss.accept();
                    System.out.println("Connection Established");
                    BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
                    for (int i = 0; i < 1024; i++) {
                        byteRead = bis.read();
                        if (byteRead == -1 || byteRead == 255) {
                            System.out.println("check point 2");
                            break;
                        }
                        fos.write(byteRead);
                        fos.flush();
                    }
                    if (byteRead == -1 || byteRead == 255) {
                        fos.close();
                        break;
                    }
                } catch (IOException e) {
                    break;
                }

            }

            /*
             * 
             * SEND DATA BACK TO A
             * 
             */

            while (true) {
                try (ServerSocket ss2 = new ServerSocket(2004)) {
                    Socket s = ss2.accept();
                    System.out.println("check point 3");
                    int byteRead2 = fis.read(); // read a byte from the file
                    int sizeOfData = 1024; // 1KB
                    byte[] data = new byte[sizeOfData]; // create a byte array of size 1KB
                    int byteCount = 0; // count the number of bytes read

                    while (byteRead2 != -1) { // while the end of the file is not reached
                        if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
                            byteCount = 0; // reset the byte count
                            break;
                        }
                        data[byteCount++] = (byte) byteRead2; // store the byte in the byte array
                        byteRead2 = fis.read(); // read the next byte
                    }

                    sendArrayBackToA(data, s);

                    if (byteRead2 == -1) { // if the end of the file is reached
                        fis.close(); // close the file input stream
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void sendArrayBackToA(byte[] data, Socket s) {
        try {
            // System.out.println("did connect or no??");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
            if (dis.readUTF().equals("retrieve")) {
                for (byte arr : data) {
                    if (arr == 0) {
                        bos.write(-1);
                        bos.flush();
                        break;
                    }
                    // System.out.println(arr);
                    bos.write(arr);
                    bos.flush();
                }
                bos.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}













//         try {
//             ServerSocket s = new ServerSocket(1004);
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
//                     FileOutputStream fos = new FileOutputStream("D.txt", true);
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