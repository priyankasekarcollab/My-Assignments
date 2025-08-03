package marathonWeek6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccount extends BaseCLass{
	@Test(dataProvider = "fetchdata",dependsOnMethods= {"marathonWeek6.CreateAccount.runCreate","marathonWeek6.EditAccount.runEdit"})
	 public void runDelete(String accountName) throws InterruptedException {
	        
	        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountName+ Keys.ENTER);
	        Thread.sleep(2000);
	        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	        String[] s = noOfItems.split(" ");
	        int countBeforeDelete = Integer.parseInt(s[0]);
	        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
	        driver.findElement(By.xpath("(//a[@class='highlightButton'])[2]")).click();
	        driver.findElement(By.xpath("//button[@title='Delete']")).click();
	        Thread.sleep(2000);
	        noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
	        s = noOfItems.split(" ");
	        int countAfterDelete = Integer.parseInt(s[0]);

	        Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");

	    }

}
