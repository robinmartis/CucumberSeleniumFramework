Feature: Facebook Login

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
		


Scenario Outline: Login with valid credentials- 1
    Given I open the browser
    When I navigate to "https://www.facebook.com"
	And I enter username "Robin" and password "welcome123"
    Then I should see the login button
    
   Scenario:check create page is there 
   	Given I open the browser
   	When I navigate to "https://www.facebook.com" 
   	Then I should see the Create a Page link
   	
