package TestDataReadFromProportiesFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		ReadConfigFile ConfigFile = new ReadConfigFile();
		
		//URL
		driver.get(ConfigFile.getURL());
		//driver.get("https://www.saucedemo.com/");
		
		//UserName
		driver.findElement(By.id("user-name")).sendKeys(ConfigFile.getUserName());
		
		//Password
		driver.findElement(By.id("password")).sendKeys(ConfigFile.getPassword());
		
		//BTN
		driver.findElement(By.id("login-button")).click();
	}

}
