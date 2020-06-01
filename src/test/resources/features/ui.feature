Feature: search functionality

  As a user
  I want to search for any number or text using the search engine
  and also display my search result in the desired language

  @test
  Scenario Outline: search
    Given kevin is on the Wikipedia homepage
    And validate that language "<option>" is "<desiredOption>"
    And search for "<query>"
    And Search result heading matches the "<query>"
    And search result is also displayed in other languages
      | Italiano |
      | Deutsch  |
    When change the search result language to "<otherLanguage>"
    Then search result contains the link to the English version
    Examples:
      | option | desiredOption | query | otherLanguage |
      | EN     | EN            | money | Francais      |





