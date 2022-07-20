@Login
Feature: User can login to user dashboard

  Background: redirect to login page from homepage
    Given homepage is displayed
    When click to login header link
    Then login page is displayed

  @LoginWithWrongEmail
  Scenario Outline: Login with wrong email
    When enter email = "<email>"
    And enter password = "<password>"
    And click to login button
    Then error message "Wrong credentials. try again!" is displayed
    Examples:
      | email                | password  |
      | admin@phptravels.net | demoadmin |
      | admin@phptravels     | demoadmin |

  @LoginWithWrongPassword
  Scenario: Login with wrong password
    When enter credentials
      | email                | password |
      | admin@phptravels.com | demouser |
    And click to login button
    Then error message "Wrong credentials. try again!" is displayed

  @LoginWithValidCredentials
  Scenario: Login with valid credentials
    When enter credentials
      | email               | password |
      | user@phptravels.com | demouser |
    And click to login button
    Then redirect to Dashboard page

