Feature: Facebook Login

  Scenario: Login with valid credentials
    Given I open the browser
    When I navigate to "https://www.facebook.com"
    And I enter username "test@test.com" and password "abcd"
    Then I should see the login button
