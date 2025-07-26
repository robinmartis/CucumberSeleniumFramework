
Feature: Facebook Login


  Background: User is Logged In
    Given test background step1 
    When test background_step2
    
    

  @SmokeTest
  Scenario Outline: Login with valid credentials
    Given I open the browser
    When I navigate to "https://www.facebook.com"
	And I enter username "<userName>" and password "<pass>"
    Then I should see the login button

    Examples:
      | userName        | pass |
      | test1@test.com  | abcd |
      | test2@test.com  | abcd |
      | test3@test.com  | abcd |
		

@RegressionTest
Scenario Outline: Login with valid credentials- 1
    Given I open the browser
    When I navigate to "https://www.facebook.com"
	And I enter user credentials to login 
	|	Robin	|	welcome123 	|
	|	Aden	|	welcome1	|
	|	Deepika	|	welcome2	|
	
    Then I should see the login button
 
 @RegressionTest
 Scenario Outline: Login with valid credentials with datatable- 
    Given I open the browser
    When I navigate to "https://www.facebook.com"
	And I enter user credentials to login using datatable
	|Username	| 	Password	|
	|	Robin	|	welcome123 	|
	|	Aden	|	welcome1	|
	|	Deepika	|	welcome2	|
	
    Then I should see the login button

 @SmokeTest @RegressionTest
   Scenario:check create page is there 
   	Given I open the browser
   	When I navigate to "https://www.facebook.com" 
   	Then I should see the Create a Page link
   	
   	

