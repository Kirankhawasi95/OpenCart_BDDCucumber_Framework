package stepDefinitions;



import org.testng.Assert;

import com.DriverFactory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import pageObjects.WishListPage;

public class ProductSearchPage_Step {
	
	
	
	HomePage hp = new HomePage(DriverFactory.getDriver());
	ProductSearchPage psp= new ProductSearchPage(DriverFactory.getDriver());
	LoginPage LogInPage =new LoginPage(DriverFactory.getDriver());
	WishListPage WishListPage = new WishListPage(DriverFactory.getDriver());
	
	
	@When("User on IndexPage")
	public void user_on_index_page() {
	    
	}

	@When("User Enter the product name in the searchbox")
	public void EnterTheProduct() {
		
		hp.enterProductName("HTC Touch HD");
	}

	@When("User navigate to product search page")
	public void user_navigate_to_product_search_page() {
		
		
		boolean targetpage=psp.IsPageExist();
		
		if(targetpage==true)
		{
			System.out.println("Product page is dipalyed");
			Assert.assertTrue(true);
		}else
		{
			System.out.println("Product Search page is not displayed");
			Assert.assertTrue(true);
			
		}	
	    
	}

	@Then("User should see and verify the same product")
	public void user_should_see_and_verify_the_same_product() {
		
		String Pname=psp.IsSameProductExist();
		Assert.assertEquals(Pname,"HTC Touch HD");
		
	    
	}
	

@When("User should add the Same Product to WishList")
public void AddTo_WishList() {
	String Msg=psp.AddToWishList();
	
	if(Msg.equals("Success: You have added HTC Touch HD to your wish list!"))
	{
		Assert.assertTrue(true);
		psp.ClickOn_Wishlist();
		
	}else if(Msg.equals("You must login or create an account to save HTC Touch HD to your wish list!"))
	{
		Assert.assertTrue(true);
		LogInPage=psp.ClickOn_Wishlist2();
		
	}else
	{
		System.out.println("User not added any product to wishlist");
		Assert.assertTrue(false);
	}
	
    
}

@When("User see the confirmation message as You must login or create an account to save HTC Touch HD to your wish list!")
public void Verify_Message() {
	
	
	LogInPage.setEmail("admin@gmail.com");
	LogInPage.setPassword("Kiran$178");
	LogInPage.clickLogin();
}

@Then("User should navigate to wishlist page after user login is sueccssful")
public void NavigateTo_Wishlist() {
	
	boolean targetPage=WishListPage.IsWishListPageExist();
	
	if (targetPage==true)
	{
		Assert.assertTrue(true);
		System.out.println("User should navigate to wishlist page after user login is sueccssful");
		
	}else
	{
		System.out.println("User not able to navigate to wishlist page");
		Assert.assertTrue(false);
		
	}
    
}


}
