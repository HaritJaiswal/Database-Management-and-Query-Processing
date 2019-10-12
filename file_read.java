
import java.io.*;


public class file_read
{
	public static void main(String[] args) {
		FileReader fr = 
      new FileReader("‎⁨~/Desktop/JAVA⁩/test.txt"); 
  
    int i; 
    while ((i=fr.read()) != -1) 
      System.out.print((char) i); 
	}
	
}