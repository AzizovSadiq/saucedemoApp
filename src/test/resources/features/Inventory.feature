Feature: Inventory
  Background:
    Given User is in saucedemo app
    When User clicks burger menu button
    And Clicks login button in dropdown
    And Fills username input with "bob@example.com"
    And Fills password input  with "10203040"
    And Clicks login button
    Then User should be navigated to homepage

@inventory
  Scenario: Checking entering sauce labs onesie item
    Given User is in sauce demo home page
    When User clicks "Sauce Labs Onesie" item

@description
  Scenario: Product description
    Given User is in sauce demo home page
    When User clicks "Sauce Labs Onesie" item
    Then Product description appears


#@star                 // 3-cu stepde ulduza cliclemir
#    Scenario: Click star button
#    Given User is in saucedemo app
#    When User clicks "Sauce Labs Backpack" item
#    And Click on the product's random star
#    Then Pop-up window appears on the screen


#  Scenario Outline: Click star button
#    Given User is in saucedemo app
#    When User clicks "Sauce Labs Backpack" item
#    And Click on the product's "<random>" star
#    Then Pop-up window appears on the screen
#    Examples:
#      | random |
#      | 1      |
#      | 2      |
#      | 3      |
#      | 4      |
#      | 5      |