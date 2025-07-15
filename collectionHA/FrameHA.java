package week4.collectionHA;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHA {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		
		//Handling frame
		driver.switchTo().frame(1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Handling alret
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		//verification
		WebElement msg=driver.findElement(By.xpath("//p[@id='demo']"));
		if (msg.isDisplayed()) {
			System.out.println("You have successfully completed the action");
		}
		//close browser
		driver.close();
	}

}
