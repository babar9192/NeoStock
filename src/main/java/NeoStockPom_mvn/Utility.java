package NeoStockPom_mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;



public class Utility
{
	private static final String TakaScreenshot = null;

	//Excel
	//Screenshot
	//ScrollIntoView
	//Wait
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		// create object of properties class
		Properties prop=new Properties();
		
		//create object of fileInputStream
		FileInputStream  myFile=new FileInputStream("C:\\Users\\hp\\eclipse-workspace_1\\20_Aug_Mvn\\propertyFile.properties");
	
		//loadFile
		prop.load(myFile);
		
		//readDataFromPropertyFile
		String value = prop.getProperty(key);
		Reporter.log("Reading data from Property File", true);
		Reporter.log("Data is "+value, true);
		return value;
		
		
	}
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
	  File myfile = new File("C:\\Users\\hp\\Desktop\\salenium1\\Samarth.xlsx");
	  Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet6");
	  String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
	Reporter.log("Reading data from Excel sheet row is "+row+"cell is "+cell, true);
	  return value;
	  
	}
	
	public static void implicitWait(int time, WebDriver driver )
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("waiting for "+time+"ms", true);
	}
	
	public static void takeScreenShot(WebDriver driver, String FileName) throws IOException
	{
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest= new File("C:\\Users\\hp\\Desktop\\Failed_SS"+FileName+".png");
	  FileHandler.copy(src, dest);
	  Reporter.log("taking screenshot ", true);
	  Reporter.log("screenShot taken and saved at "+dest, true);
	  
	}
    
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		Reporter.log("scrolling into view to "+element.getText(), true);
	}
}
