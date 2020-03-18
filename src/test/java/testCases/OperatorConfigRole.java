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
import pages.OperatorConfigRolePage;
import utils.Utility;

public class OperatorConfigRole extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	OperatorConfigRolePage operatorConfigRolePage;
	private int sortCounter;
	private CommonPage common;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		operatorConfigRolePage = new OperatorConfigRolePage(getDriver());
		common = new CommonPage(getDriver());
	}

	@Test(dataProvider = "Role_Add", dataProviderClass = TestDataImport.class, description = "Id: AddRole, Author: shivani.patel")
	public void addRole(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addRole");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigRole();
			operatorConfigRolePage.addRole(map, Utility.getMapKeys(map));
			operatorConfigRolePage.verifyAddedRole(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Role_Edit", dataProviderClass = TestDataImport.class, description = "Id: EditRole, Author: shivani.patel")
	public void editRole(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editRole");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigRole();
			if (operatorConfigRolePage.editRole(map, Utility.getMapKeys(map)))
				operatorConfigRolePage.verifyEditedRole(map, Utility.getMapKeys(map));
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

	@Test(dataProvider = "Role_Delete", dataProviderClass = TestDataImport.class, description = "Id: DeleteRole, Author: shivani.patel")
	public void deleteRole(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteRole");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigRole();
			if (operatorConfigRolePage.deleteRole(map, Utility.getMapKeys(map)))
				if (operatorConfigRolePage.verifyDeletedRole(map, Utility.getMapKeys(map)))
					throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}

	@Test(dataProvider = "Role_Sort", dataProviderClass = TestDataImport.class, description = "Id: sortRole, Author: Dishant Doshi")
	public void sortRole(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addRole");
			homePage.goToHome();
			navigationPage.clickOnOperatorConfigRole();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!operatorConfigRolePage.sortRole(map, Utility.getMapKeys(map)))
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
