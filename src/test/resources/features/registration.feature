Feature: User registration

  As a guest user
  I want to register an account
  so that I can place orders with saved details

  Background:
    Given I am on the registration page

  @smoke @registration
  Scenario Outline: Successful registration with valid details
    When I register with "<username>", "<email-address>", and "<password>"
    Then I should see a confirmation message for "<username>"

    Examples:
      | username | email-address      | password    |
      | user1ziph  | usert1ziph@gmail.com | pass234!    |
      | alineziph  | aline.ziph@gmail.com | pass@@!     |
      | testezriph | testerziph@test.com  | abc12345688 |

  @negative @registration
  Scenario Outline: Registration fails with invalid details
    When I register with "<username>", "<email-address>", and "<password>"
    Then I should see the error message

    Examples:
      | username | email-address      | password    |
      |          | usert234@gmail.com | pass234!    |
      | alineQ   | aline.q@gmail.com  |             |
      | alineQ   |                    | pass@@!     |
      | tester01 | tester01@test.com  | abc12345688 |
      |          |                    |             |


