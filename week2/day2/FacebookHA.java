package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FacebookHA {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Priyanka");
		driver.findElement(By.name("lastname")).sendKeys("Sekar");
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		driver.findElement(By.id("password_step_input")).sendKeys("priyankasekar98");
		WebElement date =driver.findElement(By.id("day"));
		Select sel = new Select(date);
		sel.selectByValue("31");
		WebElement month=driver.findElement(By.id("month"));
		Select sel1 = new Select(month);
		sel1.selectByIndex(7);
		WebElement year = driver.findElement(By.id("year"));
		Select sel2 = new Select(year);
		sel2.selectByVisibleText("1996");
		driver.findElement(By.id("sex")).click();

	}

}
