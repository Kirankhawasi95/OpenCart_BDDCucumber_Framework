package utilities;

import org.testng.ITestResult;

import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntigration {
	
	//TestLinkAPIClient testlink= new TestLinkAPIClient(APIKey,TestLink_URL);
	
	
	
	
	
	public static  final String APIKey="0209c0b7b3dabfeb57b68a69d8411dff";
	public static  final String TestLink_URL="http://127.0.0.1/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static  final String TestPrpjrct_Name="OpenCartDemoProject";
	public static  final String TestPlan_Name="New test plan";
	//public static  final String TestCase_Name="User Successfully Login with valid creational";
	public static  final String Build_Name="Version 3";
	
	//private static final TestLinkManager TestLinkManager=new TestLinkManager();
	
	
	
	TestLinkAPIClient TestLinkAPIClient;
	
	
	 public static void UpdateResult(Scenario scenario,String notes, String status) throws Throwable {
	        // Your code...
		 try {
			    TestLinkAPIClient testlink = new TestLinkAPIClient(APIKey, TestLink_URL);
			    //String description=scenario.getMethod().getDescription();
			    String description=scenario.getName();
			    testlink.reportTestCaseResult(TestPrpjrct_Name, TestPlan_Name, description, Build_Name, notes, status);
			} catch (TestLinkAPIException e) {
			    e.printStackTrace();
			}
	 }


	

}
