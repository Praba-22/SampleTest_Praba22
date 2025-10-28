
Feature: Login Module
  To verify that users can log in with valid and invalid credentials.

  @smoke 
  Scenario Outline: Successful login with valid credentials
    Given User is on the login page
    When User enters username "<username>" and password "<password>"
    And User clicks on the login button
    Then User should be redirected to the homepage

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |
      | locked_out_user         | secret_sauce  |
      | problem_user            | secret_sauce  |
      | performance_glitch_user | secret_sauce  |
      | error_user              | secret_sauce  |
      | visual_user             | secret_sauce  |

