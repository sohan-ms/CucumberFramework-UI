Feature: Content Owner Logging into Amagi Now application

  Scenario: Login to Amagi Now with valid credentials
    Given User in login page
    When User provides the "Email" "DomainName" "Password"
    Then Home page should be displayed
    And User click on Logout button
    Then Login page should be displayed
