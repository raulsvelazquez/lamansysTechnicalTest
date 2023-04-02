Feature: API test automation

  Scenario: Example with GET method
    Given I want to see all comments
    Then Valid status code 200

  Scenario: Example with PUT method
    Given I want to update the title
    Then Valid that the title was modified
