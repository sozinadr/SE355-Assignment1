
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class A {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the file name");
    String fileName = sc.nextLine();
    try {
      ServerSocket ss = new ServerSocket(1000);
      Socket s = ss.accept();
      FileInputStream fis = new FileInputStream(fileName);
      BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
      int byteRead = fis.read();
      int sizeOfData = 1024;
      byte[] data = new byte[sizeOfData];
      int byteCount = 0;
      int nodeCounter = 1; // B
      while (byteRead != -1) {
        data[byteCount++] = (byte) byteRead;
        if (byteCount == sizeOfData) {

          bos.write(data);

          byteCount = 0;
          nodeCounter++;
        }
        byteRead = fis.read();
      }
      bos.flush();
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}