package Test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTask {

	public static  void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Downloads\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				 String AmazonUrl = "https://www.amazon.in/";
			        String FlipkartUrl = "https://www.flipkart.com/";
			        String AmazonPrice="",FlipkartPrice="",FlipkartName="",FlipkartProductUrl="",AmazonProductUrl="",AmazonName="";
			        
			        //Search In Flipkart
			        driver.get(FlipkartUrl);	
			        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
			        driver.findElement(By.xpath(("//input[@placeholder='Search for products, brands and more']"))).sendKeys("Iphone 13");
			        driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();
			        driver.findElement(By.xpath("//div[normalize-space()='APPLE iPhone 13 (Midnight, 128 GB)']")).click();
			        String mainWindowHandle = driver.getWindowHandle();
			        Set<String> allWindowHandles = driver.getWindowHandles();
			        Iterator<String> iterator = allWindowHandles.iterator();

			        // Here we will check if child window has other child windows and will fetch the heading of the child window
			        while (iterator.hasNext()) {
			            String ChildWindow = iterator.next();
			                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
			                driver.switchTo().window(ChildWindow);
			               FlipkartPrice= driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
			               FlipkartName=	driver.findElement(By.xpath("///span[@class='B_NuCI']")).getText();
			               FlipkartProductUrl=driver.getCurrentUrl();
			                }
			        }
			        driver.quit();
			        // Search In Amazon
			        driver.get(AmazonUrl);
			        driver.findElement(By.xpath(("//input[@id='twotabsearchtextbox']"))).sendKeys("Iphone 13");
			        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			        driver.findElement(By.xpath("//span[normalize-space()='Apple iPhone 13 (128GB) - Midnight']")).click();
			        //Get handles of the windows
			        String mainWindowHandle1 = driver.getWindowHandle();
			        Set<String> allWindowHandles1= driver.getWindowHandles();
			        Iterator<String> iterator1 = allWindowHandles1.iterator();

			        // Here we will check if child window has other child windows and will fetch the heading of the child window
			        while (iterator.hasNext()) {
			            String ChildWindow = iterator1.next();
			                if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow)) {
			                driver.switchTo().window(ChildWindow);
			               AmazonPrice= driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]")).getText();
			               AmazonProductUrl=driver.getCurrentUrl();
			               AmazonName=driver.findElement(By.xpath("(//span[@id='productTitle']")).getText();
			                }
			        }
			                
			      if(Integer.parseInt(AmazonPrice)<Integer.parseInt(FlipkartPrice)) {
			    	  System.out.println("*******Amazon Data*******");
			    	  System.out.println(AmazonName);
			    	  System.out.println(AmazonPrice);
			    	  System.out.println(AmazonProductUrl);
			      }else if(Integer.parseInt(AmazonPrice)>Integer.parseInt(FlipkartPrice)) {
			    	  System.out.println("*******Flikart Data*******");
			    	  System.out.println(FlipkartName);
			    	  System.out.println(FlipkartPrice);
			    	  System.out.println(FlipkartProductUrl);
			      }
			      else {
			    	  System.out.println("*******Amazon Data*******");
			    	  System.out.println(AmazonName);
			    	  System.out.println(AmazonPrice);
			    	  System.out.println(AmazonProductUrl);
			    	  System.out.println("*******Flikart Data*******");
			    	  System.out.println(FlipkartName);
			    	  System.out.println(FlipkartPrice);
			    	  System.out.println(FlipkartProductUrl);
			    	  
			      }
			        
	}
}
