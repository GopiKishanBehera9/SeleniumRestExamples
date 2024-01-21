package TestDataReadFromProportiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	Properties properties;
	String path = "C:\\Users\\beher\\eclipse-Selenium\\SeleniumTest\\src\test\\java\\TestDataReadFromProportiesFile\\Config.properties";

	public ReadConfigFile() {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		String url = properties.getProperty("url");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url not specified in config file.");
	}
	
	public String getUserName() {
		String userName = properties.getProperty("user-name");
		if(userName!=null)
			return userName;
		else
			throw new RuntimeException("UserName not specified in config file.");
	}
	
	
	public String getPassword() {
		String getPassword = properties.getProperty("password");
		if(getPassword!=null)
			return getPassword;
		else
			throw new RuntimeException("Password not specified in config file.");
	}




}
