
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class A {

  public static void main(String[] args) {
  
      
  Scanner sc = new Scanner(System.in);
  String filePath = sc.nextLine();
  try {
    BufferedReader reader = new BufferedReader(new FileReader(filePath), (8192/8));
    String line;
    while((line = reader.readLine()) != null) {
      System.out.println(line);
    }
    reader.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
  
    }
  }