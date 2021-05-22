Feature: search feature
  This feature deals with the search results sorting functionality of the application

  Scenario: Sort search results by price low to high
    Given User navigates to main page
    When User enters "bosch" to search bar
    When User select "від дешевих до дорогих" sorting option
    Then Search results are sorted by price low to high

  Scenario: Sort search results by price high to low
    Given User navigates to main page
    When User enters "bosch" to search bar
    When User select "від дорогих до дешевих" sorting option
    Then Search results are sorted by price high to low

