@Account
Feature: Account validation

  Background:
    Given The user has already logged into the application
    |username|password|
    |sathyajothi247@gmail.com|High5        |

  Scenario: Verify account page title
    Given user is on accounts page
    Then page title should be "My account - My Store"

  Scenario: Verify account section
    Given user is on accounts page
    Then user gets account section
    |Order history and details|
    |My credit slips          |
    |My addresses|
    |My personal information|
    |My wishlists|
    And accounts section count should be 5