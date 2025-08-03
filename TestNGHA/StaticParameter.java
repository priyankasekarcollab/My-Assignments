package week6.TestNGHA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StaticParameter {
	@Parameters({"url","username","password"})
	@Test
	public void staticParameter(String url, String username, String password) throws InterruptedException {
		//STEP 1: Login to salesforce application
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
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
		
		//STEP 6: Enter the Company name as 'TestLeaf'.
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		
		//STEP 7: Enter Description as 'Salesforces'.
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		
		//STEP 8: Select Status as 'Active'
		WebElement element3 = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		driver.executeScript("arguments[0].click()", element3);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Active']")).click();
		
		//STEP 9: Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//STEP 10: Verify the Alert message (Complete this field) displayed for Name 
		WebElement element2 = driver.findElement(By.xpath("//div[@data-name='Name']"));
		if (element2.isDisplayed()) {
			System.out.println("The Alert message is displayed");
		} else {
			System.out.println("The Alert message is not displayed. Please check again");
		}


	}

}
