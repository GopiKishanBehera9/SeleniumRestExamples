package Selenium.SeleniumTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgRepo {
	@Test
	public void testMethod1() {
		System.out.println("This is test method1...");
		Reporter.log("This is test method1...");
	}
	@Test
	public void testMethod2() {
		System.out.println("This is test method2...");
		Reporter.log("This is test method2...");
	}
	
	@Test
	public void testMethod3() {
		System.out.println("This is test method3...");
		Reporter.log("This is test method3...");
	}
	@Test
	public void testMethod4() {
		System.out.println("This is test method4...");
		Reporter.log("This is test method4...");
	}

}
