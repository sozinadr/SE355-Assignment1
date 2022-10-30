import java.io.*;
import java.net.*;
import java.util.Scanner;

public class A {
  static int checker;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the file name");
    String fileName = sc.nextLine();
    int nodeCounter = 0; // to keep track of the node number
    int retrieveNodeCounter = 0; // to keep track of the node number
    int backupNodeCounter = 1; // to keep track of the node number

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

          /*
           * backup code
           */

          // System.out.println("Do you want to send backup to another node? (yes/no)");
          // String choice2 = sc.nextLine();
          // if (choice2.equals("yes")) {
          //   sendBackup(data, backupNodeCounter++);
          // } else if (choice2.equals("no")) {
          //   System.out.println("Backup not sent");
          // } else {
          //   System.out.println("Invalid input");
          // }

          if (byteRead == -1) { // if the end of the file is reached
            fis.close(); // close the file input stream
            ss.close(); // close the server socket
            break;
          }

        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Do you want to retrieve the data back? (yes/no)");
      String choice = sc.nextLine();
      while (true) {
        if (choice.equals("yes")) {
          int check = retrieveData(retrieveNodeCounter);
          if (check == -1) {
            break;
          }
        } else if (choice.equals("no")) {
          break;
        } else {
          System.out.println("Invalid choice");
        }
      }

    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

  static void sendArray(byte[] data, int nodeCounter) {
    try {
      // System.out.println("did connect or no??");
      Socket s = new Socket("localhost", (1002 + nodeCounter % 1));
      System.out.print("socket Changed to port: " + (1002 + nodeCounter % 1) + "\n");
      // BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
      // for (byte arr : data) {
      //   if (arr == 0) {
      //     bos.write(-1);
      //     bos.flush();
      //     break;
      //   }
      //   bos.write(arr);
      //   bos.flush();
      // }
      // bos.close();
      // s.close();
      Thread sendThread = new sendData(s, data);
      sendThread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static int retrieveData(int nodeCounter) {
    // int byteRead2 = 0;
    try {
      if (checker == -1) {
        System.out.println("mamossa gyan");
        return -1;
      }
      Socket s = new Socket("localhost", (2002 + nodeCounter % 1));
      System.out.print("socket Changed to port: " + (2002 + nodeCounter % 1) + "\n");
      Thread retrieveThread = new retrieveData(s);
      retrieveThread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  static void sendBackup(byte[] data, int nodeCounter) {
    try {
      Socket s = new Socket("localhost", (3002 + nodeCounter % 1)); // send data to backup node
      System.out.print("socket Changed to port: " + (3002 + nodeCounter % 1) + "\n");

      Thread sendBackupThread = new sendBackupData(s, data);
      sendBackupThread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


class sendData extends Thread { // class to send data to the node
  Socket s;
  byte[] data;

  sendData(Socket s, byte[] data) {
    this.s = s;
    this.data = data;
  }

  @Override
  public void run() {
    try {
      BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
      DataOutputStream dos = new DataOutputStream(s.getOutputStream());
      for (byte arr : data) {
        if (arr == 0) {
          bos.write(-1);
          bos.flush();
          break;
        }
        bos.write(arr);
        bos.flush();
      }
      dos.writeUTF("stop"); // to indicate the end of the data
      bos.close();
      s.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class retrieveData extends Thread { // class to retrieve 
  Socket s;

  retrieveData(Socket s) {
    this.s = s;
  }

  public void run() {
    int byteRead2 = 0;
    try {
      DataOutputStream dos = new DataOutputStream(s.getOutputStream());
      dos.writeUTF("retrieve"); // send the retrieve command to the node
      BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
      FileOutputStream fos = new FileOutputStream("A.cpp", true);
      for (int i = 0; i < 1024; i++) {
        byteRead2 = bis.read();
        if (byteRead2 == 255 || byteRead2 == -1) {
          break;
        }
        fos.write(byteRead2);
        fos.flush();
      }
      if (byteRead2 == 255 || byteRead2 == -1) {
        fos.close();
        s.close();
        A.checker = -1;
        return;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class sendBackupData extends Thread { // class to send backup to the node
  Socket s;
  byte[] data;

  sendBackupData(Socket s, byte[] data) {
    this.s = s;
    this.data = data;
  }

  @Override
  public void run() {
    try {
      BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
      for (byte arr : data) {
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
}