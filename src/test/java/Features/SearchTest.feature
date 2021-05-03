Feature: search feature
  This feature deals with the search functionality of the application

  Scenario Outline: Search different queries
    Given User navigates to main page
    When User enters "<searchQuery>" to search bar
    Then Search results are contain "<searchQuery>" search query

    Examples:
      | searchQuery |
      | iphone      |
      | asus        |