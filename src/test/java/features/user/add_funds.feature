@AddFunds
Feature: user can add funds

  Background: AddFunds page is displayed
    When click to AddFunds sidebar link
    Then AddFunds page is displayed

  Scenario: user can add payment method with Paypal
    When click to Pay With Paypal checkbox
    And click to Pay Now button
    And redirect to payment page
    And click to Paypal button
    And switch to paypal popup window
