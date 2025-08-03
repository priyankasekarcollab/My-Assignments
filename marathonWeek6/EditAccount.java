package marathonWeek6;




import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditAccount extends BaseCLass{
	

	@Test(dataProvider = "fetchdata",dependsOnMethods= {"marathonWeek6.CreateAccount.runCreate"})
	public void runEdit(String accountName) throws InterruptedException {
        
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountName+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        Thread.sleep(3000);
        try {
        	WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
            driver.executeScript("arguments[0].click()",typeDD);
		} catch (ElementClickInterceptedException e) {
			Thread.sleep(1000);
		}
        
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys("Testleaf, Wipro street, Tek meadows");
        WebElement shippingStreet = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
        shippingStreet.clear();
        shippingStreet.sendKeys("Testleaf, Wipro street, Tek meadows");
        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        int randomNum1 = (int)(Math.random()*999999);
        int randomNum2 = (int)(Math.random()*999999);
        String phno = ""+randomNum1+randomNum2;
        phno = phno.substring(0,9);
        System.out.println(phno);
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phno);
        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        Thread.sleep(3000);
        String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
        System.out.println(phnoStr);
        Assert.assertTrue(phnoStr.contains(phno),"verify the mobileNumber");



    }

	
}
