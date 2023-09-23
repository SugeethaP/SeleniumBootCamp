package week1.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditLegalEntity extends BaseClassSalesForce{

	@Test
	public void runEditLegalEnity() throws InterruptedException {
		// TODO Auto-generated method stub
		//Test Case
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
				driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']")).sendKeys("Salesforce Automation by Sugeetha"+Keys.ENTER);
				Thread.sleep(1000);
				WebElement dropDown= driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));		
				js.executeScript("arguments[0].click()", dropDown);
				
		//
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Edit']")));
				WebElement EditOption = driver.findElement(By.xpath("//div[text()='Edit']"));
				js.executeScript("arguments[0].click()", EditOption);
				
				//Enter Company Name as TestLeaf
				
				WebElement companyName = driver.findElement(By.xpath("//input[@name='CompanyName']"));
				companyName.sendKeys("TestLeaf");
				
				//
				WebElement Description = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
				Description.sendKeys("SalesForce");
				
				//
				WebElement Status = driver.findElement(By.xpath("//button[@role='combobox']"));
				js.executeScript("arguments[0].scrollIntoView()", Status);
				js.executeScript("arguments[0].click()", Status);
				
				//
				driver.findElement(By.xpath("//span[text()='Active']")).click();
				
				//click on Save Button
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				
				//
				String VerificationText = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
				boolean FinalPopUp = VerificationText.contains("Salesforce Automation by Sugeetha");
				System.out.println(FinalPopUp);
				Assert.assertTrue(FinalPopUp);
	}

}
