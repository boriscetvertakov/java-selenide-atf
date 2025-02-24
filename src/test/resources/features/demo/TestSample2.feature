@UI @Run
Feature: Test Sample 2 feature file

  Scenario: Verify Google 1 from TestSample2
    Given User navigates to 'Home Page'
    And User inserts 'hello world' in textbox: 'Search Area'
    And User pushes Enter button on textbox: 'Search Area'
    Then User verifies that text 'Hello world' is present in 'Search Area' field

  Scenario: Verify Google 2 from TestSample2
    Given User navigates to 'Home Page'
    And User inserts 'hello world' in textbox: 'Search Area'
    And User pushes Enter button on textbox: 'Search Area'
    Then User verifies that text 'Hello world' is present in 'Search Area' field
