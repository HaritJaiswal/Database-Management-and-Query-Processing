import java.util.*;
import java.io.*;

class 
public class iter
{
	public static void main(String[] args) {
		FileReader fr = 
      new FileReader("./test.txt"); 
  
    int i; 
    while ((i=fr.read()) != -1) 
      System.out.print((char) i); 
	}
	
}