package reshu18;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sridhar {
	public static void main(String[] args) throws InterruptedException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icicidirect.com/idirectcontent/Markets/MarketOverview.aspx");
	    driver.findElement(By.linkText("Daily Share Prices")).click();
	    String str;
	    Thread.sleep(5000);
	    for(int s=1; s<=20;s++)
	    {
	    str=driver.findElement
	    		(By.xpath("//table[@id='gridSource']/tbody/tr["+s+"]/td[1]")).getText();
	             System.out.println(str);
     }
	    
	    

	}

}

