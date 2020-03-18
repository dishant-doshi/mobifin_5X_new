package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationAccessChannelPage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	By txtName = By.id(Utility.readJSFile("INPUT_ACCESSCHANNEL_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_ACCESSCHANNEL_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By txtSecret = By.id("inputAccesschannelSecret");
	By txtConfirmSecret = By.id("inputAccesschannelConfirmSecret");
	By txtAccessToken = By.id("inputAccesschannelAccessTokenValidity");
	By drpAccessChannelType = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_WALLET_WALLETTYPE", CommonConstants.ELEMENT_FILE) + "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_ACCESSCHANNEL_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpAccessChannelTypeInSearch = By.xpath(
			"//*[normalize-space(text())='AccessChannel Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");

	String accessChannelStatus = "//*[@id='inputAccesschannelStatus']//span[normalize-space(text())='%s']";
	String statusVal = "(//*[normalize-space(text())='%s'])[last()]";
	By dropDown = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By dropDownVal2 = By.xpath("//li[normalize-space(text())='Equals']");
	
	String grantList = "//*[normalize-space(text())='%s']//following-sibling::td//span[@class='ant-checkbox']";
	String grantListVal = "//*[normalize-space(text())='%s']//following-sibling::td//i[contains(@class,'success')]";
	
	
	String nameVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("accesschannel.name", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String descVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("accesschannel.description", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String statsVal = "//*[normalize-space(text()) = '" + Utility.readJSFile("accesschannel.status", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	
	String editGrantListVal = "//*[normalize-space(text())='%s']//following-sibling::td//span[@class='ant-checkbox']";
	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 31/07/2019
	 */
	public PlatformConfigurationAccessChannelPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name,0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description);
	}

	public void sendTextInSecret(String secret) {
		sendKeys(txtSecret, secret);
	}

	public void sendTextInConfirmSecret(String confirmSecret) {
		sendKeys(txtConfirmSecret, confirmSecret);
	}

	public void sendTextInAccessTokenValidity(String accessTokenValidity) {
		sendKeys(txtAccessToken, accessTokenValidity);
	}

	public void selectStatus(String status) {
			clickOnElement(By.xpath(String.format(accessChannelStatus, status.trim())),1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void selectGrantType(By element) {
		clickOnElement(element);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(statusVal, status.trim())), 1);
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			selectFromDropDown(dropDown, dropDownVal2);
		}
		sendTextInNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		common.clickOnFilterSearchBtn();
	}

	/**
	 * @author shivani.patel Create addAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public void addAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			sendTextInSecret(map.get(mapKeys.get(3)).toString());
			sendTextInConfirmSecret(map.get(mapKeys.get(3)).toString());
			sendTextInAccessTokenValidity(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				String[] grantTypelist = map.get(mapKeys.get(5)).toString().trim().split(",");
				for (int i = 0; i < grantTypelist.length; i++) {
					selectGrantType(By.xpath(String.format(grantList, grantTypelist[i].trim())));
				}
			}
			selectStatus(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		By name =  By.xpath(String.format(nameVal, map.get(mapKeys.get(1)).toString()));
		By description = By.xpath(String.format(descVal, map.get(mapKeys.get(2)).toString()));
		By status = By.xpath(String.format(statsVal, map.get(mapKeys.get(6)).toString()));

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			
			verifyVisible(name, 0);
			verifyVisible(description, 0);
			
			String[] grantTypelist = map.get(mapKeys.get(5)).toString().trim().split(",");
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				for (int i = 0; i < grantTypelist.length; i++) {
					verifyVisible(By.xpath(String.format(grantListVal, grantTypelist[i].trim())), 0);
				}
			}
			verifyVisible(status, 1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create editAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param mapKeys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean editAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			
			
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				sendTextInAccessTokenValidity(map.get(mapKeys.get(3)).toString());
			}
			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				String[] grantTypelist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int i = 0; i < grantTypelist.length; i++) {
					selectGrantType(By.xpath(String.format(editGrantListVal, grantTypelist[i].trim())));
				}
			}
			selectStatus(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEditedAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		By description = By.xpath(String.format(descVal, map.get(mapKeys.get(2)).toString()));
		By status = By.xpath(String.format(statsVal, map.get(mapKeys.get(6)).toString()));

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			verifyVisible(description, 0);

			if (!map.get(mapKeys.get(4)).toString().equals("")) {
				String[] grantTypelist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int i = 0; i < grantTypelist.length; i++) {
					verifyVisible(By.xpath(String.format(grantListVal, grantTypelist[i].trim())), 0);
				}
			}
			verifyVisible(status, 1);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author shivani.patel Create deleteAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean deleteAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "AccessChannel already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	/**
	 * @author shivani.patel Create verify deleteAccessChannel Method
	 * @param map
	 *            - excel values use for get value
	 * @param keys
	 *            - excel header use for to identify value
	 * @creation date 31/07/2019
	 */
	public boolean verifyDeletedAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())),0);
	}

	public boolean sortAccessChannel(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}
}
