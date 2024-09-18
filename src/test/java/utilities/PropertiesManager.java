package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

	public static Properties configProp() throws IOException
	{
		//To get the file location in reading mode
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		
		// To load this file object into Properties object
		Properties prop=new Properties();
		prop.load(file);
		
		return prop;
	}
	
	
}
