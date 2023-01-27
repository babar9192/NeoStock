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

public class NeoStockPasswordPage 
{
       @FindBy(id = "txt_accesspin") private WebElement PasswordTextBox;
       @FindBy(id = "lnk_submitaccesspin") private WebElement SubmitButton;
       
     
       public NeoStockPasswordPage(WebDriver driver)
       {
    	   
    	   PageFactory.initElements(driver, this);
       }
       
	
	    public void enterPass(String password) throws EncryptedDocumentException, IOException
	    {
//		 File myfile=new File("C:\\Users\\hp\\Desktop\\salenium1\\Samarth.xlsx");
//			
//			Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet6");
//		
//			String Password = mysheet.getRow(0).getCell(1).getStringCellValue();
			
			PasswordTextBox.sendKeys(password);
			Reporter.log("Entering Password", true);
    	}
	
	public void ClickOnSubmitButton() throws InterruptedException
	{
		Thread.sleep(500);
		SubmitButton.click();
		Reporter.log("clicking on submit button", true);
	}
	
	
}
