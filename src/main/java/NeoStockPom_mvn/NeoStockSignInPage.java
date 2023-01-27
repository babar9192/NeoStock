package NeoStockPom_mvn;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStockSignInPage 
{

	
	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement MobilenumFeild;
	
	@FindBy(id = "lnk_signup1") private WebElement ClickOnSignIn;
	
	
	public NeoStockSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void SendkeyInMNField(String Userid) throws EncryptedDocumentException, IOException
	{
        //File myfile=new File("C:\\Users\\hp\\Desktop\\salenium1\\Samarth.xlsx");
		
		//Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet6");
		
		//String Userid = mysheet.getRow(0).getCell(0).getStringCellValue();
		
		MobilenumFeild.sendKeys(Userid);
		Reporter.log("Entering mobile number", true);
	}
	
	public void ClickOnSignInButton() throws InterruptedException
	{
		
		ClickOnSignIn.click();
		Reporter.log("clicking on signin button", true);
		
		Thread.sleep(2000);
	}
	
	
}
