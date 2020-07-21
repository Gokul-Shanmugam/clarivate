 @Scenario2
Feature: BOT 3594 Automation QA Engineer Interview Task
  
  @Desktop @Automated
  Scenario: Validate Square Root to be performed in Calculator
  
    Given I launch Calculator Application
    When  I enter number as "16" in calculator
    And I click on "SQUAREROOT" in calculator
    And I click on "EQUAL" in calculator
    Then I validate the result as "4" in calculator