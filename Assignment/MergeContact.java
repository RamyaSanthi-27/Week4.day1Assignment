package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	    driver.get("http://leaftaps.com/opentaps/control/login");		 
//2. Enter UserName and Password Using Id Locator
	    driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");	    
// 3. Click on Login Button using Class Locator
	    driver.findElement(By.className("decorativeSubmit")).click();
// 4. Click on CRM/SFA Link
	    driver.findElement(By.linkText("CRM/SFA")).click();		 
// 5. Click on contacts Button
        driver.findElement(By.linkText("Contacts")).click();
		  	
//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();  
//7. Click on Widget of From Contact
	    driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[1]")).click();	    
//create set and list to navigate to newly opened page
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> listWindow = new ArrayList<String>(windowHandles);	  
	    driver.switchTo().window(listWindow.get(1));
	    String title = driver.getTitle();
	    System.out.println(title);
// 8. Click on First Resulting Contact
	    driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//div[contains(@class,'x-grid3-cell-inner')]/a[@class='linktext'])[1]")).click();	    

//switch to parent window
	    driver.switchTo().window(listWindow.get(0));	    
// 9. Click on Widget of To Contact
		 driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[2]")).click();		  
//create set and list to navigate to newly opened page
		 Set<String> windowHandles2 = driver.getWindowHandles();
		 List<String> listwindow2 = new ArrayList<String>(windowHandles2);
		 driver.switchTo().window(listwindow2.get(1));
		 String title2 = driver.getTitle();
		 System.out.println(title2);
// 10. Click on Second Resulting Contact
		  driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//div[contains(@class,'x-grid3-cell-inner')]/a[@class='linktext'])[5]")).click();
		
//switch to parent window
          driver.switchTo().window(listwindow2.get(0));		    
// 11. Click on Merge button using Xpath Locator
		  driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		  		  
//Handle the alret
		 Alert alert = driver.switchTo().alert();
//print the message from the dialog box
		 String text = alert.getText();
		 System.out.println(text);
// 12. Accept the Alert
		 alert.accept();		 
//13. Verify the title of the page
		 System.out.println(driver.getTitle());
		if (driver.getTitle().contains("View Contact")) {
			System.out.println("This is Correct Page");
		}
		else {
			System.out.println("This is Not Correct Page");
		}
		
	}

}
