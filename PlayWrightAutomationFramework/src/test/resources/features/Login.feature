Feature: Login Functionality

  Scenario: verify user can login
    Given user opens website
    When user enters valid credentials as "valid.username" and "valid.password"
    And clicks on login button
    Then verify home page is displayed