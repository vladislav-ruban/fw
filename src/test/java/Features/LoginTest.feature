Feature: login feature
  This feature deals with login functionality of the application

  Scenario: Login to account
    Given User navigates to main page
    When User clicks login button on main page
    When User logs in with "vrubantest@gmail.com" email and "testaccount" password
    Then User sees that he logged in as "Test"