Feature: API Workflow

  Background:
    Given JWT bearer token is generated

  @api @creatingEmpAPI
  Scenario: create an employee
    Given a request is prepared for creating an employee
    When POST call is made to create an employee
    Then status code is 201
    Then the employee id "Employee.employee_id" is stored and value is validated
