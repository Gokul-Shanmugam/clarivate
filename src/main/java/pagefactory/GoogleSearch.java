package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Context;

public class GoogleSearch {
	
	@FindBy(xpath = "//a[text()='Gmail']")
	public WebElement lnkGmail;
	
	@FindBy(xpath = "//input[@title='Search']")
	public WebElement WaitElement;
	
	@FindBy(xpath = "//input[@title='Search']")
	public WebElement txtSearchBox;
	
	WebDriver driver;
	
	public GoogleSearch() {
		this.driver=Context.getInstance().getDriver();
	     PageFactory.initElements(driver, this);
	}

}
