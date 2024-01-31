package commonFunction;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.cucumber.java.it.Date;


public class functionLibrary {
	 public static WebDriver driver;
	//methods for launch browser
	public static WebDriver startBrowser()throws Throwable
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		return driver;	
	}
	public static void openApplcation(WebDriver driWebDriver,String Url) throws Throwable
	{
		driver.get(Url);
	}
	//method for wait for element
	public static void waitForElement1(WebDriver driver,String Locator_Type,String Locator_Value,String mywait)
	{
		WebDriverWait wait = new WebDriverWait(functionLibrary.driver, java.time.Duration.ofSeconds(Integer.parseInt(mywait)));
		if(Locator_Type.equalsIgnoreCase("name"))
		{
			wait .until(ExpectedConditions.visibilityOfElementLocated(By.name(Locator_Value)));
		}
		else if(Locator_Type.equalsIgnoreCase("xpath"))
		{
			wait .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_Value)));
		}
		else if(Locator_Type.equalsIgnoreCase("id"))
		{
			wait .until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator_Value)));
		}
	}
	//method for textboxes
	public static void typeAction1(WebDriver driver,String LocatorType,String LocatorValue,String TestData)
	{
		if(LocatorType.equalsIgnoreCase("name"))
		{
			functionLibrary.driver.findElement(By.name(LocatorValue)).clear();
			driver.findElement(By.name(LocatorValue)).sendKeys(TestData);
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).clear();
			driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
		}
		else if(LocatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(LocatorValue)).clear();
			driver.findElement(By.id(LocatorValue)).sendKeys(TestData);
		}
	}
	//method for buttons,links,checkboxes,radio button and image
	public static void clickAction1(WebDriver driver,String LocatorType,String LocatorValue)
	{
		if(LocatorType.equalsIgnoreCase("name"))
		{
			functionLibrary.driver.findElement(By.name(LocatorValue)).click();
		}
		else if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).click();
		}
		else if(LocatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);
		}
	}
	//method for validating title
	public static void validateTitle1(WebDriver driver,String Expected_Title)
	{
		String Actual_Title = driver.getTitle();
		try {
		org.testng.Assert.assertEquals(Actual_Title, Expected_Title, "Title is Not Matching");
		}catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}
	//method for closing browser
	public static void closeBrowser1(WebDriver driver)
	{
		driver.quit();
	}
	//method for mouse click
	public static void mouseClick1(WebDriver driver) throws Throwable
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//a[starts-with(text(),'Stock Items ')]"))).perform();
		Thread.sleep(3000);
		ac.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Stock Categories')])[2]"))).click().perform();
	}
	//method for category table
	public static void categoryTable1(WebDriver driver,String Exp_Data) throws Throwable
	{
		if(!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
			//if search textbox is not displayed click search panel button
		driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
		//enter category name
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_Data);
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		Thread.sleep(3000);
		String Act_Data =driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[4]/div/span/span")).getText();
		System.out.println(Exp_Data+"        "+Act_Data);
		org.testng.Assert.assertEquals(Exp_Data, Act_Data,"Category Name is Not Matching");
	}
	//method for drop down
	public static void dropDownAction1(WebDriver driver, String locatorType, String locatorValue, String testdata) throws Exception
	{
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			int value = Integer.parseInt(testdata);
			WebElement element = driver.findElement(By.xpath(locatorValue));
			Select select = new Select(element);
			select.selectByIndex(value);
			
		}
		if(locatorType.equalsIgnoreCase("id"))
		{
			int value = Integer.parseInt(testdata);
			WebElement element = driver.findElement(By.id(locatorValue));
			Select select = new Select(element);
			select.selectByIndex(value);
			
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			int value = Integer.parseInt(testdata);
			WebElement element = driver.findElement(By.name(locatorValue));
			Select select = new Select(element);
			select.selectByIndex(value);
			
		}
	}
	public static void capturestock1(WebDriver driver, String Locator_Type,String Locator_Value)throws Throwable
	{
		String Expected_Num="";
		if(Locator_Type.equalsIgnoreCase("xpath"))
		{
			Expected_Num =driver.findElement(By.xpath(Locator_Value)).getAttribute("value");
		}
		else if(Locator_Type.equalsIgnoreCase("id"))
		{
			Expected_Num =driver.findElement(By.id(Locator_Value)).getAttribute("value");
		}
		else if(Locator_Type.equalsIgnoreCase("name"))
		{
			Expected_Num =driver.findElement(By.name(Locator_Value)).getAttribute("value");
		}
		FileWriter fw = new FileWriter("./CaptureData/stocknum.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Expected_Num);
		bw.flush();
		bw.close();
		
	}
	public static void stockTable1(WebDriver driver)throws Throwable
	{
		FileReader fr = new FileReader("./CaptureData/stocknum.txt");
		try (BufferedReader br = new BufferedReader(fr)) {
			String Exp_stocknumber =br.readLine();
			if(!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
				//if search textbox is not displayed click search panel button
			driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
			//enter category name
			driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_stocknumber);
			driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
			Thread.sleep(3000);
			String Act_StockNum = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[8]/div/span/span")).getText();
			System.out.println(Exp_stocknumber+"     "+Act_StockNum);
			org.testng.Assert.assertEquals(Exp_stocknumber, Act_StockNum, "Stock Number Not Matching");
		}
	}
	public static void captureSupp1(WebDriver driver,String Locator_Type,String Locator_Value)throws Throwable
	{
		String Expected_Data ="";
		if(Locator_Type.equalsIgnoreCase("xpath"))
		{
			Expected_Data = driver.findElement(By.xpath(Locator_Value)).getAttribute("value");
		}
		else if(Locator_Type.equalsIgnoreCase("id"))
		{
			Expected_Data = driver.findElement(By.id(Locator_Value)).getAttribute("value");
		}
		else if(Locator_Type.equalsIgnoreCase("name"))
		{
			Expected_Data = driver.findElement(By.name(Locator_Value)).getAttribute("value");
		}
		FileWriter fw = new FileWriter("./CaptureData/suppliernum.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Expected_Data);
		bw.flush();
		bw.close();
		
	}
	public static void supplierTable1(WebDriver driver)throws Throwable
	{
		FileReader fr = new FileReader("./CaptureData/suppliernum.txt");
		try (BufferedReader br = new BufferedReader(fr)) {
			String Exp_suppliernumber =br.readLine();
			if(!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
				//if search textbox is not displayed click search panel button
			driver.findElement(By.xpath("//span[@data-caption='Search']")).click();
			//enter category name
			driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(Exp_suppliernumber);
			driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
			Thread.sleep(3000);
			String Act_suppliernumber = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
			System.out.println(Exp_suppliernumber+"     "+Act_suppliernumber);
			org.testng.Assert.assertEquals(Exp_suppliernumber, Act_suppliernumber, "Supplier number Not Matching");
		}
	}
	public static String generateDate1()
	{
		Date date = (Date) new java.util.Date();
		DateFormat df = new SimpleDateFormat("YYYY_MM_hh dd_mm_ss");
		return df.format(date);

	}

}











		
		
	
	
	


