package NeoStockPom_mvn;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;





public class Base 
{
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException  
	{
		driver=new ChromeDriver();
		
		//driver.manage().window().maximize();
		//driver.get("https://neostox.com/");
		
		driver.get(Utility.readDataFromPropertyFile("url"));
		
		Utility.implicitWait(1000, driver);
		//commit
		
		Reporter.log("launching browser", true);
		// comment
		
		
	}
	

}
