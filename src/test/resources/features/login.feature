Feature: User login

  As a customer
  I want to log into my account
  so that I can access my dashboard and manage orders

  Background:
    Given I am on the login page

  @smoke @login
  Scenario Outline: Customer login successfully with valid credentials
    When I login with "<username_or_email>" and "<password>"
    Then I should see a confirmation message "Hello <username> (not <username>? Log out)"

    Examples:
      | username_or_email  | password | username |
      | user1xp            | pass234! | user1xp  |
      | aline.px@gmail.com | pass@@!  | alinexp  |

  @negative @login
  Scenario Outline: Customer login with invalid credentials
    When I login with "<username-or-email>" and "<password>"
    Then I should see an error message

    Examples:
      | username-or-email  | password |
      |                    | pass234! |
      | aline.px@gmail.com |          |
      |                    |          |