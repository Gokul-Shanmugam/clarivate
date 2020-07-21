$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/web/GoogleSearchResult.feature");
formatter.feature({
  "name": "BOT 3594 Automation QA Engineer Interview Task",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Scenario1"
    }
  ]
});
formatter.scenario({
  "name": "Validate Google Search for Clarivate Analytics",
  "description": "  This scenario is to validate the clarivate.com is the first search result while search with Clarivate Analytics in google.com",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario1"
    },
    {
      "name": "@Browser"
    },
    {
      "name": "@Automated"
    }
  ]
});
formatter.step({
  "name": "I launch \"https://www.google.com/\" in \"chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SeleniumSteps.launchApplication(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I wait for \"GoogleSearch\" screen to load",
  "keyword": "And "
});
formatter.match({
  "location": "SeleniumSteps.waitForPageToLoad(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"txtSearchBox\" is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "SeleniumSteps.verifyElementDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the text as \"Clarivate Analytics\" in \"txtSearchBox\"",
  "keyword": "And "
});
formatter.match({
  "location": "SeleniumSteps.enterText(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I hit Enter key",
  "keyword": "And "
});
formatter.match({
  "location": "SeleniumSteps.pressEnterKey()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I wait for \"SearchResults\" screen to load",
  "keyword": "And "
});
formatter.match({
  "location": "SeleniumSteps.waitForPageToLoad(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"https://clarivate.com/\" search result link is displayed in index \"1\"",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchResults.verifySearchResult(String,String)"
});
formatter.result({
  "status": "passed"
});
});