@UpdateProfile
Feature: user can update profile

  Background: user already logged in
    Given user already logged in
    When click to MyProfile sidebar link
    Then MyProfile page is displayed

  @UpdateProfileExceptPassword
  Scenario Outline: user updates all profile information except password
    When enter to "firstname" textbox with value = "<firstname>"
    And enter to "lastname" textbox with value = "<lastname>"
    And enter to "phone" textbox with value = "<phone>"
    And enter to "email" textbox with value = "<email>"
    And select country with value = "<country>" in dropdown list
    And enter to "state" textbox with value = "<state>"
    And enter to "city" textbox with value = "<city>"
    And enter to "fax" textbox with value = "<fax>"
    And enter to "zip" textbox with value = "<zip>"
    And enter to "address1" textbox with value = "<address1>"
    And enter to "address2" textbox with value = "<address2>"
    And click to UpdateProfile button
    Then 'Profile updated successfully.' message is displayed

    Examples:
      | firstname | lastname | phone       | email               | country  | state      | city     | fax       | zip    | address1          | address2   |
      | thu       | minh     | 09887654321 | user@phptravels.com | Cambodia | California | New York | 110999900 | 100600 | 12 Ho Binh street | 18 Jamaica |