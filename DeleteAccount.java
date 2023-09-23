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

public class DeleteAccount extends BaseClassSalesForce {
	
	@Test
	public  void DeleteAcc() {
		
		//TestCase--DeleteAccount
				WebElement Toggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", Toggle);	
				//
				WebElement ViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
				ViewAll.click();
				WebElement SalesTab = driver.findElement(By.xpath("//p[text()='Sales']"));
				js.executeScript("arguments[0].click()", SalesTab);
				//SalesTab.click();
				//
				WebElement AccountsTab = driver.findElement(By.xpath("//div[@class='slds-context-bar']//span[text()='Accounts']"));
				js.executeScript("arguments[0].click()", AccountsTab);
				//AccountsTab.click();				
				//
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
				WebElement SearchBox = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
				SearchBox.sendKeys("Sugeetha"+Keys.ENTER);
				
				//
				//Thread.sleep(1000);	
				WebElement NoItemDisplayed = driver.findElement(By.xpath("//span[text()='No items to display.']"));
				if(NoItemDisplayed.isDisplayed())
				{
					System.out.println("No items to display.");
					
				}
				else
				{		
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")));
				WebElement Dropdownicon = driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
				//Dropdownicon.click();
				driver.executeScript("arguments[0].click()", Dropdownicon);
				//
				WebElement DeleteOption = driver.findElement(By.xpath("//div[text()='Delete']"));
				js.executeScript("arguments[0].click()", DeleteOption);
				//DeleteOption.click();
				
				//
				WebElement popupDeleteButton = driver.findElement(By.xpath("//span[text()='Delete']"));
				popupDeleteButton.click();
				
				//verificationText
				
				WebElement Verification = driver.findElement(By.xpath("//div[@role='alertdialog']"));
				String expecResult = Verification.getText();
				System.out.println(expecResult);
				
				boolean ActualResult = expecResult.contains("Sugeetha");
				Assert.assertTrue(ActualResult);
				}
				
				
				
	}

}
