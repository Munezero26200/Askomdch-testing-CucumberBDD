@cart @store
Feature: Cart functionality

  As a customer
  I want to add  products to cart
  so that I can purchase them later

  Background:
    Given I'm on the store page

  @positive
  Scenario: Customer add one quantity from Store
    When I add a Blue Shoes in the cart
    Then I should see 1 Blue Shoes in the cart






