Feature: Login with Valid Credentials

 @sanity
  Scenario: User Successfully Login with valid creational to application
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "admin@gmail.com" and Password as "Kiran$178"
    And Click on Login button
    Then User navigates to MyAccount Page

   
   
  Scenario: New customer Registeration by following details
  When User is on Registration page
  And User as to fill the below details 
	  | New User Registration|
    | FirstName|
    | LastName |
    | Admin@gmail.com|
    | Admin4123|
  Then user navigate to HomePage 
  
  
  
  Scenario: User search the product
  When User on IndexPage 
  And User Enter the product name in the searchbox
  And User navigate to product search page 
  And User should see and verify the same product
  And User should add the Same Product to WishList
  When User see the confirmation message as You must login or create an account to save HTC Touch HD to your wish list! 
  Then User should navigate to wishlist page after user login is sueccssful 
  

  Scenario: User should able to Add the same product to Cart 
  When User is on Wishlist page verify the same product 
  And User able to add the same product to cart 
  And User should see the alert message as Success: You have added HTC Touch HD to your shopping cart!
  Then User should navigate to shoping cart page
  
  
  
  Scenario: User performe the checkout for added product 
  When User is on shoping cart page 
  And User is able to performe add or clear the qty in scearh box
  And User is check the unit price and subtotal price 
  And User should verify the added product and price should be matched 
  And User click on check out button 
  Then user should navigate to checkout page 
  
 
  Scenario: User sueccessfully performe the product checkout 
  When User is on checkout page 
  And User is verify redio button for adress both should be working fine 
  And User enters the following address details with coloumns
  	| First Name | Last Name | Company Name | Address 1     | Address 2 | City      | Postcode |
		| Kiran k    | kpk       | micro        | kumbar galii  | bengaluru | bengalru  | 5600011  | 

  And click on countinue  
  And User verify the product qty and price of the product
  And product price should be same accourding to added product
  Then Click in confirm the order
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  