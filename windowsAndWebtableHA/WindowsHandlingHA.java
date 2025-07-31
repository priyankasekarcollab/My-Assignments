package week5.windowsAndWebtableHA;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandlingHA {

	public static void main(String[] args) throws InterruptedException {
		//Launching the web Application
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Login with username and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//clicking on contacts button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//clicking on Merge contacts button
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//selecting from contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		Thread.sleep(1000);
		
		Set<String> windows1=driver.getWindowHandles(); //handling windows
		List<String> win1=new ArrayList<String>(windows1);
		
		driver.switchTo().window(win1.get(1)); //switching driver control to child window
		driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
		
		driver.switchTo().window(win1.get(0)); //switching back the driver control to parent window
		
		//selecting To contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Thread.sleep(1000);
		
		Set<String> windows2=driver.getWindowHandles();  //handling windows
		List<String> win2=new ArrayList<String>(windows2);
		
		driver.switchTo().window(win2.get(1));  //switching driver control to child window
		driver.findElement(By.xpath("//a[text()='DemoPrivilegedCust']")).click();
		
		driver.switchTo().window(win2.get(0));  //switching back the driver control to parent window
		
		//click on merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(3000);
		
		//accepting alert
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//Verify the title of the page
		System.out.println(driver.getTitle());
		
		//close the webpage
		driver.close();
	}

}
