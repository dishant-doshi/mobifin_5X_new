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
import pages.PlatformConfigurationRulePage;
import utils.Utility;

public class PlatformConfigurationRule extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationRulePage platformConfigurationRulePage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationRulePage = new PlatformConfigurationRulePage(getDriver());
	}

	@Test(dataProvider = "Rule_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRule, Author: shivani.patel")
	public void addRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			platformConfigurationRulePage.addRule(map, Utility.getMapKeys(map));
			platformConfigurationRulePage.verifyAddedRule(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Rule_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRule, Author: shivani.patel")
	public void editRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			if (platformConfigurationRulePage.editRule(map, Utility.getMapKeys(map)))
				platformConfigurationRulePage.verifyEditedRule(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Rule_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRule, Author: shivani.patel")
	public void deleteRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			if (platformConfigurationRulePage.deleteRule(map, Utility.getMapKeys(map)))
				if (platformConfigurationRulePage.verifyDeletedRule(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Rule_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortRule, Author: shivani.patel")
	public void sortRule(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortRule");
			homePage.goToHome();
			navigationPage.clickOnPlateformConfigurationRule();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationRulePage.sortRule(map, Utility.getMapKeys(map)))
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
