package Get_ImageSource_URL;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageSourceURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//launch chrome browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		//Open url
		driver.get("https://www.facebook.com/");
		
		//maximise windo
		driver.manage().window().maximize();
		
		//find webelement facebook logo
		WebElement imageLogo = driver.findElement(By.xpath("//umg[@class='fb_logo _8ilh img']"));
		
		//capture "src" attribute value of image Logo
		System.out.println("Src attribute value: " + imageLogo.getAttribute("src"));
		
		driver.quit();
	}

}
