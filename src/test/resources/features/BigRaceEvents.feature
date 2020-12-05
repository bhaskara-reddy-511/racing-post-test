Feature: Big Race events page

  Background: Open the Big Race Entries page
    Given I am on "https://www.racingpost.com/racecards/"
    When I click the "Big Race Entries" header

  Scenario: Checking next big race event date should be in the future
  Then the date of the next big race event is in the future

  Scenario: Big race event detail page should have the default active tab as Card
    And Select the first big race event
    Then the active tab should be the "Card" in the detailed race information page

  Scenario: Big race events page should have Todays Offers list sites
    Then atleast one site should be returned in todays offers table
