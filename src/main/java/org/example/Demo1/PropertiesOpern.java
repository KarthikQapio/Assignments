package org.example.Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOpern {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Qapitol QA\\eclipse-workspace\\Demo1\\Repository\\config.properties");
		Properties property = new Properties();
		
		property.load(new FileInputStream("C:\\Users\\Qapitol QA\\eclipse-workspace\\Demo1\\Repository\\config.properties"));
		
	
		String data = property.getProperty("company");
		System.out.println(data);
		
		property.setProperty("username", "ak");
		property.setProperty("pass", "pass");
		property.store(fos, null);
		property.clear();
		property.setProperty("data", "temp");
		property.store(new FileOutputStream("C:\\Users\\Qapitol QA\\eclipse-workspace\\Demo1\\Repository\\config.properties"), null);


		
	}

}
