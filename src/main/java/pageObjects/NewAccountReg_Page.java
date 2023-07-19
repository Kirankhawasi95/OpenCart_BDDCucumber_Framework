/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebActions.Action_Class;



/**
 * @author kpkmt942
 *
 */
public class NewAccountReg_Page extends BasePage{


	public NewAccountReg_Page(WebDriver driver) {
		super(driver);
		
	
	}
	
	@FindBy(name="firstname")
	WebElement First_name;
	
	@FindBy(name="lastname")
	WebElement Last_Name;
	
	@FindBy(id="input-email")
	WebElement Email_Fild;
	
//	@FindBy(name="telephone")
//	WebElement Tel_no;
//	
	@FindBy(name="password")
	WebElement Password_fild;
	
//	@FindBy(name="confirm")
//	WebElement confPassword_fild;
	

	@FindBy(name="//div[@class=\"d-inline-block pt-2 pd-2 w-100\"]//input[@name='agree']")
	WebElement CheckBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Click_continue;	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Conf_msg;	
	
	public HomePage SetUpNewReg(String fname, String Lname, String Email, String Psw) throws InterruptedException
	{
		act.TextSend(First_name, fname);
		act.TextSend(Last_Name, Lname);
		act.TextSend(Email_Fild, Email);
		act.TextSend(Password_fild,Psw );
		act.JavascriptExe(driver, CheckBox);
		
		act.JavascriptExe(driver, Click_continue);
		//act.Click(driver, Click_continue);
		
		return new HomePage(driver);
		
	}
	
	public String Get_Confration_msg()
	{
		return act.GetText(driver, Conf_msg);
			
	}
			


	public void ClickOn_Continue()
	{
		Click_continue.click();
			
	}
			
	
		

}
