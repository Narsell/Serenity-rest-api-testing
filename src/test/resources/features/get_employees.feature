#Author: Daniel
#Language: English

@get-employees
Feature: Get all employees' data
  As an user I want to be able to access the list of all employees along with their data

  Background:
    Given that the user meets the requirements to make requests to the API

  Scenario: Get the list of employees along with their data
    When the user sends a request via GET to the endpoint "/employees"
    Then the user should get the data of "24" employees
      | id |     name     |   salary   |   age   | profile image |
      | 1  | Tiger Nixon |   320800   |    61   |     [blank]    |
      | 2  | Garrett Winters |   170750   |    63   |     [blank]    |
      | 3  | Ashton Cox |   86000   |    66   |     [blank]    |
      | 4  | Cedric Kelly |   433060   |    22   |     [blank]    |
      | 5  | Airi Satou |   162700   |    33   |     [blank]    |