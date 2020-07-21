package core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


/** 
 * Step defnition which are common to all web pages should be written here
 * 
 * @author Gokul
 * @version 1.0
 */  
public class SeleniumSteps {
	
	/**
	 * This method is to launch the application url in respective browser
	 * 
	 * @param sURL set the URL to be launched
	 * @param sBrowser set the Browser Name 
	 * @return void 
	 */
	@Given("^I launch \"(.*)\" in \"(.*)\"$")
	public void launchApplication(String sURL, String sBrowser){
		try{
			Context.getInstance().startDriver(sBrowser);
			if(!sBrowser.equals("desktop")){
				Context.getInstance().getLogger().info("Launching the URL");
				Context.getInstance().getDriver().get(sURL);
			}	
		}catch (Exception e){
			Context.getInstance().getLogger().error("Unable to launch the Application "+e.getMessage());
			Assert.fail("Unable to launch the Application "+e.getMessage());
		}
	}
	
	/**
	 * This method is to check whether the element is displayed
	 * 
	 * @param sElement Element value should be same as POM
	 * @return void 
	 */
	@And("^I verify \"(.*)\" is displayed$")
	public void verifyElementDisplayed(String sElement){
		if(!Context.getInstance().find(sElement)){
			Context.getInstance().getLogger().error("Element not displayed "+sElement);
			Assert.fail(sElement+" is not displayed");
		}
		else{
			Context.getInstance().getLogger().info("Element is displayed"+sElement);
		}
	}
	
	/**
	 * This method is to check whether the page is loaded with wait Element
	 * 
	 * @param sPage page name should be same as POM file name
	 * @return void 
	 */
	@And("^I wait for \"(.*)\" screen to load$")
	public void waitForPageToLoad(String sPage){
		try{
		Context.getInstance().setCurrentPage(sPage.replace(" ", ""));
		Context.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(Context.getInstance().findElement("WaitElement")));
		Context.getInstance().getLogger().info(sPage+" page loaded");
		} catch (Exception e){
			Context.getInstance().getLogger().error(sPage+" Page Not loaded "+e.getMessage());
			Assert.fail(sPage+" Page Not loaded "+e.getMessage());
		}
	}
	
	/**
	 * This method is to enter the text in the mentioned webElement
	 * 
	 * @param sText text to be entered in WebElement
	 * @param sWebElement element to which the sText to be Entered
	 * @return void 
	 */
	@Given("^I enter the text as \"(.*)\" in \"(.*)\"$")
	public void enterText(String sText, String sWebElement) {
		try{
		Context.getInstance().findElement(sWebElement).sendKeys(sText);
		}
		catch(Exception e){
			Context.getInstance().getLogger().error("Exception occured in Entering the text to the WebElement "+e.getMessage());
			Assert.fail("Exception occured in Entering the text to the WebElement "+e.getMessage());
		}
	}

	/**
	 * This method is to hit the Enter Key
	 * 
	 * @return void 
	 */
	@Given("^I hit Enter key$")
	public void pressEnterKey() {
		Actions builder = new Actions(Context.getInstance().getDriver());        
		builder.sendKeys(Keys.ENTER).build().perform();
	}

}
