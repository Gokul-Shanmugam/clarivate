package core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;

/** 
 * Singleton class with core methods
 * 
 * @author Gokul
 * @version 1.0
 */  
public class Context {
	
	private WebDriver driver;
	private WiniumDriver winiumDriver;
	private String sCurrentPage = "";
	private WebDriverWait oWebDriverWait;
	private static ThreadLocal t = ThreadLocal.withInitial(Context::new);
	private static Logger logger = Logger.getLogger(Context.class);
	private Map<String, Object> oPageInstance = new HashMap<>();
	private Process p;
	private String browserType;
	
	/**
	 * This method is to get the Instance of the class
	 * 
	 * @return class Instance
	 */
	public static Context getInstance(){
		return  (Context) t.get();
	}

	/**
	 * This method is to get the web driver reference
	 * 
	 * @return Webdriver reference
	 */
	public WebDriver getDriver(){
		return driver;
	}
	
	/**
	 * This method is used to get the Winium Driver driver reference
	 * 
	 * @return Winium Driver reference
	 */
	public WebDriver getwiniumDriver(){
		return winiumDriver;
	}
	
	/**
	 * This method is used to get the WebDriverWait Instance
	 * 
	 * @return WebDriverWait Instance
	 */
	public WebDriverWait getWebDriverWait(){
		return oWebDriverWait;
	}
	
	/**
	 * This method is used to get the current page
	 * 
	 * @return String current page
	 */
	public String getCurrentPage(){
		return sCurrentPage;
	}
	
	/**
	 * This method is used to get the logger
	 * 
	 * @return String logger instance
	 */
	public Logger getLogger(){
		return logger;
	}
	
	/**
	 * This method is used to get the Process Instance
	 * 
	 * @return Process Instance
	 */
	public Process getProcess(){
		return p;
	}
	
	/**
	 * This method is to set the current page value
	 * 
	 * @param sCurrentPage This parameter is to set the value of sCurrentPage
	 * @return void
	 */
	public void setCurrentPage(String sCurrentPage){
		this.sCurrentPage = sCurrentPage;
	}
	
	/**
	 * This method is used to get the BrowserType Used
	 * 
	 * @return String BrowserType value
	 */
	public String getBrowserType(){
		return browserType;
	}
	
	/**
	 * This method is used to set the driver
	 * 
	 * @param sBrowserName This parameter is to set the driver
	 * @return void
	 */
	public void startDriver(String sBrowserName) throws IOException{
		logger.info("Start of the test in "+sBrowserName);
		browserType=sBrowserName;
		switch(sBrowserName.toLowerCase()){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		case "desktop":
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
			p=Runtime.getRuntime().exec( System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\Winium.Desktop.Driver.exe");
			winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			break;
		default:
			logger.error("Driver type not found for the mentioned type: "+sBrowserName);
			Assert.fail("Driver type not found for the mentioned type: "+sBrowserName);
			
		}
		
		if(sBrowserName.equals("desktop")){
			oWebDriverWait = new WebDriverWait(winiumDriver, 30);
		}
		else{
			this.driver.manage().window().maximize();
			oWebDriverWait = new WebDriverWait(driver, 30);
		}
	}
	
	/**
	 * This method is used to find the WebElement by returning true or false
	 * 
	 * @param sElement Element to be verified
	 * @return boolean 
	 */
	public boolean find(String sElement){
		boolean bReturn = false;
		try{
			bReturn = findElement(sElement).isDisplayed();
		}catch(Exception e){
			logger.error("Exception occured in finding the WebElement: "+e.getMessage());
		}
		
		return bReturn;
	}
	
	/**
	 * This method is used to find the WebElement of the respective page
	 * 
	 * @param sElement Element to identified
	 * @return WebElement 
	 */
	public WebElement findElement(String sElement) {
		return findElement(sCurrentPage,sElement);
	}
	
	/**
	 * This method is used to close the Execution
	 * 
	 * @return void
	 */
	public void closeDriver(){
		driver.quit();
		logger.info("End of Execution");
	}
	
	private WebElement findElement(String page,String sElement) {
		WebElement webElement = searchElement(getPageInstance(page),sElement);
		return webElement;
	}
	
	private Object getPageInstance(String sPage) {
		
		if(!oPageInstance.containsKey(sPage)){
			try {
				oPageInstance.put(sPage, Class.forName("pagefactory."+sPage).getDeclaredConstructor().newInstance());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				logger.error(e.getMessage());
			}
		}
		return oPageInstance.get(sPage);
	}
		
	private WebElement searchElement(Object oPage, String sElement){
		WebElement oElement = null;
		Class aClass = oPage.getClass();
		List<Field> fields = new ArrayList<>();
		fields.addAll(Arrays.asList(aClass.getDeclaredFields()));
		for(Field f : fields){
			if(f.getName().equals(sElement)){
				try {
					oElement = (WebElement)f.get(oPage);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return oElement;
	}
}
