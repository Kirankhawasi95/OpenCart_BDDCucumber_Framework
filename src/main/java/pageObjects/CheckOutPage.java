/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * @author kpkmt942
 *
 */
public class CheckOutPage extends BasePage{

	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//input[@id='input-shipping-existing']")
	WebElement RedioBtn1;
	
	@FindBy (xpath="//input[@id='input-shipping-new']")
	WebElement RedioBtn2;
	
	@FindBy(id="input-shipping-firstname")
	WebElement First_name;
	
	@FindBy(id="input-shipping-lastname")
	WebElement Last_Name;
	
	@FindBy(id="input-shipping-company")
	WebElement CompanyName;
	
	@FindBy(id="input-shipping-address-1")
	WebElement Address1;
	
	@FindBy(id="input-shipping-address-2")
	WebElement Address2;
	
	@FindBy(id="input-shipping-city")
	WebElement City;
	
	@FindBy(id="input-shipping-postcode")
	WebElement Postel;
	
	@FindBy(id="input-shipping-country")
	WebElement Countray;
	
	@FindBy(id="input-shipping-zone")
	WebElement State;
	
	@FindBy(id="button-shipping-address")
	WebElement Countinue;
	
	@FindBy(xpath="//div[@class=\"table-responsive\"]//tbody//tr//td")
	WebElement ProductQty;
	

	@FindBy(xpath="(//div[@class=\"table-responsive\"]//tfoot//td)[4]")
	WebElement ProductTotal;
	

	@FindBy(xpath="//h1[normalize-space()='Checkout']")
	WebElement CheckoutPage;
	
	
	
	public boolean IsCheckoutPageExist()
	{
		
		return CheckoutPage.isDisplayed();
	}
	
	public void CheckRedioBtn1()
	{
		System.out.println(RedioBtn1.isEnabled());
		RedioBtn2.click();	
		
	}
	
	
	
	public void SetAddress(String fname, String lname, String Cname, String add1, String add2)
	{
		act.TextSend(First_name, fname);
		act.TextSend(Last_Name, lname);
		act.TextSend(CompanyName, Cname);
		act.TextSend(Address1, add1);
		act.TextSend(Address2, add2);	
	}
	
	public void SetAddress2(String city, String pcode, int country, int state)
	{
		act.TextSend(City, city);
		act.TextSend(Postel, pcode);
		act.SelectByIndex(Countray, country);
		act.SelectByIndex(State, state);
		act.JavascriptExe(driver, Countinue);
	
	}
	
	public int GetfinalproductQty()
	{
		String qty=ProductQty.getText();
//		
		String totalproduct=qty.split("x")[0].trim();
		
		//String EmtyCht=qty.replaceAll("[^a-zA-Z0-9]", "");
		int ItemQty=Integer.parseInt(totalproduct);
		System.out.println("final added product qty is:"+ItemQty);
		return ItemQty;
		
	}
	
		public double GetPriceQty()
		{
			
		String qtyPrice=ProductTotal.getText();
		String EmtyCht2=qtyPrice.replaceAll("[^a-zA-Z0-9]", "");
		double ItemPrice=Double.parseDouble(EmtyCht2);
		System.out.println("final added product price:"+ItemPrice);
		return ItemPrice;
	
	}
	

//------------------------------------------------------------->>
		 			//Need to check
//		String qty=ProductQty.getText();
//		String EmtyCht=qty.replaceAll("[^a-zA-Z0-9]", "");
//		double qty2=Double.parseDouble(EmtyCht);
//		System.out.println("final added product qty is:"+qty2);
//		
//		String qtyPrice=ProductTotal.getText();
//		String EmtyCht=qtyPrice.replaceAll("[^a-zA-Z0-9]", "");
//		Integer qtyPrice2=Integer.parseInt(EmtyCht);
//		System.out.println("final added product price:"+qtyPrice2);

//------------------------------------------------------------->>
		
}
		
		
		
		
		
		

