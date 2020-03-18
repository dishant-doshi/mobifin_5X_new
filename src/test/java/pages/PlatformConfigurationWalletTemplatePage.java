package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import bsh.util.Util;
import utils.Utility;

public class PlatformConfigurationWalletTemplatePage extends SetupInit {
	private CommonPage common;
	By txtName = By.id("inputWalletTemplateName");
	By txtDescription = By.id("inputWalletTemplateDescription");
	By txtSecret = By.id("inputAccesschannelSecret");
	By txtConfirmSecret = By.id("inputAccesschannelConfirmSecret");
	By txtAccessToken = By.id("inputAccesschannelAccessTokenValidity");
	By drpWalletTemplateType = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_WALLET_WALLETTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id("inputWalletTemplateDescription");
	By drpWalletTemplateTypeInSearch = By.xpath(
			"//*[normalize-space(text())='WalletTemplate Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpWallet = By.xpath("(//*[contains(@id,'walletFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnAddField = By
			.xpath("//*[normalize-space(text())='" + ScriptConstants.WALLETTEMPLATE_ADDFIELD + "']//parent::button");
	String drpStatus = "//*[@id='inputWalletTemplateStatus']//span[normalize-space(text())='%s']";
	String drpStatusInEdit = "//*[@id='inputWalletTemplateStatus']//span[normalize-space(text())='%s']";
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By selectPouch = By.xpath("(//*[contains(@id,'pouchFields')]//*[@class='ant-select-search__field'])[last()]");
	By selectWallet = By.xpath("(//*[contains(@id,'walletFields')]//*[@class='ant-select-search__field'])[last()]");
	String name = "//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String verifyWallet = "//tr[%s]//*[normalize-space(text())='%s']";
	String verifyPouch = "//tr[1]//*[contains(text(),'%s')]";

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 31/07/2019
	 */
	public PlatformConfigurationWalletTemplatePage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
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

	public void selectGrantType(By element) {
		clickOnElement(element);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 1);
	}

	public void selectWallet(String wallet) {
		clickOnElement(drpWallet);
		sendKeys(selectWallet, wallet + Keys.ENTER, 0);
	}

	public void selectPouch(String pouch) {
		sendKeys(selectPouch, pouch + Keys.ENTER, 0);
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

	public void addWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] wallet = map.get(mapKeys.get(5)).toString().split("/");
			String[] pouchList = map.get(mapKeys.get(6)).toString().split("/");
			for (int j = 0; j < rows; j++) {
				selectWallet(wallet[j].trim());
				String[] pouch = pouchList[j].split(",");
				for (int i = 0; i < pouch.length; i++) {
					selectPouch(pouch[i].trim());
				}
				if (j < rows - 1) {
					clickOnElement(btnAddField);
				}
			}
			selectStatus(map.get(mapKeys.get(3)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
			verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(3)).toString())), 0);
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] walletList = map.get(mapKeys.get(4)).toString().trim().split("/");
				String[] pouchList = map.get(mapKeys.get(4)).toString().trim().split("/");
				for (int i = 0; i < rows; i++) {
					verifyVisible(By.xpath(String.format(verifyWallet, (i + 1), walletList[i].trim())), 0);
					String[] pouch = pouchList[i].split(",");
					for (int j = 0; j < pouch.length; j++) {
						verifyVisible(By.xpath(String.format(verifyWallet, pouch[j].trim())), 0);
					}
				}
			}
			verifyVisible(By.xpath(String.format(status,  map.get(mapKeys.get(3)).toString())), 1);
		}
	}

	public boolean editWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectStatus(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEditedWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
			verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
	}

	public boolean verifyDeletedWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);

	}

	public boolean sortWalletTemplate(Map<Object, Object> map, List<Object> mapKeys) {
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
