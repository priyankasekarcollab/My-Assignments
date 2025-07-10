package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutomating {

	public static void main(String[] args) throws InterruptedException {
		//launching the browser
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//clicking on continue shopping
		Thread.sleep(3000);
		driver.findElement(By.className("a-button-text")).click();
		
		//searching for product
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("T-Shirt",Keys.ENTER);
		
		//selecting the product
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='puis-card-container s-card-container s-overflow-hidden aok-relative puis-expand-height puis-include-content-margin puis puis-v1pfvhdyb17azh26l1nclajlx70 s-latency-cf-section puis-card-border'])[1]")).click();
		
		//adding the product to cart
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//verifying whether the product is added to cart
		Thread.sleep(3000);
		WebElement verify=driver.findElement(By.xpath("//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
		if (verify.isDisplayed()) {
			System.out.println("The product is successfully added to the cart");
		} else {
			System.out.println("The product is not added. Check again");
		}
		
		//close the browser
		Thread.sleep(3000);
		driver.close();

	}

}
