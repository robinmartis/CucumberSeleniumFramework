Feature: Facebook Password Reset

  Scenario: Reset account password
    Given I open the browser
    When I navigate to "https://www.facebook.com"
    And I click on "Forgotten password?"
    Then I should see the "Find Your Account" page
