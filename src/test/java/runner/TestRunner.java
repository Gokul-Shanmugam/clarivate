package runner;

import org.testng.annotations.AfterClass;

import core.Context;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		format = {"pretty","html:target/cucumber-reports/cucumber-pretty","json:target/cucumber-reports/CucumberTestReport.json","rerun:target/cucumber-reports/rerun.txt"},
		features = "src/test/resources/feature",
		glue={"core","pagefactory"},
		tags={"@Desktop"},
		monochrome =true,
		dryRun = false 
 )

public class TestRunner extends AbstractTestNGCucumberTests{

	
	 	@AfterClass(alwaysRun = true)
	    public void closeDriver() throws Exception {
			if(Context.getInstance().getBrowserType().equals("desktop")){
	 			Context.getInstance().getProcess().destroy();
	 		}
				Context.getInstance().closeDriver();
	    }
	
	

	
}
