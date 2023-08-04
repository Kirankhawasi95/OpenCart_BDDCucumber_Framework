package ApplicationHooks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.DriverFactory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testlink.api.java.client.TestLinkAPIClient;
import utilities.ConfigReader;
import utilities.TestLinkIntigration;

public class Hooks {
	
	private  DriverFactory driverFactory;
	private  WebDriver driver;
	private ConfigReader configReader;
	static Properties prop;
	public TestLinkIntigration TestLinkIntigration;
	
	

	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	
	@Before(order = 1)
	public  void launchBrowser() {
		
		//String browserName = prop.getProperty("browser");
		
		driverFactory = new DriverFactory();
		
		String browserName =ConfigReader.GetBroserType();
		driver = DriverFactory.init_driver(browserName);
		
	}

	@After(order = 0)
	public  void quitBrowser() {
		driver.quit();
	}
	
	

	@After(order = 1)
	public  void tearDown(Scenario scenario) {
		
		//String TimeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		 System.out.println("scenario Name is===>" +"  " + scenario.getName()+ "  "+ "And Scenario status is ======>"+scenario.getStatus());
		 
		 

			try {
				TestLinkIntigration.UpdateResult(scenario, "This test case is Executed through automation scripts and test case is passed", TestLinkAPIClient.TEST_PASSED);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		if (scenario.isFailed()) {
			
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", scenario.getName());
			
			try {
				scenario.attach(sourcePath, "http://localhost:8089/job/OpenCart_BDDCucumber_Framework/ws/ScreenShots/" + "image/png", scenario.getName());
			} catch (Exception e) {
				e.getMessage();
			}
			
			// This new path for jenkins
			String newImageString = "http://localhost:8089/job/OpenCart_BDDCucumber_Framework/ws/ScreenShots/embedded1" + "image/png";
			//return newImageString;
			
			
			try {
				TestLinkIntigration.UpdateResult(scenario, "This test case is Executed through automation scripts and test case is Failed", TestLinkAPIClient.TEST_FAILED);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		}
		driver.quit();
	}

}
