Feature: adding to comparison feature
  This feature deals with adding to comparison functionality

  Scenario Outline: Add product to comparison from product page
    Given User navigates to main page
    When User enters "<firstProductName>" to search bar
    When User clicks "<firstProductName>" product title
    When User clicks compare button on main trade panel
    #Then Compare button is active on main trade panel
    When User enters "<secondProductName>" to search bar
    When User clicks "<secondProductName>" product title
    When User clicks compare button on main trade panel
    #Then Compare button is active on main trade panel
    When User navigates to previous page
    When User clicks blue compare button
    Then User sees "<firstProductName>" product title on comparison page
    Then User sees "<secondProductName>" product title on comparison page

    Examples:
      | firstProductName              | secondProductName                   |
      | Дартс Play Sport D-41см 19883 | Дартс З Чарками (29Х22Х4 См) 230811 |

