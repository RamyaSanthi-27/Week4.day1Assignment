package week4.day1.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandiligWindow {

	public static void main(String[] args) {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
//Launch the URL
         driver.get("https://www.leafground.com/window.xhtml");
//Handle the window
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        System.out.println("==========Parent Window==============");
        System.out.println(driver.getTitle());
       
//Click and Confirm new Window Opens
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        System.out.println("==========Parent Window==============");
        System.out.println(driver.getTitle());
        
        //Handle the newly open window
        Set<String> windowHandles = driver.getWindowHandles();
        //convert Set into new Window
        List<String> childWindow=new ArrayList<String>(windowHandles);
        //Switch to parent to child window
        driver.switchTo().window(childWindow.get(1));
        System.out.println("===========New Window=============");
        System.out.println(driver.getTitle());  
        
//Switch to parent Window
        driver.switchTo().window(windowHandle);
        //Find the number of opened tabs
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        System.out.println("============Parent Window============");
        System.out.println(driver.getTitle());  
        
        
      //Handle the newly open window
        Set<String> window = driver.getWindowHandles();
        //convert Set into new Window
        List<String> childWindow2=new ArrayList<String>(window);
        //Switch to parent to child window
        driver.switchTo().window(childWindow2.get(3));
        
        driver.switchTo().window(childWindow2.get(2));
        System.out.println("===========New Multi Window=============");
        System.out.println(driver.getTitle());  
      //Handle the newly open window
        Set<String> window1 = driver.getWindowHandles();
        //convert Set into new Window
        List<String> childWindow3=new ArrayList<String>(window1);
        //Switch to parent to child window
        driver.switchTo().window(childWindow3.get(3));
        System.out.println(driver.getTitle()); 
       
        
//Switch to parent Window
        driver.switchTo().window(windowHandle);
//Close all windows except Primary    
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        System.out.println("============Parent Window============");
        System.out.println(driver.getTitle()); 
        
      //Handle the newly open window
        Set<String> window2 = driver.getWindowHandles();
        //convert Set into new Window
        List<String> childWindow4=new ArrayList<String>(window2);
        //Switch to parent to child window
        driver.switchTo().window(childWindow4.get(4));
        System.out.println("=========== windows except Primary =============");
        System.out.println(driver.getTitle()); 
        driver.switchTo().window(childWindow4.get(5));
        System.out.println(driver.getTitle()); 
        driver.switchTo().window(childWindow4.get(6));
        System.out.println(driver.getTitle()); 
        
//Switch to parent Window
        driver.switchTo().window(windowHandle);       
//Wait for 2 new tabs to open        
        driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
        System.out.println("============Parent Window============");
        System.out.println(driver.getTitle());
        
      //Handle the newly open window
        Set<String> window3 = driver.getWindowHandles();
        //convert Set into new Window
        List<String> childWindow5=new ArrayList<String>(window3);
        //Switch to parent to child window
        driver.switchTo().window(childWindow5.get(7));
        System.out.println("=========== new tabs to open =============");
        System.out.println(driver.getTitle()); 
        driver.switchTo().window(childWindow5.get(8));
        System.out.println(driver.getTitle()); 
       // driver.close();
        driver.quit();
	}

}
