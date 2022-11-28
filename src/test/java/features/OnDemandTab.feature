
Feature: Content owner navigating to the On Demand-Platform page
  Scenario: Login as a content Partner
    Given User will log in to amagi now
    And click on On Demand-platform page
    Then validate the platform page

  Scenario: Get the assets from the Media Library - content tab
    Given User will log in to amagi now
    And navigate to the Media Library - content tab
    Then collect the assets list
