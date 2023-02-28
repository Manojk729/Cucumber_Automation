Feature: Myntra
  Scenario: Verify checkout functionality
    Given Open the application
    Then Check if search button clickable
    When Click on Search Button
    Then Text in search bar should be visible
    And  Enter the name of Product
    Then Wishlist icon should be visible
    And Scroll to the Product
    And Select the Product
    And Click on Add to Cart Button
    And Select the size of product
    Then seller text should be visible
    And Click the done button
    Then GO TO BAG button should be visible
    And Click on cart icon
    And Click on place order
    Then Login page should appear