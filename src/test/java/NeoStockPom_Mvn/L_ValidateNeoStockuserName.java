package NeoStockPom_Mvn;

import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import NeoStockPom_mvn.Base;
import NeoStockPom_mvn.NeoStockDashboardPage;
import NeoStockPom_mvn.NeoStockHomePage;
import NeoStockPom_mvn.NeoStockPasswordPage;
import NeoStockPom_mvn.NeoStockSignInPage;
import NeoStockPom_mvn.Utility;


@Listeners(NeoStockPom_Mvn.Listener.class)

public class L_ValidateNeoStockuserName extends Base
{    
	
	NeoStockHomePage home;
	NeoStockSignInPage signin;
	NeoStockPasswordPage pass;
	NeoStockDashboardPage dash;
	String s="TCID9192";
	

	
	@BeforeClass
	public void launchNeoStockApp() throws IOException 
	{
		launchBrowser();
	    home=new NeoStockHomePage(driver);
		signin=new NeoStockSignInPage(driver);
		pass=new NeoStockPasswordPage(driver);
		dash=new NeoStockDashboardPage(driver);

		
	}
	@BeforeMethod
	public void loginToNeoStock() throws InterruptedException, EncryptedDocumentException, IOException
	{
		home.ClickOnSignInButton();
		Utility.implicitWait(1000, driver);
		signin.SendkeyInMNField(Utility.readDataFromPropertyFile("mobile"));
		Thread.sleep(1000);
		signin.ClickOnSignInButton();
		Utility.implicitWait(1000, driver);
		pass.enterPass(Utility.readDataFromPropertyFile("password"));
		pass.ClickOnSubmitButton();
		dash.handlePopUp(driver);
	
	}
	
  @Test
  public void ValidateUserName() throws EncryptedDocumentException, IOException 
  {
	  
	  //Assert.fail();
	  Assert.assertEquals(dash.getActualUsername(),Utility.readDataFromPropertyFile("UserName"),"Actual and Expected user Names are not matching TC is failed");
 
	 
	  
  }
  @Test
  public void ValidateACBalance() throws EncryptedDocumentException, IOException 
  {
	  
	  //Assert.fail();
	  Assert.assertNotNull(dash.gettingAcBalance(),"AC Balance is null Tc Failed" );
 
	  
	  
  }
  
  @AfterMethod
  public void logOutFromNeoStock() throws InterruptedException
  {
	  dash.logOutFromNeoStox();
  }
  
  @AfterClass
  public void closeNeoStockApp() throws InterruptedException
  {
	  driver.close();
	  Reporter.log("Closing Application", true);
	  Thread.sleep(10000);
  }
}
