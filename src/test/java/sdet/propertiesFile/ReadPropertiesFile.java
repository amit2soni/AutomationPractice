package sdet.propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        FileInputStream fis = new FileInputStream("C:\\Users\\95549\\Downloads\\config.properties");

	    Properties config = new Properties();
	    config.load(fis);
	    
	    System.out.println(config.getProperty("url"));
	    System.out.println(config.getProperty("name"));
	    System.out.println(config.getProperty("orderid"));
	    System.out.println(config.getProperty("password"));
	    System.out.println(config.getProperty("address"));
	    
	    System.out.println(config.keySet());
	    System.out.println(config.values());
	}

}
