#Author: Daniel
#Language: English

@api-testing
Feature: API Testing
  As an user I want to test the functionality of the API by calling all of its endpoints

  Background:
    Given that the user meets the requirements to make request to API

  @get-all-employees
  Scenario: Verify the /employees endpoint and make sure it returns all the required parameters
    When the user sends a request via GET to the endpoint "/employees"
    Then the user should get the data of "24" employees
      | id |     name     |   salary   |   age   | profile image |
      | 1  | Tiger Nixon |   320800   |    61   |     [blank]    |
      | 2  | Garrett Winters |   170750   |    63   |     [blank]    |
      | 3  | Ashton Cox |   86000   |    66   |     [blank]    |
      | 4  | Cedric Kelly |   433060   |    22   |     [blank]    |
      | 5  | Airi Satou |   162700   |    33   |     [blank]    |

  @get-one-employee
  Scenario: Verify the /employee/id endpoint and make sure it returns all the required parameters
    When the user sends a request via GET to the endpoint "/employee/1"
    Then the user should get the data of one single employee
      | id |     name     |   salary   |   age   | profile image |
      | 1  | Tiger Nixon |   320800   |    61   |     [blank]    |
