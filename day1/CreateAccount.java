package week2.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateAccount {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Accounts")).click();
		driver.findElement(By.partialLinkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("Selenium");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("100");
		driver.findElement(By.id("officeSiteName")).sendKeys("Leaftaps");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
