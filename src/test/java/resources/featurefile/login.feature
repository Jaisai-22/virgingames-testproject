#A feature file in cucumber specifies parameters and conditions for executing the test code.

Feature: Login Functionality for Virgin games website
  As a user I want to login in to virgin games website


  @Smoke,@Sanity,@Regression
  Scenario: Verify that user should navigate to login page
    Given I am home page
    When I click on login link
    Then I should navigate to login page

  @Sanity,@Regression
  Scenario Outline: Verify the error message with invalid credentials
    Given I am home page
    When I click on login link
    And I enter invalid email "<email>"
    And I enter invalid password "<password>"
    And I click on login button
    Then I should see the error message "<errorMessage>"


    Examples:

      | email         | password | errorMessage                                                              |
      | xyz@yahoo.com | abc123   | Please try again, your username/email or password has not been recognised |
      | xyz@yahoo.com | abc3456  | Please try again, your username/email or password has not been recognised |
      |               | abc123   | Both your username and password are required                              |
      | xyz@yahoo.com |          | Both your username and password are required                              |
      |               |          | Both your username and password are required                              |

