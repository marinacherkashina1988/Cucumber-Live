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

  @params
  Scenario: Add employee using parameter
    When user enters "Marina" and "Ms" and "Cherkashina" in the name field
    And user clicks on save button
    Then employee added successfully

@ddt
  Scenario Outline: Adding multiple employees
    When user enters "<firstname>" and "<middlename>" and "<lastname>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      | Karina    | Ev         | Cherry   |
      | Julia     | Ms         | Crystal  |
      | Jack      | J          | Older    |

  @datatable
  Scenario: Adding employees using data table
    When user enters employees using data table and saves them
      | firstname | middlename | lastname |
      | Karina    | Ev         | Cherry   |
      | Julia     | Ms         | Crystal  |
      | Jack      | J          | Older    |

    @excel
    Scenario: Adding employees using excel file
      When user adds multiple employees using excel file