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

public class PlatformConfigurationServicePage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By txtName = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpServiceType = By.xpath("//*[@id='inputServicesAddServiceType']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath("//*[normalize-space(text())='" + ScriptConstants.STATUS
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By
			.id(Utility.readJSFile("INPUT_SERVICES_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpServiceTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Service Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpServiceTypeInEdit = By.xpath("//*[@id='inputServicesAddServiceType']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtOTPTimeOut = By.id("inputServiceAddsTimeout");
	By drpParameter = By.xpath("(//*[contains(@id,'parameters')]//*[@class='ant-select-arrow'])[last()]");
	By txtDefaultValue = By.xpath("(//*[contains(@id,'defaultValue')])[last()]");
	By btnAddParameter = By
			.xpath("//*[normalize-space(text())='" + ScriptConstants.SERVICE_ADDPARAMETERBUTTON + "']//parent::button");
	By txtOTPTimeOutInEdit = By.id("inputServiceEditsTimeout");
	String drpStatus = "//*[@id='inputServicesStatus']//span[normalize-space(text())='%s']";
	String drpStatusInEdit = "//*[@id='inputServicesStatus']//span[normalize-space(text())='%s']";
	By selectTwofactorEnable = By.xpath("(//*[contains(@id,'inputServiceAddstwoStepEnable')])[last()]");
	By selectBalanceReserv = By.xpath("(//*[contains(@id,'inputServiceAddsreservationEnable')])[last()]");
	By selectTwofactorEnableInEdit = By.xpath("(//*[contains(@id,'inputServiceEditstwoStepEnable')])[last()]");
	By selectBalanceReservInEdit = By.xpath("(//*[contains(@id,'inputServiceEditsreservationEnable')])[last()]");
	By selectVisible = By.xpath("(//*[contains(@id,'visibility')])[last()]");
	By verifyVisible = By.xpath("(//*[contains(@id,'visibility') and contains(@class,'checked')])[last()]");
	By selectMandatory = By.xpath("(//*[contains(@id,'isMandatory')])[last()]");
	By verifyMandatory = By.xpath("(//*[contains(@id,'isMandatory') and contains(@class,'checked')])[last()]");
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("services.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("services.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String serviceType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("services.label.servicetype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("services.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	public PlatformConfigurationServicePage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void selectServiceType(String serviceType) {
		selectFromDropDown(drpServiceType, By.xpath(String.format(dropDownValue, serviceType)), 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(drpStatusInEdit, status)), 1);
	}

	public void selectServiceTypeInEdit(String serviceType) {
		selectFromDropDown(drpServiceTypeInEdit, By.xpath(String.format(dropDownValue, serviceType)), 0);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 0);
	}

	public void selectIsTwoStepEnable(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(selectTwofactorEnable, 1);
		}
	}

	public void selectIsBalanceReservation(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(selectTwofactorEnable, 1);
		}
	}

	public void sendTextInOTPTimeOut(String timeout) {
		sendKeys(txtOTPTimeOut, timeout, 0);
	}

	public void selectIsTwoStepEnableInEdit(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(selectTwofactorEnableInEdit, 1);
		}
	}

	public void selectIsBalanceReservationInEdit(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			clickOnElement(selectBalanceReservInEdit);
		}
	}

	public void sendTextInOTPTimeOutInEdit(String timeout) {
		sendKeys(txtOTPTimeOutInEdit, timeout);
	}

	public void selectParameter(String parameter) {
		selectFromDropDown(drpParameter, By.xpath(String.format(dropDownValue, parameter)), 1);
	}

	public void sendTextInDefaultValue(String defaultValue) {
		sendKeys(txtDefaultValue, defaultValue);
	}

	public void selectIsVisible(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			if (!verifyVisible(verifyVisible, 1)) {
				clickOnElement(selectVisible, 1);
			}
		}
	}

	public void selectIsMandatory(String value) {
		if (value.equalsIgnoreCase(IsYes)) {
			if (!verifyVisible(verifyMandatory)) {
				clickOnElement(selectMandatory);
			}
		}
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		common.clickOnFilterSearchBtn();
	}
	
	public void addService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectServiceType(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				selectIsTwoStepEnable(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				selectIsBalanceReservation(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(7)).toString().equals("")) {
				sendTextInOTPTimeOut(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().equals("")) {
				String[] parameteList = map.get(mapKeys.get(8)).toString().split(",");
				String[] DefaultValueList = map.get(mapKeys.get(9)).toString().split(",");
				String[] VisibleList = map.get(mapKeys.get(10)).toString().split(",");
				String[] MandatoryList = map.get(mapKeys.get(11)).toString().split(",");
				for (int i = 0; i < parameteList.length; i++) {
					clickOnElement(btnAddParameter);
					selectParameter(parameteList[i].trim());
					sendTextInDefaultValue(DefaultValueList[i].trim());
					selectIsVisible(VisibleList[i].trim());
					selectIsMandatory(MandatoryList[i].trim());
				}
			}
			selectStatus(map.get(mapKeys.get(4)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
			verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
			verifyVisible(By.xpath(String.format(serviceType, map.get(mapKeys.get(2)).toString())), 0);
			verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(2)).toString())), 1);
			return true;
		} else {
			return false;
		}
	}

	public boolean editService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectServiceTypeInEdit(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				selectIsTwoStepEnableInEdit(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(7)).toString().equals("")) {
				selectIsBalanceReservationInEdit(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().equals("")) {
				sendTextInOTPTimeOut(map.get(mapKeys.get(8)).toString());
			}
			if (!map.get(mapKeys.get(9)).toString().equals("")) {
				String[] parameteList = map.get(mapKeys.get(9)).toString().split(",");
				String[] DefaultValueList = map.get(mapKeys.get(10)).toString().split(",");
				String[] VisibleList = map.get(mapKeys.get(11)).toString().split(",");
				String[] MandatoryList = map.get(mapKeys.get(12)).toString().split(",");
				for (int i = 0; i < parameteList.length; i++) {
					clickOnElement(btnAddParameter);
					selectParameter(parameteList[i].trim());
					sendTextInDefaultValue(DefaultValueList[i].trim());
					selectIsVisible(VisibleList[i].trim());
					selectIsMandatory(MandatoryList[i].trim());
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEditedService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(1)).toString())), 0);
			verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(2)).toString())), 0);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteService(Map<Object, Object> map, List<Object> mapKeys) {
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

	public boolean verifyDeletedService(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())));
	}

	public boolean sortService(Map<Object, Object> map, List<Object> mapKeys) {
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
