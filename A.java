
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class A {

  public static void main(String[] args) {
  
      
  Scanner sc = new Scanner(System.in);
  String filePath = sc.nextLine();
  try {
    FileInputStream fis = new FileInputStream(filePath);
    //BufferedReader reader = new BufferedReader(new FileReader(filePath));
    int byteRead = fis.read();
    int sizeOfData = 1024;
    byte[] data = new byte[sizeOfData];
    int byteCount = 0;
    int nodeCounter = 1; // B
    while (byteRead != -1) {
      data[byteCount++] = (byte) byteRead;
      if (byteCount == sizeOfData) {
        //send data
        byteCount = 0;
        nodeCounter++;
      }
      byteRead = fis.read();
    }
    fis.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
  
    }
  }