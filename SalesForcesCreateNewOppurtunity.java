package week1.Day1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesForcesCreateNewOppurtunity extends BaseClassSalesForce {
	
	@Test
	public  void CreateNewOppurtunity() throws InterruptedException {		
		//TestCase
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		WebElement Toggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Toggle);	
		//Toggle.click();
		WebElement ViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		ViewAll.click();
		WebElement SalesTab = driver.findElement(By.xpath("//p[text()='Sales']"));
		SalesTab.click();
		WebElement OppurtunityTab = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", OppurtunityTab);		
		WebElement NewButton = driver.findElement(By.xpath("//div[text()='New']"));
		NewButton.click();
		WebElement OppurtunityName = driver.findElement(By.xpath("//input[@name='Name']"));
		OppurtunityName.sendKeys("SalesForceAutomation By Sugeetha");
		//String GivenOppurtunityName = OppurtunityName.getText();
		//System.out.println(GivenOppurtunityName);
		//
		WebElement CloseDate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		DateFormat date_format_obj = new SimpleDateFormat("d/M/yyyy");
        Date date_obj = new Date();
        CloseDate.sendKeys(date_format_obj.format(date_obj)+ Keys.ENTER);
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@id,'combobox-button')]")));
        WebElement Stage = driver.findElement(By.xpath("//button[contains(@id,'combobox-button')]"));	
        //Stage.click();
        js.executeScript("arguments[0].click();", Stage);
        Thread.sleep(1000);
       WebElement NeedAnalysis = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
       js.executeScript("arguments[0].click();", NeedAnalysis);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
       System.out.println( date_format_obj.format(date_obj)); 
       //Verification Part
       WebElement FinalPopUp = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span"));
       String VerificationText = FinalPopUp.getText();
       System.out.println(VerificationText);
       boolean actualResult = VerificationText.contains("SalesForceAutomation By Sugeetha");
       Assert.assertTrue(actualResult);
      
	}

}
