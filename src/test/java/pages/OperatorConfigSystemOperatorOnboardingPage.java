package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class OperatorConfigSystemOperatorOnboardingPage extends SetupInit {
	CommonPage common;
	UserManagementViewUserPage userManagementViewUserPage;

	By txtSystemOperatorEntityName = By
			.id(Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_NAME", CommonConstants.ELEMENT_FILE));
	By drpSystemOperatorEntity = By
			.xpath("//*[@id='inputSystemOperatorOnBoadingBusinessEntityName']//*[@class='ant-select-arrow']");
	String drpValue = "//li[normalize-space(text())='%s']";
	String multipleValue = "//*[normalize-space(text())='%s']";
	String multipleLabel = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//*[contains(@class,'multiple')]//div[contains(@class,'rendered')]//input";
	String radioField = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//div[contains(@class,'radio')]//*[normalize-space(text())='%s']";
	String string = "//div[@class='current-content clearfix']//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//input[@type='text']";
	String password = "//div[@class='current-content clearfix']//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//input[@type='password']";
	String categoryField = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']";
	String verifyField = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']";
	String dynamicDrpLable = "//div[@class='current-content clearfix']//*[normalize-space(text())='%s']//ancestor::div[@class='ant-form-item-label']//following-sibling::div//div[contains(@class,'select-enabled')]";
	String dynamicDrpValue = "//li[normalize-space(text())='%s']";
	By failureAlert = By.xpath("//*[text()='User already exists']");

	public OperatorConfigSystemOperatorOnboardingPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
		userManagementViewUserPage = new UserManagementViewUserPage(this.driver);
	}

	public void sendTextInStringField(String stringValue, String value) {
		sendKeysWithRemoveReadOnlyProperty(By.xpath(String.format(string, stringValue)), value);
	}

	public void sendTextInPasswordField(String stringValue, String value) {
		sendKeysWithRemoveReadOnlyProperty(By.xpath(String.format(password, stringValue)), value);
	}

	public void selectSystemOperatorEntity(String sysOperatorEntity) {
		selectFromDropDown(drpSystemOperatorEntity, By.xpath(String.format(drpValue, sysOperatorEntity)), 60);
	}

	public void selectTextInDropdown(String dropdownLable, String dropdownValue) {
		selectFromDropDown(By.xpath(String.format(dynamicDrpLable, dropdownLable)),
				By.xpath(String.format(dynamicDrpValue, dropdownValue)), 0);
	}

	public void selectMultipleField(String multipleLabelName, String value) {
		selectFromDropDown(By.xpath(String.format(multipleLabel, multipleLabelName)),
				By.xpath(String.format(multipleValue, value)));
	}

	public void clickOnRadioField(String radioLable, String radioValue) {
		clickOnElement(By.xpath(String.format(radioField, radioLable, radioValue)));
	}

	public void addSystemOperatorOnboarding(Map<Object, Object> map, List<Object> mapKeys) {
		selectSystemOperatorEntity(map.get(mapKeys.get(1)).toString());
		String[] navigateList = map.get(mapKeys.get(2)).toString().trim().split("/");
		List<String> list = new ArrayList<String>();
		pauseInSeconds(10);
		for (int i = 0; i < navigateList.length; i++) {
			// string
			if (!map.get(mapKeys.get(4)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(4)).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(verifyField, input[0].trim())), 3)
								&& !list.contains(input[0].trim())) {
							sendTextInStringField(input[0].trim(), input[1].trim());
							list.add(input[0].trim());
						}
					}
				}
			}

			// user name
			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {
				String[] username = map.get(mapKeys.get(5)).toString().split(":");
				if (verifyVisible(By.xpath(String.format(verifyField, username[0].trim())), 3)
						&& !list.contains(username[0].trim())) {
					sendTextInStringField(username[0].trim(), username[1].trim());
					list.add(username[0].trim());
				}
			}

			// password
			if (!map.get(mapKeys.get(6)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(6)).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(verifyField, input[0].trim())), 3)
								&& !list.contains(input[0].trim())) {
							sendTextInPasswordField(input[0].trim(), input[1].trim());
							list.add(input[0].trim());
						}
					}
				}
			}
			// dropdown
			if (!map.get(mapKeys.get(7)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(7)).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(verifyField, input[0].trim())), 3)
								&& !list.contains(input[0].trim())) {
							selectTextInDropdown(input[0].trim(), input[1].trim());
							list.add(input[0].trim());
						}
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
						if (verifyVisible(By.xpath(String.format(verifyField, input[0].trim())), 3)
								&& !list.contains(input[0].trim())) {
							clickOnRadioField(input[0].trim(), input[1].trim());
							list.add(input[0].trim());
						}
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
						if (verifyVisible(By.xpath(String.format(verifyField, multiInput[0].trim())), 3)
								&& !list.contains(multiInput[0].trim())) {
							String[] input = multiInput[1].split("#");
							for (int l = 0; l < input.length; l++)
								selectMultipleField(multiInput[0].trim(), input[l].trim());
							list.add(multiInput[0].trim());
						}
					}
				}
			}
			if (i != navigateList.length - 1)
				common.clickOnNextBtn();
		}
		common.clickOnSubmitBtn();
	}

	public void verifyAddSystemOperatorOnboarding(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyVisible(failureAlert, 3))
			log("<b style='color:#E82F08'>User already exists</b>");
		else
			log("<b style='color:#02563d'>User successfuly added.</b>");
		userManagementViewUserPage.viewUser(map, mapKeys);
	}
}
