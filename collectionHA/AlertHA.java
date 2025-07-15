package week4.collectionHA;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHA {

	public static void main(String[] args) {
		//initialize ChromeBrowser
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//clicking on alert button
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
		
		//Handling alert
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Priyanka Sekar");
		alert.accept();
		
		//Verification
		WebElement verify=driver.findElement(By.xpath("//span[@id='confirm_result']"));
		System.out.println(verify.getText());
		
		//close browser
		driver.close();

	}

}
