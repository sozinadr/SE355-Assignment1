import java.io.*;
import java.net.*;
import java.util.Scanner;

public class A {
  static ServerSocket ss = null;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the file name");
    String fileName = sc.nextLine();
    int nodeCounter = 0; // to keep track of the node number

    try {
      ss = new ServerSocket(1001);
      FileInputStream fis = new FileInputStream(fileName);
      while (true) {
        try {
          int byteRead = fis.read(); // read a byte from the file
          int sizeOfData = 1024; // 1KB
          byte[] data = new byte[sizeOfData]; // create a byte array of size 1KB
          int byteCount = 0; // count the number of bytes read

          while (byteRead != -1) { // while the end of the file is not reached
            if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
              byteCount = 0; // reset the byte count
              break;
            }
            data[byteCount++] = (byte) byteRead; // store the byte in the byte array
            byteRead = fis.read(); // read the next byte
          }

          
          sendArray(data, nodeCounter);
          
          if (byteRead == -1) { // if the end of the file is reached
            fis.close(); // close the file input stream
            break;
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      while (true) {
        System.out.println("checkpoint 1");
        nodeMerge();
        System.out.println("checkpoint 2");
      }

    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

  static void sendArray (byte[] data, int nodeCounter) {
    try {
        //System.out.println("did connect or no??");
        Socket s = new Socket("localhost", (1002 + nodeCounter % 1));
        System.out.print("socket Changed to port: " + (1002 + nodeCounter % 1) + "\n");
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        for (byte arr: data) {
          if (arr == 0) {
            bos.write(-1);
            bos.flush();
            break;
          }
          bos.write(arr);
          bos.flush();
        }
        bos.close();
        s.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

static void nodeMerge () {
    try {
        //ServerSocket ss = new ServerSocket(1007);
        Socket s = ss.accept();
        System.out.println("Connection Established");
        BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
        FileOutputStream fos = new FileOutputStream("A.cpp", true);
        int byteRead = bis.read();
        for (int i = 0; i < 1024; i++) {
          if (byteRead == 255 || byteRead == -1) {
            break;
          }
          fos.write(byteRead);
          fos.flush();
        }
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