package NeoStockPom_mvn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

      public class NeoStockHomePage 
       {
	

		//1 Data member should be declared globally with access level private using @findBy Annotation 

		@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement signInButton;
		
		//2 Initialize within a constructor with access level public using pagefactory
		
		public NeoStockHomePage(WebDriver driver)
		{
			
			PageFactory.initElements(driver, this);
			
		}
		
		//3 Utilize within a method with access level public
		
		public void ClickOnSignInButton()
		{
			
			signInButton.click();
			Reporter.log("clicking on signin button", true);
			
		}
		
		
	

}
