Feature: API Workflow

  Background:
    Given JWT bearer token is generated

  @api @creatingEmployeeAPI
  Scenario: create an employee
    Given a request is prepared for creating an employee
    When POST call is made to create an employee
    Then status code is 201
    Then the employee id "Employee.employee_id" is stored and value is validated

  @api @getOneEmployee
  Scenario: retrieving created employee
    Given request to get one employee is prepared
    When GET request is called to retrieve an employee
    Then status code is 200
    Then the employee id is verified

  @api @updateEmployee
  Scenario: updating an existing employee
    Given request to update employee is prepared
    When PUT request is called to update an employee
    Then status code is 200
    Then Message "Employee record Updated" is displayed

  @api @partialUpdateEmployee
  Scenario: partially updating employee
    Given request to partially update an employee is prepared
    When PATCH request is called to update an employee
    Then status code is 201
    Then updated status "Promoted" and Job Title "Senior Computer Technician" are verified

  @api @deleteEmployee
  Scenario: deleting an employee
    Given request to delete employee is prepared
    When DELETE request is called to delete an employee
    Then status code is 200
    Then "Employee deleted" message is displayed

  @api @getAllEmployees
  Scenario: getting all employees
    Given request to retrieve all employees is prepared
    When GET request is called to retrieve all employees
    Then status code is 200
    Then we can access all employee IDs

  @api @getJobTitles
  Scenario: getting Job Titles for all employees
    Given request to retrieve job titles is prepared
    When GET request is called to retrieved job titles
    Then status code is 200
    Then we can access all job titles

  @api @getEmploymentStatus
  Scenario: getting employment status for all employees
    Given request to retrieve employment status is prepared
    When GET request is called to retrieve all employees employment status
    Then status code is 200
    Then we can access all employees employment status


