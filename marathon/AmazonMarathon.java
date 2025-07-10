package week3.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonMarathon {

	public static void main(String[] args) throws InterruptedException {
		
		//launching ChromeBrowser
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//added implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//clicking on continue shopping button
		Thread.sleep(3000);
		driver.findElement(By.className("a-button-text")).click();
		
		//search for bags
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys",Keys.ENTER);
		
		//Print the total results
		Thread.sleep(3000);	
		WebElement print=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none s-breadcrumb-header-text']"));
		System.out.println(print.getText());
		
		//selecting the brands
		driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[4]")).click();
		
		//sorting with newest arrival
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		//Printing the first result details
		WebElement name=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']"));
		System.out.println("The name of the Bag is "+name.getText());
		WebElement price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]"));
		System.out.println("The price of the Bag is "+price.getText());
		
		//Page title
		System.out.println(driver.getTitle());
		
		//close window
		driver.close();
	}

}
