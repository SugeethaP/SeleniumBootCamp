package week1.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewEntity extends BaseClassSalesForce{
	
	@Test
	public  void CreateNewLegalEntity() throws InterruptedException {		
	
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		WebElement Toggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Toggle);	
		//Toggle.click();
		WebElement ViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		ViewAll.click();
		//scrolldown
		WebElement LegalEntity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		js.executeScript("arguments[0].scrollIntoView()", LegalEntity);
		js.executeScript("arguments[0].click()", LegalEntity);
		//
		
		
		if(driver.findElement(By.xpath("//a[@title='Recently Viewed']/following-sibling::button")).isEnabled())
		{
			Thread.sleep(1500);
			
			WebElement RecntlyViewed = driver.findElement(By.xpath("//a[@title='Recently Viewed']/following-sibling::button"));
			js.executeScript("arguments[0].click()", RecntlyViewed);
			 WebElement Dropdown = driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown"));
		       Dropdown.click();
		}
		else
		{
		 WebElement Dropdown = driver.findElement(By.xpath("//a[@title='Legal Entities']/following-sibling::one-app-nav-bar-item-dropdown"));
		       Dropdown.click();
		}
		
		WebElement NewLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		wait.until(ExpectedConditions.visibilityOf(NewLegalEntity));
		js.executeScript("arguments[0].click()", NewLegalEntity);
		
		//
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Sugeetha");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Verification point
		
		String VerificationText = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
		boolean FinalPopUp = VerificationText.contains("Salesforce Automation by Sugeetha");
		Assert.assertTrue(FinalPopUp);
	}

}
