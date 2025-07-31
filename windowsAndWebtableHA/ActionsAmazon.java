package week5.windowsAndWebtableHA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsAmazon {

	public static void main(String[] args) {
		//Launching Amazon web application
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//search for the product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//Get the first product price
		WebElement product1=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String prod1=product1.getText();
		
		//Print the no of the customer reviews for the first product
		WebElement review1=driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		String rev1=review1.getText();
		System.out.println("The number of customer review for first product is "+rev1);
		
		//clicking on the first product
		driver.findElement(By.xpath("(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]")).click();
		
		//adding to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Get the sub total from cart
		WebElement subtotal=driver.findElement(By.xpath("(//span[@class='a-price sw-subtotal-amount']/span/span)[2]"));
		String total=subtotal.getText();
		
		//verify
		if (prod1.equals(total)) {
			System.out.println("Both the values are same");
		} else {
			System.out.println("Both values are not same");
		}
		
		//close browser
		driver.close();;

	}

}
