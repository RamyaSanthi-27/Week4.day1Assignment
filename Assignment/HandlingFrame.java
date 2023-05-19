package week4.day1.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	    driver.get("https://www.leafground.com/frame.xhtml");	
//Switch to Frame
	    driver.switchTo().frame(0);

//Click Me (Inside frame)	
	    //Click on the Click me Button
	    driver.findElement(By.xpath("//button[@id='Click'][text()='Click Me']")).click();
	    String text = driver.findElement(By.xpath("//button[@id='Click'][text()='Hurray! You Clicked Me.']")).getText();
	    System.out.println("Inside frame :  " +text);
	    
//Switch to Main Frame
	    driver.switchTo().defaultContent();
	    
//Switch to Frame1	    
//How many frames in this page?
	    driver.switchTo().frame(1);
	    driver.findElement(By.xpath("//button[@id='Click'][text()='Count Frames']")).click();
	    String text2 = driver.findElement(By.xpath("//button[@id='Click'][text()='Count Frames']")).getText();
	    System.out.println("How many frames in this page?  " +text2);
	    
//Switch to Main Frame
	    driver.switchTo().defaultContent();
//Switch to  Frame2
	    driver.switchTo().frame(2);
//Switch from Frame2 to Nested Frame
	    driver.switchTo().frame("frame2");
//Click Me (Inside Nested frame)
	    driver.findElement(By.xpath("//button[@id='Click'][text()='Click Me']")).click();
	    String text3 = driver.findElement(By.xpath("//button[@id='Click'][text()='Hurray! You Clicked Me.']")).getText();
	    System.out.println("Inside Nested frame : "+text3 ); 
//How many frames in this page?
	 		driver.switchTo().defaultContent();
	 		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
	 		System.out.println("Total Number of Frame in the page : " + frame.size());
	 		Thread.sleep(5000);
	 		driver.quit();
	}

}
