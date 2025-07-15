package week4.collectionHA;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		//Launching Ajio Web app
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Searching the product
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='Search Ajio']")).sendKeys("bags",Keys.ENTER);
		
		//selecting mens option under gender
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']")).click();
		
		//selecting fashion bags
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags']")).click();
		
		//Find the total count
		Thread.sleep(1000);
		WebElement count =driver.findElement(By.xpath("//div[@class='length']/strong"));
		System.out.println(count.getText());
		
		//finding the list of brands
		List<WebElement> list1 =driver.findElements(By.xpath("//div[@class='brand']/strong"));
		
		//printing the brands
		List<String> brands= new ArrayList<String>();
		
		for (WebElement each : list1) {
			String name=each.getText();
			brands.add(name);
		}
		System.out.println(brands);
		
		//finding the list of bagnames
		List<WebElement> list2=driver.findElements(By.xpath("//div[@class='nameCls']"));
		
		//printing the bagnames
		List<String> bagnames=new ArrayList<String>();
		
		for (WebElement each : list2) {
			String name=each.getText();
			bagnames.add(name);
		}
		System.out.println(bagnames);
		
		//close browser
		driver.close();
		
	}

}
