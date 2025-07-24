package advancedMarathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TatacliqMarathon {

	public static void main(String[] args) throws InterruptedException {
		//Launching the Web Application
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Clicking no for subscription
		driver.findElement(By.id("moe-dontallow_button")).click();
		Thread.sleep(1000);
		
		//MouseHover brands
		WebElement brands=driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(brands).perform();
		Thread.sleep(3000);
		
		//MouseHover Watches and accessories
		WebElement watch=driver.findElement(By.xpath("//div[@class='DesktopHeader__brandLeftDetails']/div[5]"));
		act.moveToElement(watch).perform();
		Thread.sleep(3000);
		
		//clicking on first item under featured brands
		driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]")).click();
		
		//sortby option
		WebElement sortby=driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select sel = new Select(sortby);
		sel.selectByVisibleText("New Arrivals");
		Thread.sleep(3000);
		
		//choose men from categories
		driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();
		Thread.sleep(1000);
		
		//printing the price of all the results
		List<WebElement> price=driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		List<String> rate=new ArrayList<String>();
		for (WebElement each : price) {
			String name=each.getText();
			rate.add(name);
		}
		System.out.println(rate);
		String rate1=rate.get(0);
		
		Thread.sleep(1000);
		
		//selecting the first item from the result
		driver.findElement(By.xpath("(//a[@class='ProductModule__base'])[1]")).click();
		
		//handling windows
		Set<String> windows=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		WebElement watchrate=driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']"));
		String watchrate1=watchrate.getText();
		
		
		//comparing two price are similar
		String replace1=rate1.replaceAll("[^0-9]", "");
		
		String replace2=watchrate1.replaceAll("[^0-9]", "");
		
		if (replace1.equals(replace2)) {
			System.out.println("Both the values are same");
		} else {
			System.out.println("Both values are not same");
		}
		Thread.sleep(3000);
		
		//adding to cart
		driver.findElement(By.xpath("(//div[@class='ProductDescriptionPage__buttonAddToBag '])[2]")).click();
		
		//Print the no of items in the cart
		WebElement cart=driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		String cartnum=cart.getText();
		System.out.println("The number of item in the cart is "+cartnum);
		Thread.sleep(1000);
		
		//Clicking on cart icon
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		Thread.sleep(1000);
		
		//closing the windows
		driver.close();
		
		driver.switchTo().window(win.get(0));
		driver.close();
	}

}
