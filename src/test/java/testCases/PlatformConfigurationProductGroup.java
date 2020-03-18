package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationProductGroupPage;
import utils.Utility;

public class PlatformConfigurationProductGroup extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationProductGroupPage platformConfigurationProductGroupPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationProductGroupPage = new PlatformConfigurationProductGroupPage(getDriver());
	}

	@Test(dataProvider = "ProductGroup_Add", dataProviderClass = TestDataImport.class, description = "Add Product Group")
	public void addProductGroup(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addProductGroup");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProductGroup();
			platformConfigurationProductGroupPage.addProductGroup(map, Utility.getMapKeys(map));
			platformConfigurationProductGroupPage.verifyAddedProductGroup(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "ProductGroup_Edit", dataProviderClass = TestDataImport.class, description = "Edit Product Group")
	public void editProductGroup(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editProductGroup");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProductGroup();
			if(platformConfigurationProductGroupPage.editProductGroup(map, Utility.getMapKeys(map)))
			platformConfigurationProductGroupPage.verifyEditedProductGroup(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "ProductGroup_Delete", dataProviderClass = TestDataImport.class, description = "Delete Product Group")
	public void deleteProductGroup(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteProductGroup");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProductGroup();
			if(platformConfigurationProductGroupPage.deleteProductGroup(map, Utility.getMapKeys(map)))
				if(platformConfigurationProductGroupPage.verifyDeletedProductGroup(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	@Test(dataProvider = "ProductGroup_Sort", dataProviderClass = TestDataImport.class, description = "sort Product Group")
	public void sortProductGroup(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortProductGroup");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProductGroup();
			platformConfigurationProductGroupPage.sortProductGroup(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
