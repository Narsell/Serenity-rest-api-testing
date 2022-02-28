#Author: Daniel
#Language: English

@add-one-employee
Feature: API Testing
  As an user I want to be able to add a record of an employee by providing their data

  Background:
    Given that the user meets the requirements to make requests to the API

  Scenario: Add a new record to the employees database
    When the user attempts to add a new employee via the "/create" endpoint
    | id |     name     |   salary   |   age   | profile image |
    | 1  | Tiger Nixon |   320800   |    61   |     [blank]    |
    Then the user should verify the status code "200" and the response body
    | message | Successfully! Record has been added. |