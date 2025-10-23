@LoginModule
Feature: Login Module
  To verify that users can log in with valid and invalid credentials.

  @smoke 
  Scenario Outline: Successful login with valid credentials
    Given User is on the login page
    When User enters username "<username>" and password "<password>"
    And User clicks on the login button
    Then User should be redirected to the homepage

    Examples:
      | username   | password     |
      | testuser1  | password123  |
      | testuser2  | password456  |

  @regression 
  Scenario Outline: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters username "<username>" and password "<password>"
    And User clicks on the login button
    Then User should see an error message "<errorMessage>"

    Examples:
      | username    | password    | errorMessage                        |
      | wronguser1  | wrongpass1  | Invalid username or password        |
      | wronguser2  | wrongpass2  | Invalid username or password        |
