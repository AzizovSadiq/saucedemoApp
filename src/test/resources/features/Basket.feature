@basket
Feature: Basket

  Scenario: Empty basket button is active
    Given User is in saucedemo app
    When User click the basket button
    Then "Go Shopping" button appears

@addtocart
  Scenario: Adding the product to the basket
    Given User is in saucedemo app
    When Click to random product
    And Click "Add To Cart" button
    And User click the basket button
    Then Product is in the basket page

@removeElement
  Scenario: Remove product basket page
    Given User is in saucedemo app
    When Click to random product
    And Click "Add To Cart" button
    And User click the basket button
    And Remove element basket page
    Then Item has been removed from the cart page

@priceEquals
  Scenario: Order price check
    Given User is in saucedemo app
    When Click to random product
    And Click "Add To Cart" button
    And User click the basket button
    Then One order price is equal to the total price

@twoProduct
  Scenario: Add two products to cart
    Given User is in saucedemo app
    When Click to random product
    And Add two products to cart
    And Click "Add To Cart" button
    And User click the basket button
    Then Price of two orders is equal to the total price
