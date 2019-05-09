package Eggtimer.Eggtimer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

public class TimerAndCounter {
	
	 static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver","Dependency/chromedriver");
	 driver = new ChromeDriver();
		
		
		driver.get("http://e.ggtimer.com");
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if (title.equals("E.gg Timer - a simple countdown timer")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("start_a_timer")).clear();
		driver.findElement(By.id("start_a_timer")).sendKeys("25 Seconds");
	    driver.findElement(By.id("timergo")).click();
	    
	  //  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	   
	  //   for(int j=1; j<25;j++) §1
	   //  { 
	   final Timer t = new Timer();
	   
	   t.schedule(new TimerTask() {
		   int y=getTime();
		    @Override
		    public void run() {
		      try {
		    	  int x = getTime();
		    	 if(x==y) {
		    		 System.out.println(x);
		    		 System.out.println("pass");
		    	 }
		    	 else
		    	 {
		    		 System.out.println(x);
		    		 System.out.println(y);
		    		 System.out.println("fail");
		    	 }
		    	 y=y-1;
		    	  
		      }catch (UnhandledAlertException | InterruptedException f) {
		    	  driver.switchTo().alert().dismiss();
		    	   t.cancel();
		           t.purge();
		           return;  
		      }
		      
		       
		       		    }
		}, 0, 999);
	    
	 //  assertThat(driver.switchTo().alert().getText(), is("Time Expired!"));
	    
	    
	    /*public void isUrlCorrect("E.gg Timer - a simple countdown timer"){ 
	    	  int count = 0;
	    	 
	    	   do { 
	    	     count ++;
	    	     waitFor(1);
	    	   } while (urlContains(keyword) == false && count < 25);
	    	 
	    	   if(count == 25)
	    	     throw new PageNotDisplayedException(“Page not loaded”);; 
	    	}
	    	private void urlContains("E.gg Timer - a simple countdown timer") {
	    	   return driver.getCurrentUrl().contains(keyword);
	    	}*/
	    
	    //driver.quit();
	}
	
	public static int getTime() throws InterruptedException {
		
		   String x = driver.findElement(By.id("progressText")).getText();
	       String[] parts = x.split(" ");
	       String part1 = parts[0];
	       int tim = Integer.parseInt(part1);
	     //  System.out.println(tim);
	       return tim;
	       
	}

}
