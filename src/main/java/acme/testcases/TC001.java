package acme.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC001 {
	@Test
public void runTC001(){
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://acme-test.uipath.com/account/login");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
	driver.findElementById("password").sendKeys("leaf@12");
	driver.findElementById("buttonLogin").click();
	WebElement vendors = driver.findElementByXPath("(//div[@class='dropdown']//button)[5]");
	vendors.click();
	driver.findElementByXPath("//a[@href='/vendors/search']").click();
	driver.findElementById("vendorName").sendKeys("blue lagoon");
	driver.findElementById("buttonSearch").click();
	String country = driver.findElementByXPath("//table/tbody/tr[2]/td[5]").getText();
	System.out.println(country);
	driver.findElementByLinkText("Log Out").click();
	driver.close();
	
}
}
