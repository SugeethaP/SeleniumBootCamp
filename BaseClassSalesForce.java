package week1.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClassSalesForce {
	public static ChromeDriver driver;
	
	@Parameters({"url","Username","Password"})
	@BeforeMethod
	public  void preCondition(String url,String Username,String Password) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--disable-notifications");
				driver=new ChromeDriver(opt);
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement UserName = driver.findElement(By.id("username"));
				UserName.sendKeys(Username);
				WebElement Passwrd = driver.findElement(By.id("password"));
				Passwrd.sendKeys(Password);
				WebElement Login = driver.findElement(By.id("Login"));
				Login.click();
	}
	@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
