package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.SetupInit;

public class UserManagementViewUserPage extends SetupInit {
	CommonPage common;
	NavigationPage navigationPage;
	By txtUserName = By.id("username");
	By btnSearch = By.xpath("//button[contains(@class,'input-search')]");
	By alertMessage = By.className("ant-alert-message");
	By navigationList = By.className("ant-steps-item-title");
	String verifyElement = "//*[@class='ant-row ant-form-item' and contains(.//label, '%s') and contains(.//span,'%s')]//preceding::*[contains(@class,'steps-item-process')]";
	// String navigationVerify =
	// "//*[contains(@class,'steps-item-process')]//*[normalize-space(text())='%s']";

	public UserManagementViewUserPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
		navigationPage = new NavigationPage(this.driver);
	}

	public void sendTextInUserName(String userName) {
		sendKeys(txtUserName, userName, 0);
	}

	public void clickOnSearchBtn() {
		clickOnElement(btnSearch, 0);
	}

	public void viewUser(Map<Object, Object> map, List<Object> mapKeys) {
		navigationPage.clickOnUserManagementViewUser();
		sendTextInUserName(map.get(mapKeys.get(5)).toString().split(":")[1]);
		clickOnSearchBtn();
		Map<String, Boolean> verifyMap = new HashMap<String, Boolean>();
		if (veifyElementIsNotVisible(alertMessage, 5)) {
			List<WebElement> list = getElementList(navigationList);
			for (int i = 0; i < list.size(); i++) {
				// string
				if (!map.get(mapKeys.get(4)).toString().isEmpty()) {
					String[] pageWiseInput = map.get(mapKeys.get(4)).toString().split("/");
					for (int j = 0; j < pageWiseInput.length; j++) {
						String[] noOfInput = pageWiseInput[j].split(",");
						for (int k = 0; k < noOfInput.length; k++) {
							String[] input = noOfInput[k].split(":");
							String temp = String.format(verifyElement, input[0], input[1]);
							verifyMap.put(temp, verifyVisible(By.xpath(temp),5));
						}
					}
				}

				// user name
				if (!map.get(mapKeys.get(5)).toString().isEmpty()) {
					String[] username = map.get(mapKeys.get(5)).toString().split(":");
					String temp = String.format(verifyElement, username[0], username[1]);
					verifyMap.put(temp, verifyVisible(By.xpath(temp),5));
				}

				// dropdown
				if (!map.get(mapKeys.get(7)).toString().isEmpty()) {
					String[] pageWiseInput = map.get(mapKeys.get(7)).toString().split("/");
					for (int j = 0; j < pageWiseInput.length; j++) {
						String[] noOfInput = pageWiseInput[j].split(",");
						for (int k = 0; k < noOfInput.length; k++) {
							String[] input = noOfInput[k].split(":");
							String temp = String.format(verifyElement, input[0], input[1]);
							verifyMap.put(temp, verifyVisible(By.xpath(temp),5));
						}
					}
				}
				// radio
				if (!map.get(mapKeys.get(8)).toString().isEmpty()) {
					String[] pageWiseInput = map.get(mapKeys.get(8)).toString().split("/");
					for (int j = 0; j < pageWiseInput.length; j++) {
						String[] noOfInput = pageWiseInput[j].split(",");
						for (int k = 0; k < noOfInput.length; k++) {
							String[] input = noOfInput[k].split(":");
							String temp = String.format(verifyElement, input[0], input[1]);
							verifyMap.put(temp, verifyVisible(By.xpath(temp),5));
						}
					}
				}
				// multi select
				if (!map.get(mapKeys.get(13)).toString().isEmpty()) {
					String[] pageWiseInput = map.get(mapKeys.get(13)).toString().split("/");
					for (int j = 0; j < pageWiseInput.length; j++) {
						String[] noOfInput = pageWiseInput[j].split(",");
						for (int k = 0; k < noOfInput.length; k++) {
							String[] multiInput = noOfInput[k].split(":");
							String[] input = multiInput[1].split("#");
							String temp = String.format(verifyElement, multiInput[0], input[1]);
							verifyMap.put(temp, verifyVisible(By.xpath(temp), 5));
						}
					}
				}
				if (i != list.size() - 1)
					common.clickOnNextBtn();
			}
			verifyMapData(verifyMap);
		}
	}

	public void verifyMapData(Map<String, Boolean> verifyMap) {
		boolean result = true;
		String exceptionMsg = "";
		for (Map.Entry<String, Boolean> e : verifyMap.entrySet()) {
			String key = e.getKey();
			if (!e.getValue()) {
				exceptionMsg = exceptionMsg + " " + key + "failed ";
				result = false;
			}
		}
		if (!result) {
			RuntimeException re = new RuntimeException(exceptionMsg.trim());
			throw re;
		}
	}
}
