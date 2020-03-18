package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationProductManagementPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationProductManagement extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationProductManagementPage businessConfigurationProductManagementPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationProductManagementPage = new BusinessConfigurationProductManagementPage(getDriver());
	}

	@Test(dataProvider = "ProductManagement_Edit", dataProviderClass = TestDataImport.class, description = "Edit Product Management")
	public void editProductManagement(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editProductManagement");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigProductManagement();
			businessConfigurationProductManagementPage.editProductManagement(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
}
