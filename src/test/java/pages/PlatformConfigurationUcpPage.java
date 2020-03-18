package pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationUcpPage extends SetupInit {
	private CommonPage common;
	By txtName = By.id(Utility.readJSFile("INPUT_UCP_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_UCP_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By txtValue = By.id(Utility.readJSFile("INPUT_UCP_ADD_VALUE", CommonConstants.ELEMENT_FILE));
	By txtAccessToken = By.id("inputAccesschannelAccessTokenValidity");
	By drpUnitType = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_UCP_ADD_UNITTYPE", CommonConstants.ELEMENT_FILE) + "']//*[@class='ant-select-arrow']");
	By drpUnitTypeInEdit = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_UNITTYPE", CommonConstants.ELEMENT_FILE) + "']//*[@class='ant-select-arrow']");
	By drpCreditType = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_UCP_ADD_CREDITTYPE", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By drpCreditTypeInEdit = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_CREDITTYPE", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By drpCreditOn = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_UCP_ADD_CREDITON", CommonConstants.ELEMENT_FILE) + "']//*[@class='ant-select-arrow']");
	By drpCreditOnInEdit = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_CREDITON", CommonConstants.ELEMENT_FILE) + "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpUnitTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Unit Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_UCP_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By txtValueInEdit = By.id(Utility.readJSFile("INPUT_UCP_EDIT_VALUE", CommonConstants.ELEMENT_FILE));
	By drpUcpTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Ucp Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpUnit = By.xpath("//*[@class='ant-select ant-select-enabled ant-select-allow-clear']//li");
	By drpUnitInEdit = By.xpath("//input[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_UNIT", CommonConstants.ELEMENT_FILE) + "']");
	By removeUnit = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_UNIT", CommonConstants.ELEMENT_FILE)
			+ "']//ancestor :: span[contains(@class,'choice__remove')]");
	
	String inputUCPAndStatus = "//*[@id='" + Utility.readJSFile("INPUT_UCP_ADD_STATUS", CommonConstants.ELEMENT_FILE)
	+ "']//span[normalize-space(text())='%s']";
	
	String unitTypeValue = "(//li[normalize-space(text())='%s'])[last()]";
	String creditTypeValue = "(//*[normalize-space(text())='%s'])[last()]";
	String creditOnValue = "(//*[normalize-space(text())='%s'])[last()]";
	String statusVal = "//*[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_STATUS", CommonConstants.ELEMENT_FILE)
	+ "']//span[normalize-space(text())='%s']";
	
	String unitTypeValInFilterSearch = "(//*[normalize-space(text())='%s'])[last()]";
	String statusValInFlterSearch =  "(//*[normalize-space(text())='%s'])[last()]";
	By dropDown = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By dropDownVal2 = By.xpath("//li[normalize-space(text())='Equals']");
	
	String addUCPLoc =  "(//td[text()='%s'])[1]";
	
	String nameVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.name", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String descValue = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.description", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String unitTypeVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.unittype", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String creditTypeVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.credittype", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String addUcpVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.value", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String creditOnVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.crediton", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String ucpStatusVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.status", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String unitListVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("ucp.label.unit", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";

	public PlatformConfigurationUcpPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description);
	}

	public void sendTextInValue(String value) {
		sendKeys(txtValue, value);
	}

	public void sendTextInValueInEdit(String value) {
		sendKeys(txtValueInEdit, value);
	}

	public void selectUnitType(String unitType) {
		selectFromDropDown(drpUnitType, By.xpath(String.format(unitTypeValue, unitType.trim())));
	}

	public void selectUnitTypeInEdit(String unitType) {
		selectFromDropDown(drpUnitTypeInEdit, By.xpath(String.format(unitTypeValue, unitType.trim())));
	}

	public void selectCreditType(String creditType) {
		selectFromDropDown(drpCreditType, By.xpath(String.format(creditTypeValue, creditType.trim())));
	}

	public void selectCreditTypeInEdit(String creditType) {
		selectFromDropDown(drpCreditTypeInEdit, By.xpath(String.format(creditTypeValue, creditType.trim())));
	}

	public void selectCreditOn(String creditOn) {
		selectFromDropDown(drpCreditOn, By.xpath(String.format(creditOnValue, creditOn.trim())));
	}

	public void selectCreditOnInEdit(String creditOn) {
		selectFromDropDown(drpCreditOnInEdit, By.xpath(String.format(creditOnValue, creditOn.trim())));
	}

	public void selectUnit(String unit) {
		clickOnElement(By.xpath(String.format(unitTypeValue, unit.trim())));
	}

	public void clickOnRemoveUnitIcon() {
		clickOnElement(removeUnit);
	}

	public void selectStatus(String status) {
			clickOnElement(By.xpath(String.format(inputUCPAndStatus, status.trim())),1);
	}

	public void selectStatusInEdit(String status) {
			clickOnElement(By.xpath(String.format(statusVal, status.trim())),1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectUnitTypeInFilterSearch(String unitType) {
		selectFromDropDown(drpUnitTypeInSearch,By.xpath(String.format(unitTypeValInFilterSearch, unitType.trim())));
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(statusValInFlterSearch, status.trim())),1);
	}

	public void filterSearch(String str1, String str2, String str3, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			selectFromDropDown(dropDown, dropDownVal2);
		}
		sendTextInNameFilterSearch(str1);
		selectUnitTypeInFilterSearch(str2);
		selectStatusInFilterSearch(str3);
		common.clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void addUcp(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(8)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(addUCPLoc, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			selectUnitType(map.get(mapKeys.get(2)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			selectCreditType(map.get(mapKeys.get(4)).toString());
			if (map.get(mapKeys.get(4)).toString().toLowerCase().equals("percentage")) {
				selectCreditOn(map.get(mapKeys.get(6)).toString());
				if (!map.get(mapKeys.get(6)).toString().toLowerCase().equals("amount")) {
					String[] unitlist = map.get(mapKeys.get(7)).toString().trim().split(",");
					clickOnElement(drpUnit);
					for (int i = 0; i < unitlist.length; i++) {
						selectUnit(unitlist[i].trim());
					}
				}
			}
			sendTextInValue(map.get(mapKeys.get(5)).toString());
			selectStatus(map.get(mapKeys.get(8)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedUcp(Map<Object, Object> map, List<Object> mapKeys) {
		By name = By.xpath(String.format(nameVal, map.get(mapKeys.get(1)).toString()));
		By unitType = By.xpath(String.format(unitTypeVal, map.get(mapKeys.get(2)).toString()));
		By description = By.xpath(String.format(descValue, map.get(mapKeys.get(3)).toString()));
		By creditType = By.xpath(String.format(creditTypeVal, map.get(mapKeys.get(4)).toString()));
		By value = By.xpath(String.format(addUcpVal, map.get(mapKeys.get(5)).toString()));
		By creditOn = By.xpath(String.format(creditOnVal, map.get(mapKeys.get(6)).toString()));
		By status = By.xpath(String.format(ucpStatusVal, map.get(mapKeys.get(8)).toString()));

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(8)).toString(), true);
		if (verifyVisible(By.xpath(String.format(addUCPLoc, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			verifyVisible(name, 0);
			verifyVisible(description, 0);
			verifyVisible(unitType, 0);
			verifyVisible(creditType, 0);
			
			if (map.get(mapKeys.get(4)).toString().toLowerCase().equals("percentage")) {
				verifyVisible(creditOn, 0);
				if (!map.get(mapKeys.get(6)).toString().toLowerCase().equals("amount")) {
					String[] unitlist = map.get(mapKeys.get(7)).toString().trim().split(",");
					for (int i = 0; i < unitlist.length; i++) {
						verifyVisible(By.xpath(String.format(unitListVal, unitlist[i].trim())),0);
					}
				}
			}
			verifyVisible(value, 0);
			verifyVisible(status, 1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean editUcp(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(9)).toString(), true);
		if (verifyVisible(By.xpath(String.format(addUCPLoc, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			
			selectUnitTypeInEdit(map.get(mapKeys.get(3)).toString());
			sendTextInDescriptionInEdit(map.get(mapKeys.get(4)).toString());
			selectCreditTypeInEdit(map.get(mapKeys.get(5)).toString());
			if (map.get(mapKeys.get(5)).toString().toLowerCase().equals("percentage")) {
				selectCreditOnInEdit(map.get(mapKeys.get(7)).toString());
				if (!map.get(mapKeys.get(7)).toString().toLowerCase().equals("amount")) {
					String[] unitlist = map.get(mapKeys.get(8)).toString().trim().split(",");
					if (verifyVisible(removeUnit)) {
						clickOnRemoveUnitIcon();
					}
					clickOnElement(drpUnitInEdit);
					for (int i = 0; i < unitlist.length; i++) {
						selectUnit(unitlist[i].trim());
					}
				}
			}
			sendTextInValueInEdit(map.get(mapKeys.get(6)).toString());
			selectStatusInEdit(map.get(mapKeys.get(10)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEditedUcp(Map<Object, Object> map, List<Object> mapKeys) {

		By description = By.xpath(String.format(descValue, map.get(mapKeys.get(4)).toString()));
		By unitType = By.xpath(String.format(unitTypeVal, map.get(mapKeys.get(3)).toString()));
		By creditType = By.xpath(String.format(creditTypeVal, map.get(mapKeys.get(5)).toString()));

		By value = By.xpath(String.format(addUcpVal, map.get(mapKeys.get(6)).toString()));
		By creditOn = By.xpath(String.format(creditOnVal, map.get(mapKeys.get(7)).toString()));
		By status = By.xpath(String.format(ucpStatusVal, map.get(mapKeys.get(1)).toString()));
		
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(10)).toString(), true);
		if (verifyVisible(By.xpath(String.format(addUCPLoc, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			
			verifyVisible(description, 0);
			verifyVisible(unitType, 0);
			verifyVisible(creditType, 0);
			
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				if (map.get(mapKeys.get(5)).toString().toLowerCase().equals("percentage")) {
					verifyVisible(creditOn, 0);
					if (!map.get(mapKeys.get(7)).toString().equals("")) {
						if (!map.get(mapKeys.get(7)).toString().toLowerCase().equals("amount")) {
							String[] unitlist = map.get(mapKeys.get(8)).toString().trim().split(",");
							for (int i = 0; i < unitlist.length; i++) {
								verifyVisible(By.xpath(String.format(unitListVal, unitlist[i].trim())),0);
							}
						}
					}
				}
			}
			verifyVisible(value, 0);
			verifyVisible(status, 1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create deleteUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean deleteUcp(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(addUCPLoc, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "Ucp already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteUcp Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean verifyDeletedUcp(Map<Object, Object> map, List<Object> mapKeys) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
					map.get(mapKeys.get(3)).toString(), true);
			return verifyVisible(By.xpath(String.format(addUCPLoc, map.get(mapKeys.get(1)).toString())),0);
	}

	public boolean sortUcp(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}
}
