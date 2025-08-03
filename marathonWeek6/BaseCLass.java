package marathonWeek6;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class BaseCLass {
	
	@DataProvider(name="fetchdata")
	public static String[][] data() throws IOException {
		String[][] passData = ReadExcelClass.passData();
		return passData;
	}
	
	public ChromeDriver driver;
	public ChromeOptions options;
	@Parameters({"url","username","password"})
	@BeforeMethod
public void perConditions(String url,String username,String password) throws InterruptedException {
	 options = new ChromeOptions();
     options.addArguments("--disable-notifications");
     driver = new ChromeDriver(options);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     driver.get(url);
     driver.findElement(By.id("username")).sendKeys(username);
     driver.findElement(By.id("password")).sendKeys(password);
     driver.findElement(By.id("Login")).click();
     driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
     driver.findElement(By.xpath("//button[text()='View All']")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
     Thread.sleep(3000);
     WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
     driver.executeScript("arguments[0].click()",accountsTab);
}
	@AfterMethod
	public void postCondition() {
		driver.close();
		}
}
