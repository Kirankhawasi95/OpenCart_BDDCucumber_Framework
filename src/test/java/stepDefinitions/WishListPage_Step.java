package stepDefinitions;

import org.testng.Assert;

import com.DriverFactory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductSearchPage;
import pageObjects.WishListPage;

public class WishListPage_Step {

	HomePage hp = new HomePage(DriverFactory.getDriver());
	ProductSearchPage psp = new ProductSearchPage(DriverFactory.getDriver());
	LoginPage LogInPage = new LoginPage(DriverFactory.getDriver());
	WishListPage WishListPage = new WishListPage(DriverFactory.getDriver());

	@When("User is on Wishlist page verify the same product")
	public void VerifyThe_Producto() {

		hp.enterProductName("HTC Touch HD");
		psp.AddToWishList();
		LogInPage = psp.ClickOn_Wishlist2();

		LogInPage.setEmail("admin@gmail.com");
		LogInPage.setPassword("Kiran$178");
		LogInPage.clickLogin();

		String Pname = WishListPage.VerifySameProduct();

		if (Pname.equals("HTC Touch HD")) {
			Assert.assertTrue(true);
			System.out.println("The same product is added now user can the add the product to cart");

		} else {
			System.out.println("===>Product ia not matched user as to check the wishlist<===");
			Assert.assertTrue(false);

		}

	}

	@When("User able to add the same product to cart")
	public void user_able_to_add_the_same_product_to_cart() {

		WishListPage.AddProdut_Cart();

	}

	@When("User should see the alert message as Success: You have added HTC Touch HD to your shopping cart!")
	public void VerifyThe_AlertMessage() {

		String msg = WishListPage.verifyCartMsg();

		if (msg.equals("Success: You have added HTC Touch HD to your shopping cart!")) {
			Assert.assertTrue(true);
			System.out.println("User sueccssfully added product to cart");

		} else {
			Assert.assertTrue(false);
			System.out.println("Product ia not added to cart");

		}

	}

	@Then("User should navigate to shoping cart page")
	public void user_should_navigate_to_shoping_cart_page() {

		WishListPage.ClickOn_cart();

	}

}
