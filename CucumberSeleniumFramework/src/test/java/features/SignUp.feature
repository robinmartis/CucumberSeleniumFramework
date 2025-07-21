Feature: Facebook Account Creation

  Scenario: Create a new account
    Given I open the browser
    When I navigate to "https://www.facebook.com"
    And I click on "Create new account"
    And I enter first name "Robin" and last name "Martis"
    And I enter mobile number "9876543210"
    And I enter new password "Test@123"
    Then I should see the Sign Up button
