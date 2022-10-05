@buyOrder
Feature: Buy Order Functionality

  Background:
    Given the user is on home page of the website

  Scenario Outline:
    When User clicks sign in button
    Then User enters username "<username>" and password "<password>" and click login
    Then Move your cursor over women's link
    Then Click on sub menu T-shirts
    Then Mouse hover on the first product displayed
    Then More button will be displayed click on More button
    Then Increase quantity to two select size L select color
    Then Click add to cart
    Then Click procees to checkout
    Then Complete the buy order process till payment
    Then Make sure that Product is ordered

    Examples:
      | username               | password      |
      | moussaraouf@outlook.fr | Selenium12345 |
