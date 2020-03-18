package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.SetupInit;
import pages.HomePage;
import pages.NavigationPage;
import pages.TechnicalConfigurationProcessRunDetailsPage;

public class TechnicalConfigurationProcessRunDetails extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	TechnicalConfigurationProcessRunDetailsPage technicalConfigurationProcessRunDetailsPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		technicalConfigurationProcessRunDetailsPage = new TechnicalConfigurationProcessRunDetailsPage(getDriver());
	}

	@Test(description = "verify Process Run Details")
	public void processRunDetails(Map<Object, Object> map) {
		try {
			setTestParameters(map, "verifyProcessRunDetails");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigProcessRunDetails();
			technicalConfigurationProcessRunDetailsPage.verifyProcessRunDetails();
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

}
