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
import pages.PlatformConfigurationProductPage;
import utils.Utility;

public class PlatformConfigurationProduct extends SetupInit {
	HomePage homePage;
	NavigationPage navigationPage;
	PlatformConfigurationProductPage platformConfigurationProductPage;
	SetupInit init;
	private int sortCounter;
	CommonPage common;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		navigationPage = new NavigationPage(getDriver());
		platformConfigurationProductPage = new PlatformConfigurationProductPage(getDriver());
		common = new CommonPage(getDriver());
	}

	@Test(dataProvider = "Product_Add", dataProviderClass = TestDataImport.class, description = "Add Product")
	public void addProduct(Map<Object, Object> map) {
		try {
			setTestParameters(map, "addProduct");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProduct();
			platformConfigurationProductPage.addProduct(map, Utility.getMapKeys(map));
			platformConfigurationProductPage.verifyAddedProduct(map, Utility.getMapKeys(map));
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	@Test(dataProvider = "Product_Edit", dataProviderClass = TestDataImport.class, description = "Edit Product")
	public void editProduct(Map<Object, Object> map) {
		try {
			setTestParameters(map, "editProduct");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProduct();
			if(platformConfigurationProductPage.editProduct(map, Utility.getMapKeys(map)))
				platformConfigurationProductPage.verifyEditedProduct(map, Utility.getMapKeys(map));
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
	
	@Test(dataProvider = "Product_Delete", dataProviderClass = TestDataImport.class, description = "Delete Product")
	public void deleteProduct(Map<Object, Object> map) {
		try {
			setTestParameters(map, "deleteProduct");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProduct();
			if(platformConfigurationProductPage.deleteProduct(map, Utility.getMapKeys(map)))
			  if(platformConfigurationProductPage.verifyDeletedProduct(map, Utility.getMapKeys(map)))
				  throw new Exception("Method has return false : Record not deleted");
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
	
	
	@Test(dataProvider = "Product_Sort", dataProviderClass = TestDataImport.class, description = "sort Product")
	public void sortProduct(Map<Object, Object> map) {
		try {
			setTestParameters(map, "sortProduct");
			homePage.goToHome();
			navigationPage.clickOnPlatformConfigProduct();
			if (sortCounter == 0) {
				sortCounter++;
				List<String> list = common.addColumnInGrid();
				if (common.verifyColumnInGrid(list))
					booleanValue = true;
			}
			if (booleanValue) {
				if (!platformConfigurationProductPage.sortProduct(map, Utility.getMapKeys(map)))
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
