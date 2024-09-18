@Logout @Regression
Feature: Logout from the application

  Scenario: Successfully logout and redirect to login page
    Given user logs in with username "standard_user" and password "secret_sauce"
    When user logs out
    Then user is redirected to the login page "saucedemo.com"