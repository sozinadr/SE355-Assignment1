import java.io.*;
import java.net.*;
import java.util.Scanner;

public class A {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the file name");
    String fileName = sc.nextLine();
    int nodeCounter = 0; // to keep track of the node number

    try {
      ServerSocket ss = new ServerSocket(1001);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    // to retrieve the file from the nodes
    while (true) {
      try {
        FileInputStream fis = new FileInputStream(fileName);

        int byteRead = fis.read(); // read a byte from the file
        int sizeOfData = 1024; // 1KB
        byte[] data = new byte[sizeOfData]; // create a byte array of size 1KB
        int byteCount = 0; // count the number of bytes read


        // while (byteRead != -1 && byteCount < sizeOfData) {
        //   data[byteCount++] = (byte) byteRead; // store the byte in the array
        //   byteRead = fis.read(); // read the next byte
        // }

        while (byteRead != -1) { // while the end of the file is not reached

          data[byteCount++] = (byte) byteRead; // store the byte in the byte array

          if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
            // send data to the nodes
            Socket s = new Socket("localhost", 1002 + (nodeCounter++ % 6)); // connect to
            // the nodes
            // Socket s = new Socket("localhost", 1002); // connect to the nodes
            System.out.println("Connection Established");
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the
                                                                                      // nodes
            bos.write(data);
             // write the data to the output stream
            byteCount = 0; // reset the byte count
            data = new byte[sizeOfData]; // create a new byte array
            bos.flush(); // flush the output stream
          }
          byteRead = fis.read(); // read the next byte
          if (byteRead == -1) { // if the end of the file is reached
            // send the remaining data to the nodes
            Socket s = new Socket("localhost", 1002 + (nodeCounter++ % 6)); // connect to
            // the nodes
            BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the
                                                                                      // nodes
            bos.write(data);
            // write the data to the output stream
            byteCount = 0; // reset the byte count
            bos.flush(); // flush the output stream
          }
        }
        fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  // void dataMerge(byte[] buffer, int byteCount) {
  // // to merge the data from the nodes
  // try {
  // FileOutputStream fos = new FileOutputStream("newSend.java");
  // fos.write(buffer, 0, byteCount);
  // fos.close();
  // } catch (IOException e) {
  // e.printStackTrace();
  // }
  // }
}