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

public class PlatformConfigurationPouchPage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	String allowNegativeBalance = "yes";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath("//*[normalize-space(text())='" + ScriptConstants.STATUS
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtName = By.id(Utility.readJSFile("INPUT_POUCH_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_POUCH_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpPouchType = By.xpath("//*[@id='inputPouchType']//*[@class='ant-select-arrow']");
	String selectStatus = "//*[@id='" + Utility.readJSFile("INPUT_POUCH_STATUS", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("pouch.label.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("pouch.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String PouchType = "//*[normalize-space(text()) = 'Pouch Type']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("pouch.label.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String allowNegativeBlc = "//*[normalize-space(text()) = 'Allow Negative Balance']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_POUCH_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	String selectStatusEdit = "//*[@id='inputPouchStatus']//span[normalize-space(text())='%s']";
	By drpPouchTypeInSearch = By.xpath("//*[normalize-space(text())='" + ScriptConstants.POUCH_POUCHTYPE
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By selectNegativeBalance = By.xpath("//button[@id='inputAllowNegativeBalance']");
	By btnAddParameter = By.xpath("//*[text()='" + ScriptConstants.POUCH_ADDPARAMETERBUTTON + "']//parent::button");
	By drpAddParameter = By.xpath("(//*[contains(@id,'parameters')]//*[@class='ant-select-arrow'])[last()]");
	By txtDefaultValue = By.xpath("(//*[contains(@id,'defaultValue')])[last()]");
	By selectEditable = By.xpath("(//button[contains(@id,'isEditable')])[last()]");
	By selectMandatory = By.xpath("(//button[contains(@id,'isMandatory')])[last()]");
	String verifyParameterValue = "//tr[%s]//*[text()='%s']";
	String removeParameter = "(//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//parent::td//following-sibling::td//button[contains(@class,'delete')])[last()]";
	By verifyNegativeCheckOrNot = By.xpath("//*[@id='inputAllowNegativeBalance' and contains(@class,'checked')]");

	public PlatformConfigurationPouchPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectPouchType(String PouchType) {
		selectFromDropDown(drpPouchType, By.xpath(String.format(dropDownValue, PouchType)), 0);
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

	public void selectPouchTypeInFilterSearch(String PouchType) {
		selectFromDropDown(drpPouchTypeInSearch, By.xpath(String.format(dropDownValue, PouchType)), 0);
	}

	public void selectAllowNegativeBalance(String negativeBalance) {
		if (negativeBalance.toLowerCase().equals(allowNegativeBalance))
			clickOnElement(selectNegativeBalance, 1);
	}

	public void clickOnAddParameterBtn() {
		clickOnElement(btnAddParameter, 1);
	}

	public void selectParameter(String parameter) {
		selectFromDropDown(drpAddParameter, By.xpath(String.format(dropDownValue, parameter)), 2);
	}

	public void sendTextInDefaultValue(String defaultValue) {
		sendKeys(txtDefaultValue, defaultValue, 1);
	}

	public void selectEditable(String editable) {
		if (editable.toLowerCase().equals(allowNegativeBalance))
			clickOnElement(selectEditable, 1);
	}

	public void selectMandatory(String mandatory) {
		if (mandatory.toLowerCase().equals(allowNegativeBalance))
			clickOnElement(selectMandatory, 1);
	}

	public void removeParameter(String parameter) {
		clickOnElement(By.xpath(String.format(removeParameter, parameter.trim())), 0);
	}

	public void selectAllowNegativeBalanceInEdit(String negativeBalance) {
		if (negativeBalance.toLowerCase().equals(allowNegativeBalance))
			if (verifyVisible(verifyNegativeCheckOrNot, 1))
				clickOnElement(selectNegativeBalance, 1);
	}

	public void filterSearch(String name, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendKeys(txtNameInSearch, name, 0);
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 1);
		selectPouchTypeInFilterSearch(PouchType);
		common.clickOnFilterSearchBtn();
	}

	public void addPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectPouchType(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			selectAllowNegativeBalance(map.get(mapKeys.get(5)).toString());
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				String[] parameterList = map.get(mapKeys.get(6)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(7)).toString().split(",");
				String[] visible = map.get(mapKeys.get(8)).toString().split(",");
				String[] manadatory = map.get(mapKeys.get(9)).toString().split(",");
				for (int i = 0; i < parameterList.length; i++) {
					clickOnAddParameterBtn();
					selectParameter(parameterList[i].trim());
					sendTextInDefaultValue(defaultValueList[i].trim());
					selectMandatory(manadatory[i].trim());
					selectEditable(visible[i].trim());
				}
			}
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(PouchType, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(allowNegativeBlc, map.get(mapKeys.get(3)).toString())), 0);
		if (!map.get(mapKeys.get(6)).toString().equals("")) {
			String[] parameterList = map.get(mapKeys.get(6)).toString().split(",");
			String[] defaultValueList = map.get(mapKeys.get(7)).toString().split(",");
			for (int i = 0; i < parameterList.length; i++) {
				verifyVisible(By.xpath(String.format(verifyParameterValue, i + 1, parameterList[i])), 1);
				verifyVisible(By.xpath(String.format(verifyParameterValue, i + 1, defaultValueList[i])), 1);
			}
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);
	}

	public boolean editPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectAllowNegativeBalance(map.get(mapKeys.get(5)).toString());
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				String[] removelist = map.get(mapKeys.get(6)).toString().split(",");
				for (String parameter : removelist) {
					removeParameter(parameter);
				}
			}
			if (!map.get(mapKeys.get(7)).toString().equals("")) {
				String[] parameterList = map.get(mapKeys.get(7)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(8)).toString().split(",");
				String[] visible = map.get(mapKeys.get(9)).toString().split(",");
				String[] manadatory = map.get(mapKeys.get(10)).toString().split(",");
				for (int i = 0; i < parameterList.length; i++) {
					clickOnAddParameterBtn();
					selectParameter(parameterList[i].trim());
					sendTextInDefaultValue(defaultValueList[i].trim());
					selectMandatory(manadatory[i].trim());
					selectEditable(visible[i].trim());
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(4)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(PouchType, map.get(mapKeys.get(4)).toString())), 0);
		if (!map.get(mapKeys.get(7)).toString().equals("")) {
			String[] parameterList = map.get(mapKeys.get(7)).toString().split(",");
			String[] defaultValueList = map.get(mapKeys.get(8)).toString().split(",");
			for (int i = 0; i < parameterList.length; i++) {
				verifyVisible(By.xpath(String.format(verifyParameterValue, i + 1, parameterList[i])), 1);
				verifyVisible(By.xpath(String.format(verifyParameterValue, i + 1, defaultValueList[i])), 1);
			}
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1);

	}

	public boolean deletePouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
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

	public boolean verifyDeletedPouch(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())));
	}

	public boolean sortPouch(Map<Object, Object> map, List<Object> mapKeys) {
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
