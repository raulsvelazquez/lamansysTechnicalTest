Feature: Flow_02

  Background:
    Given Navigate to the ebay page

  Scenario: Search for "Electric Guitar"
    When Looking for an electric guitar
    Then I print the price of the electric guitar by console