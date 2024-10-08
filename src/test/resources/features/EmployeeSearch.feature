Feature: Search Employees

  Background:
    #Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page
    When user clicks on PIM option
    And user clicks on employee list option

  @script2 @empSearch @regression
  Scenario: Search employee by employee ID
    And user enters employee ID
    And user clicks on search button
    Then user is able to see searched employee on screen

  @test
  Scenario: Search employee by employee name
    And user enters employee name
    And user clicks on search button
    Then user is able to see searched employee on screen
