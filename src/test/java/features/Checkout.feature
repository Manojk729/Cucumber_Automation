Feature: Add to Cart

  Scenario: Verify the user is able to successfully add a product to cart
    Given Open the application
    Then Verify user lands on HomePage
    Then Check if search button is clickable
    When Click on Search button
    Then Text in search bar should be visible
    And  Enter the name of product
    Then Wishlist icon should be visible
    And Scroll to the product
    And Select the product
    And Click on Add to Cart button
    And Select the size of product
    Then Seller text should be visible
    And Click the done button
    Then GO TO BAG button should be visible
    And Click on cart icon
    And Click on place order
    Then Login page should appear