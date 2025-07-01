package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckboxHA {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option= new ChromeOptions();
		
		option.addArguments("guest");
		
		ChromeDriver driver= new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.get("https://leafground.com/checkbox.xhtml");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement basic=driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89']"));
		
		WebElement ajax=driver.findElement(By.xpath("//div[@id='j_idt87:j_idt91']"));
		
		basic.click();
		
		ajax.click();
		
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt89_input']"));
		
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt91_input']"));
		
		if (checkbox.isSelected()) {
			System.out.println("The Basic is selected");
		} else {
			System.out.println("The Basic is not selected");
		}
		if (checkbox1.isSelected()) {
			System.out.println("The ajax is selected");
		} else {
			System.out.println("The ajax is not selected");
		}
		
		driver.findElement(By.xpath("//div[@class='ui-chkbox ui-widget']/parent::td[1]")).click();
		
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();
		
		Thread.sleep(3000);
		
		WebElement state=driver.findElement(By.xpath("//p[text()='State = 1']"));
		
		if (state.isDisplayed()) {
			System.out.println("The Tri-state option is Stage 1");
		} 
		
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		
		WebElement toggleswitch= driver.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']"));
		
		if (toggleswitch.isSelected()) {
			System.out.println("The Toggle switch is on");
		} else {
			System.out.println("The toggle switch is off");

		}
		
		WebElement disablecheckbox=driver.findElement(By.xpath("//input[@id='j_idt87:j_idt102_input']"));
		
		if (disablecheckbox.isEnabled()) {
			System.out.println("The checkbox is enabled");
		} else {
			System.out.println("The checkbox is disabled");
		}
		
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		
		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[7]")).click();
		
	}

}
