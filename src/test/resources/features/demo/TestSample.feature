@UI
Feature: Test Sample feature file

  @Run
  Scenario: Verify Google
    Given User navigates to 'Google Page'
    And User inserts 'hello world' in textbox: 'Search Area'
    And User pushes Enter button on textbox: 'Search Area'
