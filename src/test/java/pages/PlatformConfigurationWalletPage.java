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

public class PlatformConfigurationWalletPage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtName = By.id(Utility.readJSFile("INPUT_WALLET_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_WALLET_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpWalletType = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_WALLET_WALLETTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_WALLET_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpWalletTypeInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_WALLET_WALLETTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpWalletTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Wallet Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	String drpWallet = "//li[normalize-space(text())='%s']";
	String statusLoc = "//*[@id='inputWalletStatus']//span[normalize-space(text())='%s']";
	String statusInEdit = "//*[@id='inputWalletStatus']//span[normalize-space(text())='%s']";
	String drpDownStatusInSearchVal = "(//*[normalize-space(text())='%s'])[last()]";
	String drpWalletTypeVal = "//li[normalize-space(text())='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("wallet.grid.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("wallet.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	String walletType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("wallet.wallettype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '" + Utility.readJSFile("wallet.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	public PlatformConfigurationWalletPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void selectWalletType(String walletType) {
		selectFromDropDown(drpWalletType, By.xpath(String.format(drpWallet, walletType)), 0);
	}

	public void selectWalletTypeInEdit(String walletType) {
		selectFromDropDown(drpWalletTypeInEdit, By.xpath(String.format(drpWallet, walletType)), 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(statusLoc, status)), 1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(statusInEdit, status.trim())), 1);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(drpDownStatusInSearchVal, status.trim())), 1);
	}

	public void selectWalletTypeInFilterSearch(String walletType) {
		selectFromDropDown(drpWalletTypeInSearch, By.xpath(String.format(drpWalletTypeVal, walletType.trim())));
	}

	public void filterSearch(String str1, String str2, String str3, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNameFilterSearch(str1);
		selectWalletTypeInFilterSearch(str2);
		selectStatusInFilterSearch(str3);
		common.clickOnFilterSearchBtn();
	}

	public void addWallet(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectWalletType(map.get(mapKeys.get(3)).toString());
			selectStatus(map.get(mapKeys.get(4)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedWallet(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(4)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(map.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(walletType, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(2)).toString())), 1);
		return true;
	}

	public boolean editWallet(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(5)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectWalletTypeInEdit(map.get(mapKeys.get(4)).toString());
			selectStatusInEdit(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedWallet(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(),
				map.get(mapKeys.get(6)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(map.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(walletType, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(6)).toString())), 1);
	}

	public boolean deleteWallet(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
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

	public boolean verifyDeletedWallet(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortWallet(Map<Object, Object> map, List<Object> mapKeys) {
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
