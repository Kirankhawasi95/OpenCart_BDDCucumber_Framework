/**
 * 
 */
package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author kpkmt942
 *
 */
public class ShopingCartPage extends BasePage{

	
	public ShopingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="(//td[@class=\"text-start\"]//input)[1]")
	WebElement Quantity;
	
	@FindBy (xpath="(//table[@class='table table-bordered']//tr)[2]//td[5]")
	WebElement UnitPrice;
	
	@FindBy (xpath="//main//tr[2]//td[2]")
	WebElement SubTotalPrice;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	WebElement CheckOut;
	
	
	public void  EnterQty_InSearchBox(String Qty)
	{
		//Quantity.sendKeys(Qty,Keys.ENTER);
		Quantity.clear();
		//act.TextSend(Quantity, Qty);
		
		Quantity.sendKeys(Qty,Keys.ENTER);
		
	}
	
	public double GetUnit_Price()
	{
		
		//act.Click(driver, Quantity);
		String RemDol=UnitPrice.getText();
		String EmtyCht=RemDol.replaceAll("[^a-zA-Z0-9]", "");
		double IndianRupi=Double.parseDouble(EmtyCht);
		return IndianRupi/100;		
	}
	
	public double GetSubTotalPrice()
	{
		
		String RemDol=SubTotalPrice.getText();
		String EmtyCht=RemDol.replaceAll("[^a-zA-Z0-9]", "");
		double IndianRupi=Double.parseDouble(EmtyCht);
		return IndianRupi/100;		
	}
	
	public CheckOutPage ClickOnCheckOut()
	{
		act.JavascriptExe(driver, CheckOut);
		return new CheckOutPage(driver);
	}

}


