package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class WishListPage extends BasePage {

	public WishListPage(WebDriver driver) {
		super(driver);
		
	}
	

	
	
	@FindBy (xpath="(//table[@class='table table-bordered table-hover']//td[2])[2]")
	WebElement ProductResult;
	
	@FindBy (xpath="(//td[@class='text-end']//form[@method='post']//i)[1]")
	WebElement AddToCart;
	
	@FindBy (xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement GetMsg;
	
	@FindBy (xpath="(//i[@class=\"fas fa-shopping-cart\"])[1]")
	WebElement Gotocart;
	
	@FindBy (xpath="//h1[normalize-space()='My Wishlist']")
	WebElement page;
	
	
//--------------------------------------------------->>	
//	@FindBy (xpath="//div[@class='table-responsive']//tr[1]//td[2]")
//	List<WebElement> ProductResult;
//	
	
	//need to check
//	@FindBy (xpath="//div[@class='table-responsive']//tbody//td")
//	List<WebElement> WishList;
	
//------------------------------------------------------>
	public boolean IsWishListPageExist () 
	{
		return page.isDisplayed();
		
	}

	
	
	public String VerifySameProduct()
	{
		  String Result=ProductResult.getText();
		  //System.out.println("the added product is matched and product Name is:"+Result);
		
		  return Result;	  
	}
	 
	
	
	public void AddProdut_Cart()
	{
		  act.Click(driver, AddToCart);
		
	}
	
	
	public String verifyCartMsg () 
	{
		String CartConfiromationMsg=act.GetText(driver, GetMsg); 
		act.JavascriptExe(driver, Gotocart);		
		return CartConfiromationMsg;	
	}
	
	
	
	public ShopingCartPage ClickOn_cart () 
	{
		
		act.JavascriptExe(driver, Gotocart);		
		return new ShopingCartPage(driver);
	}


		
}	

//------------------------------------------------------>>>
//need to check
//public boolean VerifySameProduct()
//{
//	
//	boolean flag=false;
//	for(WebElement details:WishList)
//	{
//		String det1=details.getText();
//		//System.out.println(det1);
//		
//		
//	if(det1.equals("iPhone") && det1.equals("product 11"))
//		//if(det1.equals("iPhone"))
//		{
//			String det2=details.getText();
//			System.out.println(det2);
//			
//			flag=true;
//				
//			
//			
//	}
//	}
//		if(flag)
//		{
//			System.out.println("Product is matched");
//			
//		
//		}else
//		{
//			System.out.println("Product is not matched");
//		}
//		
//	
//		
//	
//	return flag;
//	


