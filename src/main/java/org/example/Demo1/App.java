package org.example.Demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String fileName = "Temp.txt";
    	File file = new File("C:\\Users\\Qapitol QA\\eclipse-workspace\\Demo1\\Repository\\"+fileName);
    	if(!file.exists()) {
        	file.createNewFile();
    	}
    	
   // 	FileOutputStream fos = new FileOutputStream(file);
    	
    	BufferedWriter brw = new BufferedWriter(new FileWriter(file, true));
//    	BufferedReader brr = new BufferedReader(new FileReader(file));
//    	
    	brw.write("This is demo project");
    	brw.newLine();
    	brw.write("This is appended data");
    	System.out.println("File Writting sucessfully");
    	
    	brw.close();

//    	String data = brr.readLine();
    	
//    	String data = null;
//    	
//    	while((data = brr.readLine())!=null) {
//    		System.out.println(data);
//    	}
//    	
//    	brr.close();
//    	System.out.println(data);
    	
    	
    	
  }
    
}
    	
    	
    	
    	
    	
    	
    	