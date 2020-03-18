package testCases;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationRegionalEntityPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationRegionalEntity extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationRegionalEntityPage businessConfigurationRegionalEntityPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationRegionalEntityPage = new BusinessConfigurationRegionalEntityPage(getDriver());
	}

	@Test(dataProvider = "RegionalEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRegionalEntity, Author: shivani.patel")
	public void addRegionalEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addRegionalEntity");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			businessConfigurationRegionalEntityPage.addRegionalEntity(map, Utility.getMapKeys(map));
			businessConfigurationRegionalEntityPage.verifyAddedRegionalEntity(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "RegionalEntity_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRegionalEntity, Author: shivani.patel")
	public void editRegionalEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editRegionalEntity");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			if (businessConfigurationRegionalEntityPage.editRegionalEntity(map, Utility.getMapKeys(map)))
				businessConfigurationRegionalEntityPage.verifyEditedRegionalEntity(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "RegionalEntity_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRegionalEntity, Author: shivani.patel")
	public void deleteRegionalEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteRegionalEntity");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigBusinessHierarchy();
			if (businessConfigurationRegionalEntityPage.deleteRegionalEntity(map, Utility.getMapKeys(map)))
				if (businessConfigurationRegionalEntityPage.verifyDeletedRegionalEntity(map, Utility.getMapKeys(map)))
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
