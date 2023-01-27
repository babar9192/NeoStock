package NeoStockPom_Mvn;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



import NeoStockPom_mvn.Base;
import NeoStockPom_mvn.Utility;


public class Listener extends Base implements ITestListener 
{
	
	public void onTestFailure(ITestResult result)
	{
	 // Reporter.log("TC"+result.getName()+"failed", true);
	  try {
		  Reporter.log("TC"+result.getName()+"failed", true);
		Utility.takeScreenShot(driver, result.getName());
	} catch (IOException e) 
	  {
		
	  }
	}
	
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("TC"+result.getName()+"passed", true);
	}

}
