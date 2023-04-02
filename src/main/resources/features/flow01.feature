Feature: Flow_01

  Background:
    Given Navigate to the gmail page

  Scenario Outline: Login using valid credentials
    When Enter the e-mail address "<email>"
    And Enter the password "<password>"
    Then Valid successful login

    Examples:
      | email                             | password |
      | lamansys.technical.test@gmail.com | lamansys |

  Scenario Outline: Login using incorrect password
    When Enter the e-mail address "<email>"
    And Enter the password "<password>"
    Then Valid password is incorrect

    Examples:
      | email                             | password |
      | lamansys.technical.test@gmail.com | error    |
