package week5.windowsAndWebtableHA;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSnapdeal {

	public static void main(String[] args) throws InterruptedException {
		//STEP 1: Launch the web application
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//STEP 2: mouseHover the men's fashion
		Actions act=new Actions(driver);
		WebElement menFashion=driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		act.moveToElement(menFashion).perform();
		Thread.sleep(2000);
		
		//STEP 3: clicking on sports shoe
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		//STEP 4: finding the total count
		WebElement count=driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String count1=count.getText();
		String totalcount=count1.replaceAll("^[0-9]","");
		System.out.println("The total count is "+totalcount);
		
		//STEP 5: clicking on training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//STEP 6: sorting the results
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='search-li'][1]")).click();
		
		//STEP 7: Validating if the sort is done
			//1)get all prices
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		Thread.sleep(3000);
		List<String> string=new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			
			//2)using try catch block due to stale element reference exception
			try {
				WebElement each=driver.findElements(By.xpath("//span[@class='lfloat product-price']")).get(i);
				String text = each.getText();
				string.add(text);
				
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			
		}
		System.out.println("The list of price are "+string);
		
			//3) extract numbers from the string and convert it to integer
		List<Integer> numbers= new ArrayList<Integer>();
		for (int i = 0; i < string.size(); i++) {
			
		
		String replaceAll1 = string.get(i).replaceAll("[^0-9]", "");
		int num=Integer.parseInt(replaceAll1);
		numbers.add(num);
		}
		
			//4) compare the first and second values
		int a=0;
		
		for (int i = 0; i < numbers.size()-1; i++) {
			int num1=numbers.get(i);
			int num2=numbers.get(i+1);
			if (num1<=num2) {
				a++;
			}
		}
		if (a==numbers.size()-1) {
			System.out.println("The Sorting is done successfully");
		} else {
			System.out.println("The sorting is not done. Please check again");
		}
		
		//STEP 8: Select any price range(500-700)
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("500");
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("700");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		//STEP 9:Select the colour filter
		Thread.sleep(2000);
		act.scrollToElement(driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']"))).perform();
		driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']")).click();
		
		//STEP 10:Verify whether the filters are applied
		Thread.sleep(3000);
		try {
			WebElement price = driver.findElement(By.xpath("//a[text()='Rs. 500 - Rs. 700']"));
			if (price.isDisplayed()) {
				System.out.println("The Price range filter is applied");
			} else {
				System.out.println("The Price range filter is not applied. Please check again");
			}
			
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}
		
		WebElement colour = driver.findElement(By.xpath("//a[text()='White & Blue']"));
		if (colour.isDisplayed()) {
			System.out.println("The Colour filter is applied");
		} else {
			System.out.println("The colour filter is not applied. Please check again");
		}
		
		//STEP 11: MouseHover the first result
		WebElement result = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		act.moveToElement(result).perform();
		
		//STEP 12: Click quick view button
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		
		//STEP 13: Print the cost and discount
		WebElement costprint = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String costprint1 = costprint.getText();
		System.out.println("The cost of the shoe is "+costprint1.replaceAll("[^0-9]", ""));
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println("The Discount for this product is "+discount.getText());
		
		//STEP 14: closing current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		
		//STEP 15: closing the main window
		driver.close();
	}

}
