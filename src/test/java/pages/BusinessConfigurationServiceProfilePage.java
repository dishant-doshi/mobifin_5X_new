package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class BusinessConfigurationServiceProfilePage extends SetupInit {
	CommonPage common;
	By txtServiceProfileName = By.id(Utility.readJSFile("INPUT_SERVICEPROFILE_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_SERVICEPROFILE_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By
			.id(Utility.readJSFile("INPUT_SERVICEPROFILE_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	String drpStatus = "//*[@id='inputServiceprofileAddStatus']//span[normalize-space(text())='%s']";
	String drpValues = "(//li[normalize-space(text())='%s'])[last()]";
	By downArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By equals = By.xpath("//li[normalize-space(text())='Equals']");
	String verify = "//*[text()='%s']";
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("serviceprofile.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("serviceprofile.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("serviceprofile.label.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String fields = "//*[normalize-space(text())='%s']//..//*[normalize-space(text())='%s']";

	public BusinessConfigurationServiceProfilePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInServiceProfileName(String name) {
		sendKeys(txtServiceProfileName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 1);
	}

	public void sendTextInServiceProfileNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(drpValues, status)), 1);
	}

	public void selectField(String field) {
		selectFromDropDown(drpSelection, By.xpath(String.format(drpValues, field)), 0);
	}

	public void filterSearch(String serviceProfileName, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString)
			selectFromDropDown(downArrow, equals, 0);
		sendTextInServiceProfileNameFilterSearch(serviceProfileName);
		selectStatusInFilterSearch(status);
		common.clickOnFilterSearchBtn();
	}

	public void addServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInServiceProfileName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			String[] fieldlist = map.get(mapKeys.get(4)).toString().trim().split(",");
			for (int j = 0; j < fieldlist.length; j++) {
				clickOnElement(
						By.xpath("(//*[contains(@class,'node-action-buttons')]//*[contains(@class,'add')])[last()]"));
				String[] fieldname = fieldlist[j].trim().split("-");
				selectField(fieldname[0]);
				clickOnElement(By.xpath("(//li[normalize-space(text())='" + fieldname[1].trim() + "'])[last()]"));
			}
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		String[] fieldlist = map.get(mapKeys.get(4)).toString().trim().split(",");
		for (int j = 0; j < fieldlist.length; j++) {
			String[] fieldname = fieldlist[j].trim().split("-");
			verifyVisible(By.xpath(String.format(fields, fieldname[0].trim(), fieldname[1].trim())), 0);
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(3)).toString())), 1);
	}

	public boolean editServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			String[] fieldlist = map.get(mapKeys.get(5)).toString().trim().split(",");
			for (int j = 0; j < fieldlist.length; j++) {
				clickOnElement(
						By.xpath("(//*[contains(@class,'node-action-buttons')]//*[contains(@class,'add')])[last()]"));
				String[] fieldname = fieldlist[j].trim().split("-");
				selectField(fieldname[0]);
				clickOnElement(By.xpath("(//li[normalize-space(text())='" + fieldname[1].trim() + "'])[last()]"));
			}
			selectStatus(map.get(mapKeys.get(3)).toString());
			common.clickOnSaveBtn();
			return true;
		} else
			return false;
	}

	public void verifyEditedServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		String[] fieldlist = map.get(mapKeys.get(5)).toString().trim().split(",");
		for (int j = 0; j < fieldlist.length; j++) {
			String[] fieldname = fieldlist[j].trim().split("-");
			verifyVisible(By.xpath(String.format(fields, fieldname[0].trim(), fieldname[1].trim())), 0);
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);
	}

	public boolean deleteServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	public boolean verifyDeletedServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), false);
		return verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortServiceProfile(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map,mapKeys);
	}
}
