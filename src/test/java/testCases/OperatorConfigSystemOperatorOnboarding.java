package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.OperatorConfigSystemOperatorOnboardingPage;
import utils.Utility;

public class OperatorConfigSystemOperatorOnboarding extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	OperatorConfigSystemOperatorOnboardingPage operatorConfigSystemOperatorOnboardingPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		operatorConfigSystemOperatorOnboardingPage = new OperatorConfigSystemOperatorOnboardingPage(getDriver());
	}

	@Test(dataProvider = "SystemOperatorOnboarding_Add", dataProviderClass = TestDataImport.class, description = "Id: AddSystemOperatorOnboarding, Author: shivani.patel")
	public void addSystemOperatorOnboarding(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addSystemOperatorOnboarding");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorOnboarding();
			operatorConfigSystemOperatorOnboardingPage.addSystemOperatorOnboarding(map, Utility.getMapKeys(map));
			operatorConfigSystemOperatorOnboardingPage.verifyAddSystemOperatorOnboarding(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
