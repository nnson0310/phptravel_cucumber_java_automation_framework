@SignUp
Feature: user can sign up

  @SignUpAndLoginWithValidCredentials
  Scenario Outline: sign up with all valid credentials then login
    Given SignUp page is displayed
    When sign up new first name = "<first_name>"
    And sign up new last name = "<last_name>"
    And sign up new phone = "<phone>"
    And signup new email
    And signup new password = "<password>"
    And select account type = "<account_type>"
    And click to SignUp button
    And success message "Signup successfull please login." is displayed
    And login page is displayed
    And enter registered credentials
    And click to login button
    Then redirect to Dashboard page

    Examples:
      | first_name | last_name | phone      | password | account_type |
      | minh       | thu       | 0988776643 | 123456   | Supplier     |
