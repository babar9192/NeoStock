package NeoStockPom_mvn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStockDashboardPage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popupOkButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement popUpCloseButton;

	
	@FindBy(id = "lbl_username") private WebElement  userName;
	
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	
	//@FindBy(xpath = "lbl_curbalancetop") private WebElement acBalance;
	
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;

	public String gettingAcBalance()
	{
		String balance = acBalance.getText();
		Reporter.log("getting AC Balance", true);
		Reporter.log(" AC Balance is "+balance, true);
		return balance;
	}
	
	public NeoStockDashboardPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void  handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		if(popupOkButton.isDisplayed())
		{
			Thread.sleep(5000);
		Utility.scrollIntoView(driver, popupOkButton);
			Thread.sleep(1000);
			popupOkButton.click();
			Reporter.log("clicking on popup ok button", true);
			Thread.sleep(3000);
//			Utility.scrollIntoView(driver, popUpCloseButton);
//			Thread.sleep(1000);
//	        popUpCloseButton.click();
//	        Thread.sleep(500);
//			Reporter.log("clicking on popup close button", true);
		}
		else
		{
			Reporter.log("There is no popUp", true);
		}
	}
	
	
	public void logOutFromNeoStox() throws InterruptedException
	{  Thread.sleep(3000);
	   userName.click();
	   Thread.sleep(2000);
	   logOutButton.click();
	   Reporter.log("logging out from neostock", true);
	}
	
	public String getActualUsername()
	{
		String actualUsername=userName.getText();
		Reporter.log("Actual user name is---->"+actualUsername, true);
		return actualUsername;
	}
	
	
	
}
