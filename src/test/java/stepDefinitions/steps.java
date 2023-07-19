package stepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.DriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class steps {
     WebDriver driver;

    
     
     HomePage hp=new HomePage(DriverFactory.getDriver());
     LoginPage lp=new LoginPage(DriverFactory.getDriver());
     MyAccountPage macc=new MyAccountPage(DriverFactory.getDriver());
    
     List<HashMap<String, String>> datamap; //Data driven

     public Logger logger; //for logging
     public ResourceBundle rb; // for reading properties file
     public String br; //to store browser name

  
    @When("User navigate to MyAccount menu")
    public void user_navigate_to_my_account() {
    	
    	
    	hp.clickMyAccount();
        //logger.info("Clicked on My Account ");
            
    }

    @When("click on Login")
    public void click_on_login() {
        hp.clickLogin();
        //logger.info("Clicked on Login ");
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
    	
         
    	lp.setEmail(email);
        //logger.info("Provided Email ");
        lp.setPassword(pwd);
        //logger.info("Provided Password ");
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        lp.clickLogin();
       // logger.info("Clicked on Login button");
    }


    @Then("User navigates to MyAccount Page")
    public void user_navigates_to_my_account_page() {
  
		boolean targetpage=macc.isMyAccountPageExists();
	
        if(targetpage)
        {
           
            Assert.assertTrue(true);
        }
        else
        {
           
            Assert.assertTrue(false);
        }

  }

   

   

}
