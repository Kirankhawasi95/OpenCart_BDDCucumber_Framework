package stepDefinitions;

import java.util.List;
import java.util.Map;

import com.DriverFactory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.NewAccountReg_Page;

public class RegistrationPage_Step {
	
	  HomePage hp=new HomePage(DriverFactory.getDriver());
	  LoginPage lp=new LoginPage(DriverFactory.getDriver());
	  MyAccountPage macc=new MyAccountPage(DriverFactory.getDriver());
	  NewAccountReg_Page NewAccountReg_Page=new NewAccountReg_Page(DriverFactory.getDriver());
	  
	
		  
	     
	  @When("User is on Registration page")
	    public void user_navigate_to_my_account() {
	    	
	    	
	    	hp.clickMyAccount();
	    	hp.clickRegister();
	       
	            
	    }

	   

	  @When("User as to fill the below details")
	  public void user_as_to_fill_the_below_details(DataTable dataTable) throws Throwable {
		  
	  List<Map<String, String>> listdata= dataTable.asMaps();
		  
		//List<Map<String,String>>  listdata=dataTable.asMaps();
	  
	  String  firstname  = listdata.get(0).get("New User Registration");
	  String Lastname = listdata.get(1).get("New User Registration");
	  String Email = listdata.get(2).get("New User Registration");
	  String psw = listdata.get(3).get("New User Registration");
		  
		  
	 
		 
		 NewAccountReg_Page.SetUpNewReg(firstname, Lastname, Email, psw);
		 
	      
	  }

	  @Then("user navigate to HomePage")
	  public void user_navigate_to_home_page() {
		  NewAccountReg_Page.ClickOn_Continue();
	  }

	  
	

}
