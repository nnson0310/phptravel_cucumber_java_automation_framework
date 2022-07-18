Feature: User can login to user dashboard

  Background: Visit user login page
    Given visit to "https://www.phptravels.net/login"

  @loginWithWrongEmail
  Scenario Outline: Login with wrong email
    When enter email with value = "<email>"
    And enter password with value = "<password>"
    And click to login button
    Then verify that error message = "Wrong credentials. try again!" is displayed
    Examples:
      | email                | password  |
      | admin@phptravels.net | demoadmin |
      | admin@phptravels     | demoadmin |

  @loginWithWrongPassword
  Scenario: Login with wrong password
    When enter credentials
      | email                | password  |
      | admin@phptravels.com | demouser  |
    And click to login button
    Then verify that error message = "Wrong credentials. try again!" is displayed

