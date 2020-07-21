package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.*;

import core.Context;
import cucumber.api.java.en.Then;

public class SearchResults {
		
	@FindBy(xpath = "//div[text()='All']")
	public WebElement WaitElement;
		
	WebDriver driver;
	
	public SearchResults() {
		 this.driver=Context.getInstance().getDriver();
	     PageFactory.initElements(driver, this);
	}
	
	@Then("^I verify \"(.*)\" search result link is displayed in index \"(.*)\"$")
	public void verifySearchResult(String sExpectedText, String sPosition) {
	    List<WebElement> listElement = driver.findElements(By.xpath("//div[@class='r']/a"));
	    String sActual = listElement.get(Integer.parseInt(sPosition)-1).getAttribute("href");
	    Assert.assertEquals(sActual, sExpectedText);
	}


}
