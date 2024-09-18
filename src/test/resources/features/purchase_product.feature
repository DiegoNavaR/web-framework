@Purchase @Regression @Functional
Feature: Purchase a product

  Scenario: Purchase a single product
    Given user logs in with username "standard_user" and password "secret_sauce"
    When user adds a random product to the cart
    And user proceeds to checkout
    And user enters personal details and continues
    And user finishes the checkout process
    Then the order is completed successfully