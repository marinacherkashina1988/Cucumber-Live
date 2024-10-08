Feature: Login scenarios

  @script1 @validLogin @regression
  Scenario: admin login
    #Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page