package testCases;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import base.TestDataImport;
import pages.BusinessConfigurationNotificationPage;
import pages.CommonPage;
import pages.HomePage;
import pages.NavigationPage;
import utils.Utility;

public class BusinessConfigurationNotification extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	BusinessConfigurationNotificationPage businessConfigurationNotificationPage;
	SetupInit init;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		businessConfigurationNotificationPage = new BusinessConfigurationNotificationPage(getDriver());
	}

	@Test(dataProvider = "Notification_Add", dataProviderClass = TestDataImport.class, description = "Id: AddNotification, Author: shivani.patel")
	public void addNotification(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addNotification");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigNotification();
			businessConfigurationNotificationPage.addNotification(map, Utility.getMapKeys(map));
			businessConfigurationNotificationPage.verifyAddedNotification(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Notification_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditNotification, Author: shivani.patel")
	public void editNotification(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editNotification");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigNotification();
			if (businessConfigurationNotificationPage.editNotification(map, Utility.getMapKeys(map)))
				businessConfigurationNotificationPage.verifyEditedNotification(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Notification_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteNotification, Author: shivani.patel")
	public void deleteNotification(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editNotification");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigNotification();
			if (businessConfigurationNotificationPage.deleteNotification(map, Utility.getMapKeys(map)))
				if (businessConfigurationNotificationPage.verifyDeletedNotification(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Notification_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortNotification, Author: shivani.patel")
	public void sortNotification(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortNotification");
			homePage.goToHome();
			navigationPage.clickOnBusinessConfigNotification();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!businessConfigurationNotificationPage.sortNotification(map, Utility.getMapKeys(map)))
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

