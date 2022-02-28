#Author: Daniel
#Language: English

@add-one-employee
Feature: API Testing
  As an user I want to test the functionality of the API by calling all of its endpoints

  Background:
    Given that the user meets the requirements to make requests to the API

  Scenario: Add a new record to the employees database
    When the user sends a request via POST to the endpoint "/create"
    | id |     name     |   salary   |   age   | profile image |
    | 1  | Tiger Nixon |   320800   |    61   |     [blank]    |
    Then the user should be able to verify the employee was added successfully
    | successfulMessage | Successfully! Record has been added. |