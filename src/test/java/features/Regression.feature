Feature: These feature is to validate the regression test cases
  Scenario: Regression for login page
    Given Launch a browser
    When Login page is displayed
    Then validate the Login page functionalities

  Scenario: Regression for On-Demand Platform page
    Given admin user navigates to On Demand platform page
    When Platform page is displayed
    Then validate ADD PLATFORM button functionality
    And validate Search by platform/region
    Then get list of platforms added
    And validate the no of platforms matching to the list of platforms