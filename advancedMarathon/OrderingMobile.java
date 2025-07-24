package advancedMarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		//Launching the ServiceNow application
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev209663.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login to the application
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("qy/Q6A=vOM3x");
		driver.findElement(By.id("sysverb_login")).click();
		
		//Shadow object to access element
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(20);
		
		//clicking ALL and searching for service catalog
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		Thread.sleep(1000);
		
		//selecting Mobile which is inside iframe and iframe is inside shadow root
		WebElement iframe=shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		
		//selecting the Iphone 13 pro
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		
		//selecting Yes in Lost or damage
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		
		//entering the phone number
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
		
		//selecting the monthly allowance
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select sel=new Select(dropdown);
		sel.selectByVisibleText("Unlimited [add $4.00]");
		
		//selecting the colour
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		
		//selecting the storage
		driver.findElement(By.xpath("//label[text()='512 GB [add $300.00]']")).click();
		
		//clicking on order now button
		driver.findElement(By.id("oi_order_now_button")).click();
		
		//verify whether the request is raised
		WebElement verify=driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']"));
		System.out.println(verify.getText());
		
		//Print the request ID
		WebElement req=driver.findElement(By.xpath("//a[@id='requesturl']/b"));
		String reqID=req.getText();
		System.out.println("The request ID is "+reqID);
		
		//close the browser
		driver.close();
	}

}
