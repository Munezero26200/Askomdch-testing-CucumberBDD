Feature: Place an order

  As a customer
  I want to place an order
  So that I can purchase products with different payment methods

  Background:
    Given I'm a guest customer
    And  I have a product in the cart
    And I'm on the checkout page

  @smoke @order
  Scenario: Customer using default payment option
    When I provide billing details
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
      | user1     | tester   | United States (US) | 6300 Spring Creek | plano | Texas | 75024 | askomdch@gmail.com |
    And I place an order
    Then the order should be placed successfully

  @smoke @order @cod
  Scenario: Customer using Cash on delivery payment option
    When I provide billing details
      | firstname | lastname | country            | address_line1  | city   | state | zip   | email              |
      | user2     | buyer    | United States (US) | 123 Elm Street | dallas | Texas | 75024 | codeTest@gmail.com |
    And I select "Cash on delivery" as payment method
    And I place an order
    Then the order should be placed successfully

  @negative @order @cod
  Scenario Outline: Customer fails to place order with missing billing details
    When I provide "<firstname>", "<lastname>", "<country>", "<address_line1>", "<city>", "<state>", "<zip>", "<email>" as billing details
    And I place an order
    Then I should see an error message "<expectedErrorMsg>"

    Examples:
      | firstname | lastname | country            | address_line1  | city   | state | zip   | email              | expectedErrorMsg                            |
      | user2     |          | United States (US) | 123 Elm Street | dallas | Texas | 75024 | codeTest@gmail.com | Billing Last name is a required field.      |
      |           | buyer    | United States (US) | 123 Elm Street | dallas | Texas | 75024 | codeTest@gmail.com | Billing First name is a required field.     |
      | user2     | buyer    | United States (US) |                | dallas | Texas | 75024 | codeTest@gmail.com | Billing Street address is a required field. |
      | user2     | buyer    | United States (US) | 123 Elm Street |        | Texas | 75024 | codeTest@gmail.com | Billing Town / City is a required field.    |
      | user2     | buyer    | United States (US) | 123 Elm Street | dallas | Texas |       | codeTest@gmail.com | Billing ZIP Code is a required field.       |
      | user2     | buyer    | United States (US) | 123 Elm Street | dallas | Texas | 75024 |                    | Billing Email address is a required field.  |




