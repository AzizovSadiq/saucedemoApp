@login
Feature: Login
    Scenario Outline: Successfull login to the sauce demo
      Given User is in saucedemo app
      When User clicks burger menu button
      And Clicks login button in dropdown
      And Fills username input with "<username>"
      And Fills password input  with "<password>"
      And Clicks login button
      Then User should be navigated to homepage
      Examples:
        | username        | password |
        | bob@example.com | 10203040 |

    @unsuccessfull
    Scenario Outline: UnSuccessfull login to the sauce demo
      Given User is in saucedemo app
      When User clicks burger menu button
      And Clicks login button in dropdown
      And Fills username input with "<username>"
      And Fills password input  with "<password>"
      And Clicks login button
      Then "<error>" message appears on the screen
      Examples:
        | username        | password | error                                                       |
        | bov@example.com | 10203040 | Provided credentials do not match any user in this service. |
        | bob@example.com | 10203050 | Provided credentials do not match any user in this service. |
        | bov@example.com | 10203050 | Provided credentials do not match any user in this service. |