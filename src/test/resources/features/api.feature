
Feature: get status of pets

  @test
  Scenario Outline: No of Pets with status avaliable and named Doggie
    Given Harry makes a request to know no pets with "<status>"
    Then number of the pets "<named>" with "<status>" is "<number>"

    Examples:
      | status    | named  | number |
      | available | Doggie | 32L    |

  @mock
  Scenario Outline: using mock
    Given mock service is running
    Given Harry makes a request to know no pets with "<status>"
    Then number of the pets "<named>" with "<status>" is "<number>" using the mock service

    Examples:
      | status    | named  | number |
      | available | Doggie | 1L     |
