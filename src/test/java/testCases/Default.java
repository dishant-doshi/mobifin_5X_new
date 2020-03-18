package testCases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.SetupInit;
import pages.DefaultPage;
import pages.HomePage;

public class Default extends SetupInit {
	HomePage homePage;
	DefaultPage defaultPage;

	@BeforeMethod
	public void beforeMethod() {
		homePage = new HomePage(getDriver());
		defaultPage = new DefaultPage(getDriver());
	}

	@Test(description = "Id: Default, Author: Dishant Doshi")
	public void defaultScript() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			setTestParameters(map, "defaultScript");
			homePage.goToHome();
			defaultPage.addDefaultData();
			setSuccessParameters(map);
		} catch (Exception e) {
			setFailureParameters(map);
			logException(e, map);
		} finally {
			logData(map);
		}
	}
}
