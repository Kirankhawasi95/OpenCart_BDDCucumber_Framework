package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.DriverFactory.DriverFactory;

import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginPageDDT_Step {
	
	HomePage hp=new HomePage(DriverFactory.getDriver());
    LoginPage lp=new LoginPage(DriverFactory.getDriver());
    MyAccountPage macc=new MyAccountPage(DriverFactory.getDriver());
   
    List<HashMap<String, String>> datamap; //Data driven
	
    

    //*******   Data Driven test method for LoginPage    **************
    
    
	 @Then("check User navigates to MyAccount Page by passing Email and Password with excel row {string}")
	    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
	    {
	        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

	        int index=Integer.parseInt(rows)-1;
	        String email= datamap.get(index).get("username");
	        String pwd= datamap.get(index).get("password");
	        String exp_res= datamap.get(index).get("res");

	        lp=new LoginPage(DriverFactory.getDriver());
	        lp.setEmail(email);
	        lp.setPassword(pwd);

	        lp.clickLogin();
	        try
	        {
	            boolean targetpage=macc.isMyAccountPageExists();

	            if(exp_res.equals("Valid"))
	            {
	                if(targetpage==true)
	                {
	                    MyAccountPage myaccpage=new MyAccountPage(DriverFactory.getDriver());
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(exp_res.equals("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    macc.clickLogout();
	                    Assert.assertTrue(false);
	                }
	                else
	                {
	                    Assert.assertTrue(true);
	                }
	            }


	        }
	        catch(Exception e)
	        {

	            Assert.assertTrue(false);
	        }
	        DriverFactory.getDriver().close();
	    }

	    //*******   Account Registration Methods    **************
	//*******   User Address Methods    **************

}
