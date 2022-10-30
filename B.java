import java.io.*;
import java.net.*;

public class B {
    static int checker;
    static byte[][] byteArrays = new byte[100][1024]; // 100 byte arrays of size 1KB
    public static void main(String[] args) {
        try {
            //int byteRead = 0;
            ServerSocket ss = new ServerSocket(1002);
            FileOutputStream fos = new FileOutputStream("B.cpp", true);
            FileInputStream fis = new FileInputStream("B.cpp");
            while (true) {
                try {
                    Socket s = ss.accept();
                    retrieveData(s);
                    if (checker == -1) {
                        fos.close();
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            /*
             * 
             * SEND DATA BACK TO A
             * 
             */

            while (true) {
                try (ServerSocket ss2 = new ServerSocket(2002)) {
                    Socket s = ss2.accept();
                    System.out.println("check point 2");
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

    // send backup data to next node


    static void retrieveData (Socket s) {
        try {
            int byteRead = 0;
            //FileOutputStream fos = new FileOutputStream("B.cpp", true);
                    BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
                    for (int i = 0; i < 1024; i++) {
                        for (byte[] b : byteArrays) {
                            for (byte n : b) {
                                n = (byte) bis.read();
                                if (byteRead == -1) {
                                    checker = -1;
                                    break;
                                }
                            }
                        }
                        if (byteRead == -1 || byteRead == 255) {
                            System.out.println("check point 3");
                            break;
                        }
                        // fos.write(byteRead);
                        // fos.flush();
                    }
                    if (byteRead == -1 || byteRead == 255) {
                        //fos.close();
                        checker = -1;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    static void retrieveBackup (Socket s) {
        try {
            int byteRead = 0;
            FileOutputStream fos = new FileOutputStream("Fbackup.cpp", true);
            while (true) {
                try {
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
                // for (byte arr : data) {
                //     if (arr == 0) {
                //         bos.write(-1);
                //         bos.flush();
                //         break;
                //     }
                //     // System.out.println(arr);
                //     bos.write(arr);
                //     bos.flush();
                // }
                for (byte[] b : byteArrays) {
                    for (byte n : b) {
                        if (n == 0) {
                            bos.write(-1);
                            bos.flush();
                            break;
                        }
                        bos.write(n);
                        bos.flush();
                    }
                }
                bos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}