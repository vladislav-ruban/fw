Feature: search feature
  This feature deals with the search results sorting functionality of the application

  Scenario: Sort search results by price low to high
    Given User navigates to main page
    When User enters "iphone" to search bar
    Then Search results are sorted by price low to high