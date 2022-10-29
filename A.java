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
            return;
          }
          
        } catch (IOException e) {
          e.printStackTrace();
        }
        //fis.close();
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
}

static void sendArray (byte[] data, int nodeCounter) {
  try {
      Socket s = new Socket("localhost", (1002 + nodeCounter % 1));
      System.out.print("socket Changed to port: " + (1002 + nodeCounter % 1) + "\n");
      BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
      for (byte arr: data) {
        if (arr == -1) {
          break;
        }
        bos.write(arr);
        bos.flush();
      }
      nodeCounter++;
      System.out.println("test");
  } catch (IOException e) {
      e.printStackTrace();
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


  // try {
  //   Socket s = new Socket("localhost", 1002 + (nodeCounter % 5)); // connect to the nodes
  //   System.out.println("Connection Established");
  //   BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the nodes
  //   bos.write(data); // write the data to the output stream
  //   bos.flush(); // flush the output stream
  // } catch (IOException e) {
  //   e.printStackTrace();
  // }

        // while (byteRead != -1 && byteCount < sizeOfData) {
        //   data[byteCount++] = (byte) byteRead; // store the byte in the array
        //   byteRead = fis.read(); // read the next byte
        // }

        // while (byteRead != -1) { // while the end of the file is not reached

        //   data[byteCount++] = (byte) byteRead; // store the byte in the byte array
          
        //   if (byteCount == sizeOfData) { // if the byte array is full (1KB reached)
        //     // send the data to the node
        //     Socket s = new Socket("localhost", 1002 + (nodeCounter++ % 5)); // connect to the nodes
        //     System.out.println("Connection Established");
        //     BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the nodes
        //     bos.write(data); // write the data to the output stream
        //     byteCount = 0; // reset the byte count
        //     data = new byte[sizeOfData]; // create a new byte array
        //     bos.flush(); // flush the output stream
        //   }
        //   if (byteRead == -1) { // if the end of the file is reached send the remaining data to the nodes
        //     Socket s = new Socket("localhost", 1002 + (nodeCounter++ % 6)); // connect to the nodes
        //     BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the nodes
        //     bos.write(data);
        //     // write the data to the output stream
        //     byteCount = 0; // reset the byte count
        //     bos.flush(); // flush the output stream
        //   }
        //   byteRead = fis.read(); // read the next byte
        // }

        /*
                     while (byteRead != -1) {
                Socket s = new Socket("localhost", (2001 + counter % 3));
                System.out.print("socket Changed to port: " + (2001 + counter % 5) + "\n");
                DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
                for (int i = 0; i <= 1024; i++) {
                    System.out.println(i + "this is :" + byteRead);
                    dOut.write(byteRead);
                    byteRead = bufferedInputStream.read();
                    dOut.flush();
                }
                counter++;
                System.out.println("test");
            }
         */

/*
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

          //data[byteCount++] = (byte) byteRead; // store the byte in the byte array

          Socket s = new Socket("localhost", 1002 + (nodeCounter % 5)); // connect to the nodes

          System.out.println("Connection Established");
          BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the nodes
          for (int i = 0; i < 1024; i++) {
            bos.write(byteRead); // write the data to the output stream
            byteRead = fis.read();
            bos.flush(); // flush the output stream
            bos.close();
          }

          nodeCounter++; // increment the node counter
          /* 
            try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            System.out.println(" path confirmed ");
            int byteRead = -1;
            byteRead = bufferedInputStream.read();

            while (byteRead != -1) {
                Socket s = new Socket("localhost", (2001 + counter % 5));
                System.out.print("socket Changed to port: " + (2001 + counter % 5) + "\n");
                DataOutputStream dOut = new DataOutputStream(s.getOutputStream());
                for (int i = 0; i <= 1024; i++) {
                    System.out.print(i + "this is :" + byteRead);
                    dOut.write(byteRead);
                    byteRead = bufferedInputStream.read();
                    dOut.flush();
                }
                counter++;
                System.out.println("test");
            }
           */
          
          // byteRead = fis.read(); // read the next byte
          // if (byteRead == -1) { // if the end of the file is reached send the remaining data to the nodes
          //   Socket s = new Socket("localhost", 1002 + (nodeCounter++ % 6)); // connect to the nodes
          //   BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream()); // get the output stream of the nodes
          //   bos.write(data);
          //   // write the data to the output stream
          //   byteCount = 0; // reset the byte count
          //   data = new byte[sizeOfData]; // create a new byte array
          //   bos.flush(); // flush the output stream
          //   bos.close();
          //}
        }
        /* 
        
          while (true) {
                try {
                    Socket s = ss.accept();
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    System.out.print("checkpoint 1");

                    for (int i = 1; i <= 1024; i++) {
                        data = dis.read();
                        if (data == 255) {
                            break;
                        }
                        bytes.add(data);
                        System.out.print("checkpoint 1");

                    }
                    System.out.println(bytes);
                    System.out.println(dis.readUTF());
         
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
*/