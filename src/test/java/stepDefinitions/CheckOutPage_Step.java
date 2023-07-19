package stepDefinitions;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.DriverFactory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import pageObjects.ShopingCartPage;
import pageObjects.WishListPage;

public class CheckOutPage_Step {
	
	public WebDriver driver;
	HomePage hp = new HomePage(DriverFactory.getDriver());
	ProductSearchPage psp = new ProductSearchPage(DriverFactory.getDriver());
	LoginPage LogInPage = new LoginPage(DriverFactory.getDriver());
	WishListPage WishListPage = new WishListPage(DriverFactory.getDriver());
	ShopingCartPage ShopingCartPage=new ShopingCartPage(DriverFactory.getDriver());
	CheckOutPage CheckOutPage=new CheckOutPage(DriverFactory.getDriver());
	
	@When("User is on checkout page")
	public void user_is_on_checkout_page() {
		
		hp.enterProductName("HTC Touch HD");
		psp.AddToWishList();
		LogInPage = psp.ClickOn_Wishlist2();

		LogInPage.setEmail("admin@gmail.com");
		LogInPage.setPassword("Kiran$178");
		LogInPage.clickLogin();
		WishListPage.AddProdut_Cart();
		WishListPage.ClickOn_cart();
		ShopingCartPage.EnterQty_InSearchBox("1");
		ShopingCartPage.ClickOnCheckOut();
	
		//driver.get("http://localhost/opencart/upload/index.php?route=checkout/checkout&language=en-gb");
	    
	}

	@When("User is verify redio button for adress both should be working fine")
	public void user_is_verify_redio_button_for_adress_both_should_be_working_fine() {
		
		CheckOutPage.CheckRedioBtn1();
	    
	}

	@When("User enters the following address details with coloumns")
	public void user_enters_the_following_address_details_with_coloumns(DataTable dataTable) {
	  
		
		List<Map<String, String>>  AddressList=dataTable.asMaps(String.class, String.class);
		
		System.out.println(AddressList);
		String fname=AddressList.get(0).get("First Name");
		String lname=AddressList.get(0).get("Last Name");
		String companay=AddressList.get(0).get("Company Name");
		String address1=AddressList.get(0).get("Address 1");
		
		String address2=AddressList.get(0).get("Address 2");
		String City=AddressList.get(0).get("City");
		String postcode=AddressList.get(0).get("Postcode");
//		String country=AddressList.get(6).get("Country");
//		String state=AddressList.get(7).get("State");
		
		
		CheckOutPage.SetAddress(fname, lname, companay, address1, address2);
		CheckOutPage.SetAddress2(City, postcode, 2, 2);
		
	}

	@When("click on countinue")
	public void click_on_countinue() {
		
		
	  
	}

	@When("User verify the product qty and price of the product")
	public void user_verify_the_product_qty_and_price_of_the_product() {
	  
		int ItemQty=CheckOutPage.GetfinalproductQty();
		double ItemPrice=CheckOutPage.GetPriceQty();
		
		if(ItemQty==0)
		{
			System.out.println("there is product is added");
			
		}else if(ItemQty * 10000 ==ItemPrice)
		{
			Assert.assertTrue(true);
			System.out.println("productqty item is matched with the price Qty");
			
		}else
		{
			
			System.out.println("productqty item is not matched with the price Qty");
			
			Assert.assertTrue(false);
		}
			
		
	}

	@When("product price should be same accourding to added product")
	public void product_price_should_be_same_accourding_to_added_product() {
		
		
		
	 
	}

	@Then("Click in confirm the order")
	public void click_in_confirm_the_order() {
	    
	}

}
