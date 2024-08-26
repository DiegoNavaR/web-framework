Feature: Remove elements from the shopping cart

  Scenario: Remove all items from the cart
    Given user logs in with username "standard_user" and password "secret_sauce"
    When user adds three products to the cart
    And user removes all items from the cart
    Then the cart is empty