package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AccountDD {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Accounts")).click();
		driver.findElement(By.partialLinkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("PriyankaSekar");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		WebElement industry=driver.findElement(By.name("industryEnumId"));
		Select sel= new Select(industry);
		sel.selectByIndex(3);
		WebElement ownership=driver.findElement(By.name("ownershipEnumId"));
		Select sel1 = new Select(ownership);
		sel1.selectByVisibleText("S-Corporation");
		WebElement source=driver.findElement(By.id("dataSourceId"));
		Select sel2 = new Select(source);
		sel2.selectByValue("LEAD_EMPLOYEE");
		WebElement marketing =driver.findElement(By.id("marketingCampaignId"));
		Select sel3 = new Select(marketing);
		sel3.selectByIndex(6);
		WebElement state= driver.findElement(By.id("generalStateProvinceGeoId"));
		Select sel4 = new Select(state);
		sel4.selectByValue("TX");
		driver.findElement(By.className("smallSubmit")).click();
		String expectedname ="PriyankaSekar";
		System.out.println(driver.getTitle());
		WebElement element =driver.findElement(By.xpath("//span[contains(text(),'PriyankaSekar')]"));
		String actualname =element.getText();
		if (actualname.contains(expectedname)) {
			System.out.println("The account name is displayed correctly");
			
		} else {
			System.out.println("The account name is not displayed correctly");

		}
		driver.close();
	}

}
