package testCases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.CommonPage;
import pages.HomePage;
import pages.NavigationPage;
import pages.PlatformConfigurationWalletTemplatePage;
import utils.Utility;

public class PlatformConfigurationWalletTemplate extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationWalletTemplatePage platformConfigurationWalletTemplatePage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationWalletTemplatePage = new PlatformConfigurationWalletTemplatePage(getDriver());
	}

	@Test(dataProvider = "WalletTemplate_Add", dataProviderClass = TestDataImport.class, description = "Id: AddWalletTemplate, Author: shivani.patel")
	public void addWalletTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addWalletTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWalletTemplate();
			platformConfigurationWalletTemplatePage.addWalletTemplate(map, Utility.getMapKeys(map));
			platformConfigurationWalletTemplatePage.verifyAddedWalletTemplate(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "WalletTemplate_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditWalletTemplate, Author: shivani.patel")
	public void editWalletTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editWalletTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWalletTemplate();
			if (platformConfigurationWalletTemplatePage.editWalletTemplate(map, Utility.getMapKeys(map)))
				platformConfigurationWalletTemplatePage.verifyEditedWalletTemplate(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "WalletTemplate_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteWalletTemplate, Author: shivani.patel")
	public void deleteWalletTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editWalletTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWalletTemplate();
			if (platformConfigurationWalletTemplatePage.deleteWalletTemplate(map, Utility.getMapKeys(map)))
				if (platformConfigurationWalletTemplatePage.verifyDeletedWalletTemplate(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "WalletTemplate_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortWalletTemplate, Author: shivani.patel")
	public void sortWalletTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortWalletTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWalletTemplate();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationWalletTemplatePage.sortWalletTemplate(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : sorting failed");
			} else
				throw new Exception("Method has return false : columns mis-matched");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
