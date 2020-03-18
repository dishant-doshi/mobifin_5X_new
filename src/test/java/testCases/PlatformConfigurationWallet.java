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
import pages.PlatformConfigurationWalletPage;
import utils.Utility;

public class PlatformConfigurationWallet extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationWalletPage platformConfigurationWalletPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationWalletPage = new PlatformConfigurationWalletPage(getDriver());
	}

	@Test(dataProvider = "Wallet_Add", dataProviderClass = TestDataImport.class, description = "Id: AddWallet, Author: shivani.patel")
	public void addWallet(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addWallet");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWallet();
			platformConfigurationWalletPage.addWallet(map, Utility.getMapKeys(map));
			platformConfigurationWalletPage.verifyAddedWallet(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Wallet_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditWallet, Author: shivani.patel")
	public void editWallet(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editWallet");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWallet();
			if (platformConfigurationWalletPage.editWallet(map, Utility.getMapKeys(map)))
				platformConfigurationWalletPage.verifyEditedWallet(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Wallet_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteWallet, Author: shivani.patel")
	public void deleteWallet(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editWallet");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationWallet();
			if (platformConfigurationWalletPage.deleteWallet(map, Utility.getMapKeys(map)))
				if (platformConfigurationWalletPage.verifyDeletedWallet(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Wallet_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortWallet, Author: shivani.patel")
	public void sortWallet(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortWallet");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationParameter();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationWalletPage.sortWallet(map, Utility.getMapKeys(map)))
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
