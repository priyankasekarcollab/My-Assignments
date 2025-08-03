package week6.TestNGHA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicParameter {
	
	@DataProvider(name="fetchdata")
	public String[][] passData() {
		String[][] data=new String[3][1];
		data[0][0]="Priyanka";
		data[1][0]="Vedaa";
		data[2][0]="Ishu";
		return data;
	}
	
	@Test(dataProvider ="fetchdata")
	public void Dyparameter(String name) throws InterruptedException {
		//STEP 1: Login to salesforce application
				ChromeOptions options=new ChromeOptions();
				options.addArguments("guest");
				ChromeDriver driver=new ChromeDriver(options);
				driver.get("https://login.salesforce.com");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
				driver.findElement(By.id("password")).sendKeys("Sales@123");
				driver.findElement(By.id("Login")).click();
				
				//STEP 2: Click on the toggle menu button from the left corner
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
				//STEP 3: Click View All and click Legal Entities from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				Thread.sleep(3000);
				WebElement element = driver.findElement(By.xpath("//p[text()='Legal Entities']/parent::span"));
				Actions act=new Actions(driver);
				act.scrollToElement(element).perform();
				Thread.sleep(3000);
				driver.executeScript("arguments[0].click()", element);
			
				
				//STEP 4: Click on the dropdown icon in the legal Entities tab
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@class='slds-context-bar__label-action slds-p-left_none'])[14]")).click();
				
				//STEP 5: Click on New Legal Entity
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//*[name()='svg' and @class=\"slds-icon slds-icon-text-default slds-icon_x-small\"])[1]")).click();
				
				//STEP 6: Enter the Name with dynamic parameters
				driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
				
				//STEP 7: Save the data
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				
				//STEP 8: Close the browser
				driver.close();
				
	}

}
