Feature: adding to cart feature
  This feature deals with adding to cart functionality

  Scenario Outline: Add product to cart from search results
    Given User navigates to main page
    When User enters "<productName>" to search bar
    When User adds "<productName>" product to the cart
    Then User sees "<productName>" product in the cart

    Examples:
      | productName                                       |
      | Samsung Galaxy A72 6/128GB Black (SM-A725FZKDSEK) |