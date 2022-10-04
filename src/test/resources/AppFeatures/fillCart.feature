Feature: Fill Cart Feature
  Background:
    Given user has already logged in to application
      | username               | password      |
      | moussaraouf@outlook.fr | Selenium12345 |
  @search
  Scenario: Search for a product.
    Given user is on home page
    When user fills search input with "Casual Dresses"
    Then page title should be "Search - My Store"
  @search
  Scenario: Adding one item to Cart
    Given user is on Search page
    And products are displayed
    And displayed products count 4
    When user adds product to cart
    And clicks the proceed to checkout button
    Then page title should be "Order - My Store"