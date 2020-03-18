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

public class PlatformConfigurationRulePage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath("//*[normalize-space(text())='" + ScriptConstants.STATUS
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtName = By.id(Utility.readJSFile("INPUT_RULE_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_RULE_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	String selectStatus = "//*[@id='inputRuleAddStatus']//span[normalize-space(text())='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("rule.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("rule.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String expression = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("rule.expression", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '" + Utility.readJSFile("Rule.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_RULE_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	String selectStatusEdit = "//*[@id='inputRuleEditStatus']//span[normalize-space(text())='%s']";
	By txtExpression = By.id(Utility.readJSFile("INPUT_RULE_ADD_EXPRESSION", CommonConstants.ELEMENT_FILE));
	By txtExpressionInEdit = By.id(Utility.readJSFile("INPUT_RULE_EDIT_EXPRESSION", CommonConstants.ELEMENT_FILE));

	public PlatformConfigurationRulePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInExpression(String expression) {
		sendKeys(txtExpression, expression, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(selectStatus, status)), 1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(selectStatusEdit, status)), 1);
	}

	public void sendTextInExpressionInEdit(String expression) {
		sendKeys(txtExpressionInEdit, expression, 0);
	}

	public void filterSearch(String name, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendKeys(txtNameInSearch, name, 0);
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 1);
		common.clickOnFilterSearchBtn();
	}

	public void addRule(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			sendTextInExpression(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedRule(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(expression, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);
	}

	public boolean editRule(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			sendTextInExpressionInEdit(map.get(mapKeys.get(3)).toString());
			selectStatusInEdit(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedRule(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(expression, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(6)).toString())), 1);

	}

	public boolean deleteRule(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyDeletedRule(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortRule(Map<Object, Object> map, List<Object> mapKeys) {
		Map<String, List<String>> getBeforeSortTableData = common.getTableData(map.get(mapKeys.get(2)).toString());
		common.clickOnSortBtn(map.get(mapKeys.get(0)).toString(), map.get(mapKeys.get(1)).toString());
		List<String> sortedUIColumnData = common.getColumnData(map.get(mapKeys.get(0)).toString());
		List<String> sortedUIColumnDataCopy = new ArrayList<>(sortedUIColumnData);
		common.sortColumn(sortedUIColumnData, map.get(mapKeys.get(1)).toString());
		if (!Utility.compareTwoLists(sortedUIColumnData, sortedUIColumnDataCopy))
			return false;
		Map<String, List<String>> getAfterSortTableData = common.getTableData(map.get(mapKeys.get(2)).toString());
		if (!getBeforeSortTableData.equals(getAfterSortTableData))
			return false;
		return true;
	}
}
