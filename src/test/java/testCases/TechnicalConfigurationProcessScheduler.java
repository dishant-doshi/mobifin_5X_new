package testCases;

import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.TechnicalConfigurationProcessSchedulerPage;
import utils.Utility;

public class TechnicalConfigurationProcessScheduler extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	TechnicalConfigurationProcessSchedulerPage technicalConfigurationProcessSchedulerPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		technicalConfigurationProcessSchedulerPage = new TechnicalConfigurationProcessSchedulerPage(getDriver());
	}
	
	@Test(dataProvider = "ProcessScheduler_Add", dataProviderClass = TestDataImport.class, description = "Add Process Scheduler")
	public void addProcessScheduler(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addProcessScheduler");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigProcessScheduler();
			technicalConfigurationProcessSchedulerPage.addProcessScheduler(map, Utility.getMapKeys(map));
			technicalConfigurationProcessSchedulerPage.verifyProcessScheduler(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "ProcessScheduler_Edit", dataProviderClass = TestDataImport.class, description = "Edit Process Scheduler")
	public void editProcessScheduler(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editProcessScheduler");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigProcessScheduler();
			if(technicalConfigurationProcessSchedulerPage.editProcessScheduler(map, Utility.getMapKeys(map)))
				technicalConfigurationProcessSchedulerPage.verifyEditProcessScheduler(map, Utility.getMapKeys(map));
			else
				throw new Exception("Method has return false : Record not found");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "ProcessScheduler_Delete", dataProviderClass = TestDataImport.class, description = "Delete Process Scheduler")
	public void deleteProcessScheduler(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteProcessScheduler");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigProcessScheduler();
			if(technicalConfigurationProcessSchedulerPage.deleteProcessScheduler(map, Utility.getMapKeys(map)))
			  if(technicalConfigurationProcessSchedulerPage.VerifyDeleteProcessScheduler(map, Utility.getMapKeys(map)))
				  throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}


	

}
