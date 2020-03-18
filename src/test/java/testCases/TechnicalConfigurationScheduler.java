package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.TechnicalConfigurationSchedulerPage;
import utils.Utility;

public class TechnicalConfigurationScheduler extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	TechnicalConfigurationSchedulerPage technicalConfigurationSchedulerPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		technicalConfigurationSchedulerPage = new TechnicalConfigurationSchedulerPage(getDriver());
	}

	
	@Test(dataProvider = "Scheduler_Add", dataProviderClass = TestDataImport.class, description = "Add Scheduler")
	public void addScheduler(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addScheduler");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigScheduler();
			technicalConfigurationSchedulerPage.addScheduler(map, Utility.getMapKeys(map));
			technicalConfigurationSchedulerPage.verifyScheduler(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "Scheduler_Edit", dataProviderClass = TestDataImport.class, description = "Edit Scheduler")
	public void editScheduler(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editScheduler");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigScheduler();
			if(technicalConfigurationSchedulerPage.editScheduler(map, Utility.getMapKeys(map)))
				technicalConfigurationSchedulerPage.verifyEditedScheduler(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "Scheduler_Delete", dataProviderClass = TestDataImport.class, description = "Delete Scheduler")
	public void deleteScheduler(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteScheduler");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigScheduler();
			if(technicalConfigurationSchedulerPage.deleteScheduler(map, Utility.getMapKeys(map)))
			 if(technicalConfigurationSchedulerPage.verifyDeleteScheduler(map, Utility.getMapKeys(map)))
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
