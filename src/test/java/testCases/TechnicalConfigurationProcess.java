package testCases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import pages.HomePage;
import pages.NavigationPage;
import pages.TechnicalConfigurationProcessPage;

public class TechnicalConfigurationProcess extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	TechnicalConfigurationProcessPage technicalConfigurationProcessPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		technicalConfigurationProcessPage = new TechnicalConfigurationProcessPage(getDriver());
	}

	@Test(description = "verify Process")
	public void process() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			setTestParameters(map, "verifyProcess");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigProcess();
			technicalConfigurationProcessPage.verifyProcessTable();
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

}
