Feature: Add Employee in HRMS

  Background:
    #Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page
    When user clicks on PIM option
    And user clicks on Add Employee option

  @script3 @addEmp @regression
  Scenario: Add Employee by firstname and lastname
    And user enters firstname and lastname in the fields
    And user clicks on save button
    Then employee added successfully

  @sprint3 @addEmp @regression @marina
  Scenario: Adding the employee by firstname, middle name and lastname
    And user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee added successfully
