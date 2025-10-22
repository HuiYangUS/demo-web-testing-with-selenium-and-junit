@demo
Feature: Demo Use of Gherkin

  @happy
  Scenario: 1st Demo Case
    Given a user asks for "coffee"
    When a server checks the inventory
    Then the order is served

  @sad
  Scenario: 2nd Demo Case
    Given a user asks for "coffee"
    When a server checks the inventory
    Then the order is served
