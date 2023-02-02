package NeoStockPom_mvn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dummy_homePage
{
	@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement signInButton;
	
	//2 Initialize within a constructor with access level public using pagefactory
	
	public dummy_homePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
}
