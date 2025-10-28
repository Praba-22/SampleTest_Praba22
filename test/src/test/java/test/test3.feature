
Feature: Account Creation functionality

  @Test 
  Scenario Outline: Verify user can create a new account with valid details
    Given User is on the registration page
    When User enters first name "<firstname>"
    And User enters last name "<lastname>"
    And User enters email "<email>"
    And User enters password "<password>"
    And User clicks on the Create Account button
    Then A success message "Account created successfully" should be displayed
    And User should be redirected to the login page

    Examples:
      | firstname | lastname | email                  | password     |
      | John      | Doe      | john.doe@testmail.com  | John@12345   |
      | Priya     | Sharma   | priya.sharma@test.com  | Priya@123    |
      | Alex      | Mathew   | alex.mathew@test.com   | Alex@32145   |
