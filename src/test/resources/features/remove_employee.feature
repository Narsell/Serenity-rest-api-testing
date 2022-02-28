#Author: Daniel
#Language: English

@remove-one-employee
Feature: API Testing
  As an user I want to be able to delete a record of an employee by providing their id

  Background:
    Given that the user meets the requirements to make requests to the API

  Scenario: Remove a record of an employee
    When the user attempts to delete an employee via the "/delete/2" endpoint
    Then the user should verify the status code "200" and the response body
      | message | Successfully! Record has been deleted |