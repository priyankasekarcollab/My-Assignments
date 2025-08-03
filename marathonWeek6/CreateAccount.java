package marathonWeek6;







import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

public class CreateAccount extends BaseCLass{
	
	@Test(dataProvider = "fetchdata")
	public void runCreate(String accountName) {
		
        driver.findElement(By.xpath("//a[@title='New']")).click();
       
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(toastMessage);
        Assert.assertTrue(toastMessage.contains(accountName),"Verify the Account name");
    }

}
