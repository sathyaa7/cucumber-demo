@Smoke
Feature: Demo test automation practice

As a learner
I should be able to automate the demo application


Scenario: Login page title
Given user is in login page
When I verify the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is in login page
Then the forgot password link should be displayed

  @demo
Scenario Outline: Login page title
Given user is in login page
When the user enters the "<username>" and "<password>"
And the user clicks the login button
Then page title should be "My account - My Store"
Examples:
|username|password|
|abc@gmail.com|password|

  @new
  Scenario: Example check
    Given user is in login page
    When I do data driven testing with "<sheetname>"
    Examples:
    |sheetname|
    |hikedetails|