package testCases;

import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.SetupInit;
import base.TestDataImport;
import pages.HomePage;
import pages.NavigationPage;
import pages.TechnicalConfigurationReportToolPage;
import utils.Utility;

public class TechnicalConfigurationReportTool extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	TechnicalConfigurationReportToolPage technicalConfigurationReportToolPage;
	SetupInit init;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		technicalConfigurationReportToolPage = new TechnicalConfigurationReportToolPage(getDriver());
	}
	@Test(dataProvider = "ReportTool_Add", dataProviderClass = TestDataImport.class, description = "Add Report Tool")
	public void addReportTool(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addReportTool");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigReportTool();
			technicalConfigurationReportToolPage.addReportTool(map, Utility.getMapKeys(map));
			technicalConfigurationReportToolPage.verifyAddedReportTool(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "ReportTool_Edit", dataProviderClass = TestDataImport.class, description = "Edit Report Tool")
	public void editReportTool(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editReportTool");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigReportTool();
			if (technicalConfigurationReportToolPage.editReportTool(map, Utility.getMapKeys(map)))
				technicalConfigurationReportToolPage.verifyEditedReportTool(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "ReportTool_Delete", dataProviderClass = TestDataImport.class, description = "Delete Report Tool")
	public void deleteReportTool(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteReportTool");
			homePage.goToHome();
			navigationPage.clickOnTechnicalConfigReportTool();
			
			if (technicalConfigurationReportToolPage.deleteReportTool(map, Utility.getMapKeys(map)))
				if (technicalConfigurationReportToolPage.verifyDeletedReportTool(map, Utility.getMapKeys(map)))
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
