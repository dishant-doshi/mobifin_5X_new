package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import utils.Utility;

public class BusinessConfigurationOperatingEntityPage extends SetupInit {
	CommonPage common;
	By txtSystemOperatorEntityName = By
			.id(Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_NAME", CommonConstants.ELEMENT_FILE));
	By drpSystemOperatorEntity = By
			.xpath("//*[@id='inputSystemOperatorOnBoadingBusinessEntityName']//*[@class='ant-select-arrow']");
	String drpValue = "//li[normalize-space(text())='%s']";
	String drpValues = "(//li[normalize-space(text())='%s'])[last()]";
	String multipleValue = "//*[normalize-space(text())='%s']";
	String multipleLabel = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//*[contains(@class,'multiple')]//div[contains(@class,'rendered')]//input";
	String radioField = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//div[contains(@class,'radio')]//*[normalize-space(text())='%s']";
	String string = "//div[@class='current-content clearfix']//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//input[@type='text']";
	String password = "//div[@class='current-content clearfix']//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//input[@type='password']";
	String categoryField = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']";
	String verifyField = "//div[@class='current-content clearfix']//label[normalize-space(text())='%s']";
	String dynamicDrpLable = "//div[@class='current-content clearfix']//*[normalize-space(text())='%s']//ancestor::div[@class='ant-row ant-form-item']//div[contains(@class,'select-enabled')]";
	By failureAlert = By.xpath("//*[text()='User already exists']");
	By txtOperatingEntityTemplate = By
			.xpath("(//*[@id='inputOnBoadingBusinessEntityName']//*[@class='ant-select-arrow'])[last()]");
	By txtDescription = By.id("form_in_modal_inputOperatingentityAddDescription");
	By txtDescriptionInEdit = By.id("form_in_modal_inputOperatingentityEditDescription");
	String IsYes = "Yes";
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ScriptConstants.REGIONAL_ENTITY_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ScriptConstants.BUSINESS_ZONE_SAVE + "']//parent::button");
	By drpAccessChannel = By
			.xpath("(//*[contains(@id,'form_in_modal_accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	String statusField = "//*[@id='form_in_modal_inputOperatingentityAddStatus']//span[normalize-space(text())='%s']";
	String statusFieldEdit = "//*[@id='form_in_modal_inputOperatingentityEditStatus']//span[normalize-space(text())='%s']";
	By btnReload = By.xpath("//*[contains(@class,'anticon-reload')]//parent::button");
	By btnSearch = By.xpath("//*[contains(@class,'anticon-search')]//parent::button");
	String btnOperationgEntityAdd = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'regional-business')]//div[contains(@class,'action-button')]//button[2]";
	By drpOperatingEntity = By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]");
	By drpViewOrEditDetail = By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]");
	By drpViewDetailValue = By
			.xpath("(//li[normalize-space(text())='" + ScriptConstants.BUSINESS_ZONE_VIEW + "'])[last()]");
	String btnDelete = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'template')]//div[contains(@class,'action-button')]//button[2]";
	By calendar = By.xpath("//*[@class='ant-calendar-input ']");
	By calendarOk = By.xpath("//*[@class='ant-calendar-ok-btn']");
	String verify = "//*[text()='%s']";
	By horizontalBar = By.xpath("//div[contains(@class,'ant-steps-horizontal')]");
	// By multipleField = By.xpath("//*[@class='ant-steps ant-steps-horizontal
	// ant-steps-label-horizontal']");
	// String verify = "//*[text()='%s']";

	public BusinessConfigurationOperatingEntityPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInStringField(String stringValue, String value) {
		sendKeysWithRemoveReadOnlyProperty(By.xpath(String.format(string, stringValue)), value, 0);
	}

	public void sendTextInPasswordField(String stringValue, String value) {
		sendKeysWithRemoveReadOnlyProperty(By.xpath(String.format(password, stringValue)), value, 0);
	}

	public void selectSystemOperatorEntity(String sysOperatorEntity) {
		selectFromDropDown(drpSystemOperatorEntity, By.xpath(String.format(drpValue, sysOperatorEntity)), 0);
	}

	public void selectTextInDropdown(String dropdownLable, String dropdownValue) {
		selectFromDropDown(By.xpath(String.format(dynamicDrpLable, dropdownLable)),
				By.xpath(String.format(drpValue, dropdownValue)), 0);
	}

	public void selectMultipleField(String multipleLabelName, String value) {
		selectFromDropDown(By.xpath(String.format(multipleLabel, multipleLabelName)),
				By.xpath(String.format(multipleValue, value)), 0);
	}

	public void clickOnRadioField(String radioLable, String radioValue) {
		clickOnElement(By.xpath(String.format(radioField, radioLable, radioValue)), 0);
	}

	public void selectOperatingEntityTemplate(String operatingEntityTemplate) {
		selectFromDropDown(txtOperatingEntityTemplate, By.xpath(String.format((drpValue), operatingEntityTemplate)), 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(statusField, status)), 0);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(statusFieldEdit, status)), 0);
	}

	public void sendTextInOperatingEntityNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectField(String field) {
		selectFromDropDown(drpSelection, By.xpath(String.format(drpValues, field)), 0);
	}

	public void filterSearch(String operatingEntityName) {
		clickOnElement(btnReload, 0);
		sendTextInOperatingEntityNameFilterSearch(operatingEntityName);
		clickOnElement(btnSearch, 0);
	}

	public void clickOnOperatingEntityAddIcon(String parentRegionalEntity) {
		clickOnElement(By.xpath(String.format(btnOperationgEntityAdd, parentRegionalEntity)), 0);
	}

	public void selectOperatingEntityOnboarding() {
		selectFromDropDown(drpOperatingEntity,
				By.xpath(String.format(drpValues, ScriptConstants.ADD_OPERATINGENTITY_ONBOARDING)), 0);
	}

	public void clickOnViewDetail() {
		selectFromDropDown(drpViewOrEditDetail, By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_VIEW)),
				0);
	}

	public void clickOnEditDetail() {
		selectFromDropDown(drpViewOrEditDetail, By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_EDIT)),
				0);
	}

	public void clickOnOperatingEntityDelete(String regionalEntity) {
		clickOnElement(By.xpath(String.format(btnDelete, regionalEntity)), 0);
		common.clickOnDeleteConfirm();
	}

	public void selectDateOfBirth(String value, By element) {
		clickOnElement(element, 0);
		sendKeys(calendar, value, 0);
		clickOnElement(calendarOk, 0);
	}

	public void addOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		pauseInSeconds(2);
		clickOnOperatingEntityAddIcon(map.get(mapKeys.get(2)).toString());
		pauseInSeconds(5);
		selectOperatingEntityOnboarding();
		pauseInSeconds(2);
		selectOperatingEntityTemplate(map.get(mapKeys.get(1)).toString());
		String[] navigateList = map.get(mapKeys.get(4)).toString().trim().split("/");
		List<String> list = new ArrayList<String>();
		pauseInSeconds(10);
		for (int i = 0; i < navigateList.length; i++) {
			// string
			if (!map.get(mapKeys.get(6)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(6)).toString().split("/");
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
			if (!map.get(mapKeys.get(7)).toString().isEmpty()) {
				String[] username = map.get(mapKeys.get(7)).toString().split(":");
				if (verifyVisible(By.xpath(String.format(verifyField, username[0].trim())), 3)
						&& !list.contains(username[0].trim())) {
					sendTextInStringField(username[0].trim(), username[1].trim());
					list.add(username[0].trim());
				}
			}

			// password
			if (!map.get(mapKeys.get(8)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(8)).toString().split("/");
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
			if (!map.get(mapKeys.get(9)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(9)).toString().split("/");
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
			if (!map.get(mapKeys.get(10)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(10)).toString().split("/");
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

			// DateOfBirth
			if (!map.get(mapKeys.get(13)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(13)).toString().split("/");
				for (int j = 0; j < pageWiseInput.length; j++) {
					String[] noOfInput = pageWiseInput[j].split(",");
					for (int k = 0; k < noOfInput.length; k++) {
						String[] input = noOfInput[k].split(":");
						if (verifyVisible(By.xpath(String.format(verifyField, input[0].trim())), 3)
								&& !list.contains(input[0].trim())) {
							// selectDateOfBirth(input[0].trim(), input[1].trim());
							list.add(input[0].trim());
						}
					}
				}
			}

			// multi select
			if (!map.get(mapKeys.get(15)).toString().isEmpty()) {
				String[] pageWiseInput = map.get(mapKeys.get(15)).toString().split("/");
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
			clickOnElement(horizontalBar);
			if (i != navigateList.length - 1)
				common.clickOnNextBtn();
		}
		common.clickOnSubmitBtn();
	}

	public void verifyAddedOperatingEntity(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyVisible(failureAlert, 3)) {
			log("<b style='color:#E82F08'>User already exists</b>");
			common.clickOnCloseBtn();
		} else
			log("<b style='color:#02563d'>User successfuly added.</b>");
		filterSearch(map.get(mapKeys.get(7)).toString().split(":")[1]);
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(7)).toString().split(":")[1])), 0);
	}

	// public boolean editOperatingEntity(Map<Object, Object> map, List<Object>
	// mapKeys) {
	// filterSearch(map.get(mapKeys.get(1)).toString());
	// if (verifyVisible(By.xpath(String.format(verify,
	// map.get(mapKeys.get(1)).toString())))) {
	// clickOnEditDetail();
	// if (!map.get(mapKeys.get(3)).toString().isEmpty())
	// sendTextInDescriptionInEdit(map.get(mapKeys.get(3)).toString());
	// clickOnElement(btnSave);
	// return true;
	// } else
	// return false;
	// }
	//
	// public void verifyEditedOperatingEntity(Map<Object, Object> map, List<Object>
	// mapKeys) {
	// if (verifyVisible(failureAlert, 3)) {
	// log("<b style='color:#E82F08'>User already exists</b>");
	// common.clickOnCloseBtn();
	// } else
	// log("<b style='color:#02563d'>User successfuly added.</b>");
	// filterSearch(map.get(mapKeys.get(7)).toString().split(":")[1]);
	// verifyVisible(By.xpath(String.format(verify,
	// map.get(mapKeys.get(7)).toString().split(":")[1])), 0);
	// }
}
