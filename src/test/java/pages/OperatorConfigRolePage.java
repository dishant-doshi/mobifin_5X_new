package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class OperatorConfigRolePage extends SetupInit {
	CommonPage common;
	By txtRoleName = By.id(Utility.readJSFile("INPUT_ROLES_ADD_ROLES", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_ROLES_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUserCategory = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_ROLE_USER_CATEGORY", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUsedBy = By.xpath("//*[@id='inputRoleAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	String drpUserCategoryValue = "//li[normalize-space(text())='%s']";
	String drpStatus = "//*[@id='inputrolesAddStatus']//span[normalize-space(text())='%s']";
	By selectAll = By.xpath("//*[normalize-space(text())='Select All']");
	String drpStatusEdit = "//*[@id='inputrolesEditStatus']//span[normalize-space(text())='%s']";
	private By mandatory = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDMANDATORY", CommonConstants.ELEMENT_FILE)
			+ "')])[last()]");
	private By editable = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDEDITABLE", CommonConstants.ELEMENT_FILE)
			+ "')])[last()]");
	String drpValues = "(//li[normalize-space(text())='%s'])[last()]";
	private By downArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	private By equals = By.xpath("//li[normalize-space(text())='Equals']");
	String verify = "//*[text()='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("role.label.role", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("role.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String userCategory = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("role.label.usercategory", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '" + Utility.readJSFile("role.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	public OperatorConfigRolePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInRoleName(String name) {
		sendKeys(txtRoleName, name);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void selectUserCategory(String userCategory) {
		selectFromDropDown(drpUserCategory, By.xpath(String.format(drpUserCategoryValue, userCategory)), 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 1);
	}

	public void clickOnSelectAll() {
		clickOnElement(selectAll);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(drpStatusEdit, status)), 1);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes))
			clickOnElement(mandatory, 0);
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes))
			clickOnElement(editable, 0);
	}

	public void sendTextInRoleNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(drpValues, status)), 1);
	}

	public void filterSearch(String roleName, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString)
			selectFromDropDown(downArrow, equals, 0);
		sendTextInRoleNameFilterSearch(roleName);
		selectStatusInFilterSearch(status);
		common.clickOnFilterSearchBtn();
	}

	public void addRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInRoleName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			clickOnSelectAll();
			common.clickOnSaveBtn();
		}

	}

	public void verifyAddedRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(userCategory, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);
	}

	public boolean editRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(userCategory, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(5)).toString())), 1);
	}

	public boolean deleteRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
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

	public boolean verifyDeletedRole(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		return verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortRole(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}
}
