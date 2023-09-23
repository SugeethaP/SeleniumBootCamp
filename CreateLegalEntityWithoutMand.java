package week1.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateLegalEntityWithoutMand extends BaseClassSalesForce{
	
	@Test
	public  void crtlegalEntityWoMnd() throws InterruptedException {
		
		// TODO Auto-generated method stub
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
			WebElement RecentlyViewed = driver.findElement(By.xpath("//a[@title='Recently Viewed']/following-sibling::button"));
			js.executeScript("arguments[0].click()", RecentlyViewed);
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
		WebElement companyName = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		companyName.sendKeys("TestLeaf");
		
		//
		WebElement description  = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		description.sendKeys("SalesForce");
		//
		WebElement status = driver.findElement(By.xpath("//button[@role='combobox']"));
		js.executeScript("arguments[0].scrollIntoView()", status);
		js.executeScript("arguments[0].click()", status);
		
		//
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		boolean displayed = driver.findElement(By.xpath("//div[@class='slds-form-element__help slds-m-left_none']")).isDisplayed();
		System.out.println(displayed);
		Assert.assertTrue(displayed);
	}

}
