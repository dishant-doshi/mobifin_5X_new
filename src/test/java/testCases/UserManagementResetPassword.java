package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.TechnicalConfigurationSchedulerPage;
import pages.UserManagementResetPasswordPage;
import utils.Utility;

public class UserManagementResetPassword extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	UserManagementResetPasswordPage userManagementResetPasswordPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		userManagementResetPasswordPage = new UserManagementResetPasswordPage(getDriver());
	}

	@Test(dataProvider = "ResetPassword", dataProviderClass = TestDataImport.class, description = "ResetPassword")
	public void resetPassword(Map<Object, Object> map) {
		try {
			setTestParameters(map, "resetPassword");
			homePage.goToHome();
			navigationPage.clickOnUserManagementResetPassword();
			userManagementResetPasswordPage.resetPassword(map, Utility.getMapKeys(map));
			userManagementResetPasswordPage.verifyResetPassword();
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
		
}
