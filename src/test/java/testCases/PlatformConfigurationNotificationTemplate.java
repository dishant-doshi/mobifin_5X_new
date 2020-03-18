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
import pages.PlatformConfigurationNotificationTemplatePage;
import utils.Utility;

public class PlatformConfigurationNotificationTemplate extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationNotificationTemplatePage platformConfigurationNotificationTemplatePage;
	SetupInit init;
	private int sortCounter;
	CommonPage common;
	
	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationNotificationTemplatePage = new PlatformConfigurationNotificationTemplatePage(getDriver());
		common = new CommonPage(getDriver());
	}

	@Test(dataProvider = "NotificationTemplate_Add", dataProviderClass = TestDataImport.class, description = "Add Notification Template")
	public void addNotificationTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addNotificationTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigNotificationTemplate();
			platformConfigurationNotificationTemplatePage.addNotificationTemplate(map, Utility.getMapKeys(map));
			platformConfigurationNotificationTemplatePage.verifyAddedNotificationTemplate(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "NotificationTemplate_Edit", dataProviderClass = TestDataImport.class, description = "Edit Notification Template")
	public void editNotificationTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editNotificationTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigNotificationTemplate();
			if(platformConfigurationNotificationTemplatePage.editNotificationTemplate(map, Utility.getMapKeys(map)))
				platformConfigurationNotificationTemplatePage.verifyEditedNotificationTemplate(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "NotificationTemplate_Delete", dataProviderClass = TestDataImport.class, description = "Delete Notification Template")
	public void deleteNotificationTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteNotificationTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigNotificationTemplate();
			if(platformConfigurationNotificationTemplatePage.deleteNotificationTemplate(map, Utility.getMapKeys(map)))
			 if(platformConfigurationNotificationTemplatePage.verifyDeletedNotificationTemplate(map, Utility.getMapKeys(map)))
				 throw new Exception("Method has return false : Record not deleted");
				 setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "NotificationTemplate_Sort", dataProviderClass = TestDataImport.class, description = "sort NotificationTemplate")
	public void sortNotificationTemplate(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortNotificationTemplate");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigNotificationTemplate();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationNotificationTemplatePage.sortNotificationTemplate(map, Utility.getMapKeys(map)))
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
