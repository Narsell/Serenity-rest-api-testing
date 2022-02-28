#Author: Daniel
#Language: English

@get-one-employee
Feature: Get one employee's data
  As an user I want to be able to access the data of one particular employee

  Background:
    Given that the user meets the requirements to make requests to the API

  Scenario: Get all the data from a particular employee by providing their id
    When the user sends a request via GET to the endpoint "/employee/1"
    Then the user should get the data of one single employee
    | id |     name     |   salary   |   age   | profile image |
    | 1  | Tiger Nixon |   320800   |    61   |     [blank]    |