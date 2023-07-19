/**
 * 
 */
package WebActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author kpkmt942
 *
 */
public class Action_Class {

	/**
	 *Method for mouse and keybord operation 
	 * @return Boolean
	 * 
	 *
	 * Check MyStore Logo Image Presence
	 * @return - true/false
	 */
	
	//Method for mouse and keybord action 
	public void Click(WebDriver driver, WebElement ele) 
	
	{
		Actions act= new Actions(driver);
		act.click(ele).build().perform();
	}


	/**
	 * Method For to check any Logo or Any WebElement is display or not 
	 * @return Boolean
	 * 
	 *
	 * Check MyStore Logo Image Presence
	 * @return - true/false
	 */
//Method For to check any Logo or Any WebElement is display or not 
	public boolean Isdisplayed(WebDriver driver, WebElement ele)
	{
		
		boolean flag =false;
		
		ele.isDisplayed();
		flag = true;
		
		if(flag)
		{
			System.out.println("Successfully Found And Element is displayed at");
		}
		
		else
		{
			System.out.println("Successfully Found Element But Element is not displayed at");
		}
		return flag;
		}
	
	//Method for to check Radio button is Enable or not
	public boolean IsEnable(WebDriver driver, WebElement ele)
	{
		
		boolean flag =false;
		
		ele.isEnabled();
		flag = true;
		
		if(flag)
		{
			System.out.println("Successfully Found And Element is displayed at");
		}
		
		else
		{
			System.out.println("Successfully Found Element But Element is not displayed at");
		}
		return flag;
		}
	
	//Method for to check Element  button is Selected or not
	public boolean IsSelected(WebDriver driver, WebElement ele)
	{
		
		boolean flag =false;
		
		ele.isEnabled();
		flag = true;
		
		if(flag)
		{
			System.out.println("Successfully Found And Element is displayed at");
		}
		
		else
		{
			System.out.println("Successfully Found Element But Element is not displayed at");
		}
		return flag;
		}
	
	/**
	 * Method Name Send the text in the Search Field box
	 * @return 
	 * 
	 *
	 * @Kiran text
	 * @return - true/false
	 */
	
	public boolean TextSend(WebElement ele, String text) 
	{
		boolean flag = false;
		
		try {
			
			flag=ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);	
			flag=true;
			
		}catch(Exception e)
		
		{
			System.out.println("Location Not Found");
			flag=false;
			
		}finally {
			
			if(flag)
			{
				System.out.println("Successfully entered Text in the Search Fild");
			}else {
				System.out.println("Unable to enter Text in the Search Fild");
			}

		}
		return flag;
		
		
	}


	/**
	 * MethodType is Get the Text in the WebElement
	 * @return Text
	 * 
	 *
	 * @Kiran GetText
	 * @return - true/false
	 */
	public String GetText(WebDriver driver, WebElement ele)
	{
		
		boolean flag = false;
			
			String text=ele.getText();
			System.out.println(text);
			flag=true;
			
			if(flag)
			{
				System.out.println("Successfully Found a displayed Text");
			}else
				
			{
				System.out.println("Text not Found");
			}
			
		return text;
	}


	/**
	 * Method for Select class(SelectByIndex) used for Dropdown Action 
	 * @return Text associated with value on WebElement 
	 * 
	 *
	 * @Kiran Select a Text by value 
	 * @return - true/false
	 */
	public boolean SelectByIndex(WebElement driver, int ele) {
		
		boolean flag=false;
		
		try {
			
			Select sel=new Select(driver);
			sel.selectByIndex(ele);
			flag = true;
			
		}catch(Exception e)
		
		{
			System.out.println("Index value is not Selected at");
			flag=false;
		}finally 
		
		{
			if(flag) 
			{
				System.out.println("Successfully selected index a value");
			}else
			{
				System.out.println("Unable to get the index value");
			}
		}
		
		return false;
	}
	


	/**
	 * Method for JavaScriptExecutor for Click() Action 
	 * @return  WebElement Element 
	 * 
	 *
	 * @Kiran JavaScriptExecutor for Click() Action  
	 * @return - true/false
	 */

	public boolean JavascriptExe(WebDriver driver, WebElement ele) 
	{
	boolean flag=false;
	try{
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		flag=true;
		
	}catch(Exception e)
	
	{
		System.out.println("Element Not Fount");
		flag=false;
	}finally
	
	{
		if(flag) 
			
		{
			System.out.println("Succssfully performed Click action");
		}else 
		{
			System.out.println("Unable to performed Click action");
		}
		
	}
	return false;
	
	}


	

	/**
	 * Method for Synchronization and Wait Statement  
	 * @return  Time in second 
	 * 
	 *
	 * @Kiran implicitWait ExplicitWait and PageLoadTime 
	 * @return - Time in second 
	 */
	
	public void implicitWait(WebDriver driver, int timeOut) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
		

	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut) 
	{
	    WebDriverWait wait = new WebDriverWait(driver, timeOut);
	    wait.until(ExpectedConditions.visibilityOf(element));    
	}

	
	public void pageLoadTimeOut(WebDriver driver, int timeOut) 
	
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}


	


}
