package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CreateLead {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Selenium");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priyanka");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sekar");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Lead Creation");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
