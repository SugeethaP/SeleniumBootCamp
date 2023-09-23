package week1.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAccountName extends BaseClassSalesForce{

	@Test
	public  void VerifyAccount( ) throws InterruptedException {
		// TODO Auto-generated method stub
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
		
		WebElement AccountsTab = driver.findElement(By.xpath("//div[@class='slds-context-bar']//span[text()='Accounts']"));
		js.executeScript("arguments[0].click()", AccountsTab);
		
		//
		List<WebElement> accountName = driver.findElements(By.xpath("//table//tbody/tr/th//a"));
		List<String> name = new ArrayList<String>();
		for (int i = 0; i < accountName.size(); i++) {	
			String accNameArray = accountName.get(i).getText();	
		    name.add(accNameArray);
										   }
		Collections.sort(name);
		System.out.println(name);
		WebElement sortArrow = driver.findElement(By.xpath("//span[@title='Account Name']"));
		
		driver.executeScript("arguments[0].click();",sortArrow );
		Thread.sleep(1000);
		List<WebElement> afterSortListAccountName = driver.findElements(By.xpath("//table//tbody/tr/th//a"));
		List<String> afterSortlisted = new ArrayList<String>();
		System.out.println("After Sorlisted:");
		for (int i = 0; i < afterSortListAccountName.size(); i++) {
			String  afterSortActualResult= afterSortListAccountName.get(i).getText();
			afterSortlisted.add(afterSortActualResult);
					
		}
		System.out.println(afterSortlisted);
		
		Assert.assertEquals(afterSortlisted, name);
		System.out.println("TestCase is Passed");
		
	}

}
