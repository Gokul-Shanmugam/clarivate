package core;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import enums.CalculatorRepository;

/** 
 * Step defnition which are common to all desktop pages should be written here
 * 
 * @author Gokul
 * @version 1.0
 */  
public class WinniumSteps{
	
	/**
	 * This method is to launch the desktop application
	 * 
	 * @return void 
	 */
	@Given("^I launch Calculator Application$")
	public void launchCalculator(){
		SeleniumSteps oSeleniumSteps = new SeleniumSteps();
		oSeleniumSteps.launchApplication("", "desktop");
	}
	
	/**
	 * This method is to enter the input number in calculator
	 * 
	 * @param sNumber Number to provided as an input to calculator
	 * @return void 
	 */
	@When("^I enter number as \"(.*)\" in calculator$")
    public void enterValue(String sNumber) {
	 try{
		Context.getInstance().getLogger().info("Entering the input number as "+sNumber);
		for (char ch : sNumber.toCharArray()) {
            pressButton(CalculatorRepository.valueOf("NUM" + ch).getKeys());
        }
	 }catch(Exception e){
		 Context.getInstance().getLogger().error("Exception occured while Entering the input number in calculator "+e.getMessage());
		 Assert.fail("Exception occured while Entering the input number in calculator"+e.getMessage());
	 }
    }
	
	/**
	 * This method is to click the operation key in calculator
	 * 
	 * @param sOperation operation need to provided based on Enum value like PLUS,SQUAREROOT
	 * @return void 
	 */
	@When("^I click on \"(.*)\" in calculator$")
    public void clickOperation(String sOperation) {
		Context.getInstance().getLogger().info("click on operation in calculator");
            pressButton(CalculatorRepository.valueOf(sOperation).getKeys());
    }
	
	/**
	 * This method is to validate the result displayed in calculator
	 * 
	 * @param sExpectedResult Expected result need to be provided
	 * @return void 
	 */
	@When("^I validate the result as \"(.*)\" in calculator$")
    public void verifyResult(String sExpectedResult) {
		Context.getInstance().getLogger().info("verify the results in calculator");
            String sActualText = Context.getInstance().getwiniumDriver().findElement(By.id("CalculatorResults")).getAttribute("Name");
            Assert.assertEquals(sActualText, sExpectedResult);
    }
	
	 private void pressButton(String keyID) {
         Context.getInstance().getwiniumDriver().findElement(By.id(keyID)).click();
 }
	
}
