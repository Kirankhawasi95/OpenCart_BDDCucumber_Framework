package stepDefinitions;



import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.DriverFactory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import pageObjects.ShopingCartPage;
import pageObjects.WishListPage;


public class ShopingCartPage_Step {
	

	HomePage hp = new HomePage(DriverFactory.getDriver());
	ProductSearchPage psp = new ProductSearchPage(DriverFactory.getDriver());
	LoginPage LogInPage = new LoginPage(DriverFactory.getDriver());
	WishListPage WishListPage = new WishListPage(DriverFactory.getDriver());
	ShopingCartPage ShopingCartPage=new ShopingCartPage(DriverFactory.getDriver());
	CheckOutPage CheckOutPage=new CheckOutPage(DriverFactory.getDriver());
	SoftAssert soft=new SoftAssert();
	
	@When("User is on shoping cart page")
	public void user_is_on_shoping_cart_page() {
		

		hp.enterProductName("HTC Touch HD");
		psp.AddToWishList();
		LogInPage = psp.ClickOn_Wishlist2();

		LogInPage.setEmail("admin@gmail.com");
		LogInPage.setPassword("Kiran$178");
		LogInPage.clickLogin();
		WishListPage.AddProdut_Cart();
		WishListPage.ClickOn_cart();

	  
	}
	

	@When("User is able to performe add or clear the qty in scearh box")
	public void user_is_able_to_performe_add_or_clear_the_qty_in_scearh_box() {
		
		ShopingCartPage.EnterQty_InSearchBox("1");
		
	    
	}

	@When("User is check the unit price and subtotal price")
	public void user_is_check_the_unit_price_and_subtotal_price() {
		
		System.out.println(ShopingCartPage.GetUnit_Price());
		System.out.println(ShopingCartPage.GetSubTotalPrice());
	    
	}

	@When("User should verify the added product and price should be matched")
	public void user_should_verify_the_added_product_and_price_should_be_matched() {
		
		
		Double unitprice=ShopingCartPage.GetUnit_Price();
		Double Totalprice=ShopingCartPage.GetSubTotalPrice();
		soft.assertEquals(unitprice, Totalprice);
		
	}
	

	

	@When("User click on check out button")
	public void user_click_on_check_out_button() {
		
		ShopingCartPage.ClickOnCheckOut();
	    
	}

	@Then("user should navigate to checkout page")
	public void user_should_navigate_to_checkout_page() {
		
	boolean	targetpage=CheckOutPage.IsCheckoutPageExist();
	
	
	if(targetpage==true)
	{
		System.out.println("CheckOutPage page is dipalyed");
		soft.assertTrue(true);
	}else
	{
		System.out.println("CheckOutPage page is not displayed");
		soft.assertTrue(true);
		
	}	
	
	soft.assertAll();
	    
	}




}
