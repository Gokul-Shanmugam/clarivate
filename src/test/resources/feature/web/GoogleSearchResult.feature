@Scenario1
Feature: BOT 3594 Automation QA Engineer Interview Task
  
  @Browser @Automated
  Scenario: Validate Google Search for Clarivate Analytics
  This scenario is to validate the clarivate.com is the first search result while search with Clarivate Analytics in google.com
  
    Given I launch "https://www.google.com/" in "chrome"
    And I wait for "GoogleSearch" screen to load
    And I verify "txtSearchBox" is displayed
    And I enter the text as "Clarivate Analytics" in "txtSearchBox"
    And I hit Enter key
    And I wait for "SearchResults" screen to load
    Then I verify "https://clarivate.com/" search result link is displayed in index "1"