@UI
Feature: Test Sample feature file

  @Run
  Scenario: Verify Google
    Given user navigates to 'Google Page'
    And user inserts 'lady gaga poker face lyrics on genius' in 'Search Area'
    And user inserts 'test data' in 'Username Texbox'

    And user inserts 'lady gaga poker face lyrics on genius' in 'Search Area'
    Then search results are displayed