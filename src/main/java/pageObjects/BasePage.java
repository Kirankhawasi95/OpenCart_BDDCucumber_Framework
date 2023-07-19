package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import WebActions.Action_Class;

public class BasePage {

	public WebDriver driver;
	public Action_Class act=new Action_Class();
	
	
	    
	   public BasePage(WebDriver driver)
	     {
		     this.driver=driver;
		     PageFactory.initElements(driver,this);
	     }
	   	   
}





