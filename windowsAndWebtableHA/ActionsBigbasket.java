package week5.windowsAndWebtableHA;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsBigbasket {

	public static void main(String[] args) throws InterruptedException {
		//Launching the web application
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//clicking on category
		driver.findElement(By.xpath("(//div[@class='relative h-full']/button)[2]")).click();
		Thread.sleep(3000);
		
		//mouseHover Foodgrains,oil
		WebElement foodgrains=driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(foodgrains).perform();
		Thread.sleep(3000);
		
		//mouseHover rice and rice product
		WebElement rice=driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		//Actions act=new Actions(driver);
		act.moveToElement(rice).perform();
		
		//clicking on boiled rice
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		Thread.sleep(3000);
		
		//selecting BB royal
		driver.findElement(By.xpath("//input[@id='i-bbRoyal']")).click();
		Thread.sleep(3000);
		
		//selecting tamil ponni boiled rice
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']")).click();
		
		//handling windows
		Set<String> windows=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		
		//selecting 5KG bag
		driver.findElement(By.xpath("//span[text()='5 kg']")).click();
		
		//printing the price
		WebElement price=driver.findElement(By.xpath("//table/tr[2]/td[1]"));
		String price1=price.getText();
		System.out.println("The price of the rice bag is "+price1);
		
		//adding to cart
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		
		//vertification
		WebElement verify=driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']"));
		if (verify.isDisplayed()) {
			System.out.println("The product has successfully added to the cart");
		} else {
			System.out.println("The product is not added to cart. please check again");
		}
		
		//close the browser windows
		driver.close();
		driver.switchTo().window(win.get(0));
		driver.close();
	}

}
