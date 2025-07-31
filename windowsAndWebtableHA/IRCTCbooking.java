package week5.windowsAndWebtableHA;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTCbooking {

	public static void main(String[] args) {
		//launching the IRCTC browser
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Accepting sweet alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		;
		//clicking on flights link
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		//Handling Windows and storing it in List
		Set<String> windows=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windows);
		
		//transferring the driver control to child window
		driver.switchTo().window(win.get(1));
		System.out.println(driver.getTitle());
		
		//transferring the control to parent window
		driver.switchTo().window(win.get(0));
		driver.close();
		
	}

}
