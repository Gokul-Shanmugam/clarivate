$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/desktop/Calculator.feature");
formatter.feature({
  "name": "BOT 3594 Automation QA Engineer Interview Task",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Scenario2"
    }
  ]
});
formatter.scenario({
  "name": "Validate Square Root to be performed in Calculator",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario2"
    },
    {
      "name": "@Desktop"
    },
    {
      "name": "@Automated"
    }
  ]
});
formatter.step({
  "name": "I launch Calculator Application",
  "keyword": "Given "
});
formatter.match({
  "location": "WinniumSteps.launchCalculator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter number as \"16\" in calculator",
  "keyword": "When "
});
formatter.match({
  "location": "WinniumSteps.enterValue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"SQUAREROOT\" in calculator",
  "keyword": "And "
});
formatter.match({
  "location": "WinniumSteps.clickOperation(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"EQUAL\" in calculator",
  "keyword": "And "
});
formatter.match({
  "location": "WinniumSteps.clickOperation(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the result as \"4\" in calculator",
  "keyword": "Then "
});
formatter.match({
  "location": "WinniumSteps.verifyResult(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [4] but found [Display is 1]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:453)\r\n\tat org.testng.Assert.assertEquals(Assert.java:463)\r\n\tat core.WinniumSteps.verifyResult(WinniumSteps.java:71)\r\n\tat ✽.I validate the result as \"4\" in calculator(src/test/resources/feature/desktop/Calculator.feature:11)\r\n",
  "status": "failed"
});
});