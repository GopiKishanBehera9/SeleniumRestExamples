package Selenium.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGReportEx2 {

	@Test
	public void googleSearch() {
		//Launch chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Reporter.log("Chrome Browser Opened...");
		
		//Open URL
		driver.get("http://www.google.com");
		Reporter.log("Google url opened...");
		
		//Find searchbox web element
		WebElement searchbox = driver.findElement(By.name("q"));
		
		//enter keyword "India gate"
		searchbox.sendKeys("india gate");
		Reporter.log("India gate keyword entered...");
		
		//press enter key
		searchbox.sendKeys(Keys.ENTER);
		Reporter.log("Enter Key Pressed...");
		
		Reporter.log("Closing browser...");
		driver.quit();
	}
}
