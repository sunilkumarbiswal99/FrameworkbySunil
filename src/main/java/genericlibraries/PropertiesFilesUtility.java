package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all reusable methods to perform operations on properties file
 * @author srout
 *
 */

public class PropertiesFilesUtility {
	 private Properties property;
	 
	 /**
	  * This method is used to initialize properties file
	  * @param filepath
	  */
   public void propertyFileInitialization(String filepath)
   {
	   FileInputStream fis=null;
	   try
	   {
		   fis=new FileInputStream(filepath);
	   }
	   catch(FileNotFoundException e)
	   {
		   e.printStackTrace();
	   }
	   
	    property=new Properties();
	   
	   try
	   {
		   property.load(fis);
	   }
	   catch(IOException e)
	   {
		   e.printStackTrace();
	   }
   }
   /**
    * This  method returns data from properties file  baseed
    * @param key
    * return
    */
   public String fetchproperty(String key)
   {
	return property.getProperty(key);
	   
   }
}
