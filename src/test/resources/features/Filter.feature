@filter
Feature: Filter

  Scenario: Filter button activity check
    Given User is in saucedemo app
    When User clicks filter button
    Then Filter menu appears on the screen


  Scenario: Checking for sequential alignment
    Given User is in saucedemo app
    When User clicks filter button
    And User clicks "<nameAscending>" button
    Then Product "<line>" matches the filter
