package week4.day1.Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/alert.xhtml");
		
			
//Alert (Simple Dialog)
		System.out.println("=============== Simple Alert=================");
		
		//Click on the Show Button
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		//Switch to Alert
		Alert alert = driver.switchTo().alert();
		//Print the msg from Alert box
		System.out.println(alert.getText());
		//Accept the alert
		alert.accept();
		//Print the text after accept the alert
		String text = driver.findElement(By.id("simple_result")).getText();
		System.out.println(text);
		
//Alert (Confirm Dialog)
		System.out.println("===============Confirm Dialog=================");
				
		//Click on the Show Button
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		//Switch to Alert
		Alert alert2 = driver.switchTo().alert();
		//Print the msg from Alert box
		System.out.println(alert2.getText());
	/*	//Accept the alert
		alert.accept();
		//Print the text after accept the alert
		String text2 = driver.findElement(By.xpath("//span[text()='User Clicked : OK']")).getText();
	    System.out.println(text2);    */
		//Dismiss the Alert
		alert.dismiss();
	    //Print the text after cancel the alert		
		String text3 = driver.findElement(By.xpath("//span[text()='User Clicked : Cancel']")).getText();
		System.out.println(text3);
		
		
//Alert (Prompt Dialog)	
		System.out.println("==============Prompt Dialog==================");
		
		//Click on the Show Button
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		//Switch to Alert
		Alert alert3 = driver.switchTo().alert();
		//Print the msg from Alert box
		System.out.println(alert3.getText());
		//Enter the text to the text box
		alert.sendKeys("RamyaSanthosh");
		//Accept the alert
		alert.accept();
		//verify the alert was accepted
		String  text4 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text4);
		//Dismiss the Prompt alert
		//alert.dismiss();
		//verify the Prompt alert was cancelled
        //String  text5 = driver.findElement(By.xpath("//span[text()='User cancelled the prompt.']")).getText();
		//System.out.println(text5);
		
//Sweet Alert (Simple Dialog)
		System.out.println("==============Sweet Alert (Simple Dialog)==================");		
		//Click on the Show Button
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		//Print the msg from the dialog box
		String text6= driver.findElement(By.xpath("(//div[contains(@class,'ui-dialog-content')]/p)[1]")).getText();
		System.out.println(text6);
		//Dismiss the Dialogbox
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[text()='Dismiss']")).click();
		
		
//Sweet Alert (Confirmation)
		System.out.println("==============Sweet Alert (Confirmation)==================");
		//Click on the Delete Button
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		//Print the Qus from the dialog box
		String text8 = driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText();
		System.out.println(text8);
		//Accept the delete 
		//driver.findElement(By.xpath("//span[text()='Yes']")).click();
		driver.findElement(By.xpath("//span[text()='No']")).click();
		
//Minimize and Maximize		
		System.out.println("==============Sweet Alert (Confirmation)==================");
		//Click on the Show Button
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
		String text9 = driver.findElement(By.xpath("(//p[@class='m-0'])[2]")).getText();
        System.out.println(text9);
        //Minimize the msg box
         driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
        //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
        //driver.findElement(By.xpath("(//a//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
        
      
//Sweet Modal Dialog		
		System.out.println("==============Sweet Modal Dialog==================");		
		//Click on the Show Button
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		//Print the msg from the dialog box
		String text7 = driver.findElement(By.xpath("((//div[contains(@class,'ui-dialog-content')])/p)[2]")).getText();
		System.out.println(text7);
		//Close the dialogbox
		//driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		  
		        
	}
}
