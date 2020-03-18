package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationOperatingEntityTemplatePage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationOperatingEntityTemplate extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationOperatingEntityTemplatePage businessConfigurationOperatingEntityTemplatePage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationOperatingEntityTemplatePage = new BusinessConfigurationOperatingEntityTemplatePage(
				getDriver());
	}

	@Test(dataProvider = "OperatingEntityTemplate_Add", dataProviderClass = TestDataImport.class, description = "Id: AddOperatingEntity, Author: shivani.patel")
	public void addOperatingEntityTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addOperatingEntityTemplate");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			businessConfigurationOperatingEntityTemplatePage.addOperatingEntityTemplate(map, Utility.getMapKeys(map));
			businessConfigurationOperatingEntityTemplatePage.verifyAddedOperatingEntityTemplate(map,
					Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "OperatingEntityTemplate_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditOperatingEntityTemplate, Author: shivani.patel")
	public void editOperatingEntityTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editOperatingEntityTemplate");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			if (businessConfigurationOperatingEntityTemplatePage.editOperatingEntityTemplate(map,
					Utility.getMapKeys(map)))
				businessConfigurationOperatingEntityTemplatePage.verifyEditedOperatingEntityTemplate(map,
						Utility.getMapKeys(map));
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

	@Test(dataProvider = "OperatingEntityTemplate_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteOperatingEntity, Author: shivani.patel")
	public void deleteOperatingEntityTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteOperatingEntityTemplate");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			if (businessConfigurationOperatingEntityTemplatePage.deleteOperatingEntityTemplate(map,
					Utility.getMapKeys(map)))
				if (businessConfigurationOperatingEntityTemplatePage.verifyDeletedOperatingEntityTemplate(map,
						Utility.getMapKeys(map)))
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
