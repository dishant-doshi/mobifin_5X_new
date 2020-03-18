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

public class PlatformConfigurationUnitPage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath("//*[normalize-space(text())='" + ScriptConstants.UNIT_STATUS
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtName = By.id(Utility.readJSFile("INPUT_UNIT_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_UNIT_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUnitType = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_UNIT_ADD_UNITTYPE", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	String selectStatus = "//*[@id='inputUnitSTATUS']//span[normalize-space(text())='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("unit.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("unit.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String unitType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("unit.unittype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '" + Utility.readJSFile("unit.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_UNIT_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUnitTypeInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_UNIT_EDIT_UNITTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	String selectStatusEdit = "//*[@id='inputUnitStatus']//span[normalize-space(text())='%s']";
	By drpUnitTypeInSearch = By.xpath("//*[normalize-space(text())='" + ScriptConstants.UNIT_UNITTYPE
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");

	public PlatformConfigurationUnitPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectUnitType(String UnitType) {
		selectFromDropDown(drpUnitType, By.xpath(String.format(dropDownValue, UnitType)), 0);
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

	public void selectUnitTypeInEdit(String unitType) {
		selectFromDropDown(drpUnitTypeInEdit, By.xpath(String.format(dropDownValue, unitType)), 0);
	}

	public void selectUnitTypeInFilterSearch(String unitType) {
		selectFromDropDown(drpUnitTypeInSearch, By.xpath(String.format(dropDownValue, unitType)), 0);
	}

	public void filterSearch(String name, String unitType, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendKeys(txtNameInSearch, name, 0);
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 1);
		selectUnitTypeInFilterSearch(unitType);
		common.clickOnFilterSearchBtn();
	}

	public void addUnit(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUnitType(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedUnit(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(unitType, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);
	}

	public boolean editUnit(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(5)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			selectUnitTypeInEdit(map.get(mapKeys.get(4)).toString());
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectStatusInEdit(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedUnit(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(),
				map.get(mapKeys.get(6)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(unitType, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(6)).toString())), 1);

	}

	public boolean deleteUnit(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
	}

	public boolean verifyDeletedUnit(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())));
	}

	public boolean sortUnit(Map<Object, Object> map, List<Object> mapKeys) {
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
