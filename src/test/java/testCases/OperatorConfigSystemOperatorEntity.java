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
import pages.OperatorConfigSystemOperatorEntityPage;
import utils.Utility;

public class OperatorConfigSystemOperatorEntity extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	OperatorConfigSystemOperatorEntityPage operatorConfigSystemOperatorEntityPage;
	CommonPage common;
	private int sortCounter;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		operatorConfigSystemOperatorEntityPage = new OperatorConfigSystemOperatorEntityPage(getDriver());
		common = new CommonPage(getDriver());
	}

	@Test(dataProvider = "SystemOperatorEntity_Add", dataProviderClass = TestDataImport.class, description = "Id: AddSystemOperatorEntity, Author: shivani.patel")
	public void addSystemOperatorEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addSystemOperatorEntity");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorEntity();
			operatorConfigSystemOperatorEntityPage.addSystemOperatorEntity(map, Utility.getMapKeys(map));
			operatorConfigSystemOperatorEntityPage.verifyAddedSystemOperatorEntity(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "SystemOperatorEntity_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditSystemOperatorEntity, Author: shivani.patel")
	public void editSystemOperatorEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editSystemOperatorEntity");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorEntity();
			if (operatorConfigSystemOperatorEntityPage.editSystemOperatorEntity(map, Utility.getMapKeys(map)))
				operatorConfigSystemOperatorEntityPage.verifyEditedSystemOperatorEntity(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "SystemOperatorEntity_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteSystemOperatorEntity, Author: shivani.patel")
	public void deleteSystemOperatorEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteSystemOperatorEntity");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorEntity();
			if (operatorConfigSystemOperatorEntityPage.deleteSystemOperatorEntity(map, Utility.getMapKeys(map)))
				if (operatorConfigSystemOperatorEntityPage.verifyDeletedSystemOperatorEntity(map,
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

	@Test(dataProvider = "SystemOperatorEntity_Sort", dataProviderClass = TestDataImport.class, description = "Id: SortSystemOperatorEntity, Author: shivani.patel")
	public void sortSystemOperatorEntity(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortSystemOperatorEntity");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigSystemOperatorEntity();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!operatorConfigSystemOperatorEntityPage.sortSystemOperatorEntity(map, Utility.getMapKeys(map)))
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
