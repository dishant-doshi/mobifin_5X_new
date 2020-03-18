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

public class BusinessConfigurationNotificationPage extends SetupInit {
	private CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtNotificationName = By.id(Utility.readJSFile("INPUT_NOTIFICATION_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_NOTIFICATION_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpNotificationType = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_NOTIFICATION_ADD_NOTIFICATIONTYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By txtSubject = By.id("inputNotificationAddSubject");
	By txtFromUserName = By.id("inputNotificationAddUsername");
	By txtPassword = By.id("inputNotificationAddPassword");
	By txtCC = By.id("btnNotificationAddCCBtn");
	By txtBCC = By.id("btnNotificationAddBCCBtn");
	By drpNotificationTemplate = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_NOTIFICATION_ADD_NOTIFICATIONTMP", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpVendor = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_NOTIFICATION_ADD_VENDOR", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpVendorService = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_NOTIFICATION_ADD_VENDORSERVICE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By btnReceiverAdd = By.id(Utility.readJSFile("INPUT_NOTIFICATION_ADD_RECEIVERBTN", CommonConstants.ELEMENT_FILE));
	String txtreceiverName = "//*[@id='inputNotificationAddReciver[%s]']";
	String selectStatus = "//*[@id='"
			+ Utility.readJSFile("INPUT_NOTIFICATION_ADD_STATUS", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";
	String verifyReceiveName = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.receiver", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String notificationType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.notificatontype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String subject = "//*[normalize-space(text()) = 'Subject']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String fromUserName = "//*[normalize-space(text()) = 'From UserName']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String CC = "//*[normalize-space(text()) = 'CC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String BCC = "//*[normalize-space(text()) = 'BCC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String notificationTemplate = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.notificationtemplate", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String vendor = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.vendor", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String vendorService = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.vendorservice", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("notification.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String verifystatus = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("role.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	/**
	 * @author shivani.patel
	 * @param driver
	 *            constructor
	 * @creation date 24/09/2019
	 */
	public BusinessConfigurationNotificationPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInNotificationName(String name) {
		sendKeys(txtNotificationName, name, 0);
	}

	public void sendTextInDescription(String description) {

		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectNotificationType(String notificationType) {
		selectFromDropDown(drpNotificationType, By.xpath(String.format(dropDownValue, notificationType)), 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(selectStatus, status)), 1);
	}

	public void sendTextInSubject(String subject) {

		sendKeys(txtSubject, subject, 0);
	}

	public void sendTextInFromUserName(String fromUsername) {
		sendKeys(txtFromUserName, fromUsername, 0);
	}

	public void sendTextInCC(String cc) {
		sendKeys(txtCC, cc, 1);
	}

	public void sendTextInBCC(String bcc) {
		sendKeys(txtBCC, bcc, 1);
	}

	public void selectNotificationTemplate(String notificationTemplate) {
		selectFromDropDown(drpNotificationTemplate, By.xpath(String.format(dropDownValue, notificationTemplate)), 0);
	}

	public void selectVendor(String vendor) {
		selectFromDropDown(drpVendor, By.xpath(String.format(dropDownValue, vendor)), 0);
	}

	public void selectVendorService(String vendorService) {
		selectFromDropDown(drpVendorService, By.xpath(String.format(dropDownValue, vendorService)), 0);
	}

	public void sendTextInReceiverName(int m, String receiverName) {
		sendKeys(By.xpath(String.format(txtreceiverName, m)), receiverName, 0);
	}

	public void sendTextInNotificationNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void clickOnReceiverAddBtn() {
		clickOnElement(btnReceiverAdd, 1);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 0);
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNotificationNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		common.clickOnFilterSearchBtn();
	}

	public void addNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInNotificationName(map.get(mapKeys.get(1)).toString());
			sendTextInSubject(map.get(mapKeys.get(3)).toString());
			selectNotificationType(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
				sendTextInFromUserName(map.get(mapKeys.get(4)).toString());
				sendTextInCC(map.get(mapKeys.get(6)).toString());
				sendTextInBCC(map.get(mapKeys.get(7)).toString());
			}
			sendTextInDescription(map.get(mapKeys.get(8)).toString());
			selectNotificationTemplate(map.get(mapKeys.get(9)).toString());
			selectVendor(map.get(mapKeys.get(10)).toString());
			selectVendorService(map.get(mapKeys.get(11)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
			String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				sendTextInReceiverName(m, receiverNameList[m]);
				if (m < rows - 1) {
					clickOnReceiverAddBtn();
				}
			}
			selectStatus(map.get(mapKeys.get(14)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(map.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(subject, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(notificationType, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(verifystatus, map.get(mapKeys.get(14)).toString())), 1);
		if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
			verifyVisible(By.xpath(String.format(fromUserName, map.get(mapKeys.get(4)).toString())), 0);
			verifyVisible(By.xpath(String.format(CC, map.get(mapKeys.get(6)).toString())), 1);
			verifyVisible(By.xpath(String.format(BCC, map.get(mapKeys.get(7)).toString())), 1);
		}
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(8)).toString())), 0);
		verifyVisible(By.xpath(String.format(notificationTemplate, map.get(mapKeys.get(9)).toString())), 0);
		verifyVisible(By.xpath(String.format(vendor, map.get(mapKeys.get(10)).toString())), 0);
		verifyVisible(By.xpath(String.format(vendorService, map.get(mapKeys.get(11)).toString())), 0);
		String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
		for (int m = 0; m < receiverNameList.length; m++) {
			verifyVisible(By.xpath(String.format(verifyReceiveName, receiverNameList[m].trim())), 0);
		}
		verifyVisible(By.xpath(String.format(vendorService, map.get(mapKeys.get(14)).toString())), 0);
	}

	public boolean editNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(map.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInSubject(map.get(mapKeys.get(3)).toString());
			selectNotificationType(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
				sendTextInFromUserName(map.get(mapKeys.get(4)).toString());
				// sendTextInPassword(map.get(mapKeys.get(5)).toString());
				sendTextInCC(map.get(mapKeys.get(6)).toString());
				sendTextInBCC(map.get(mapKeys.get(7)).toString());
			}
			sendTextInDescription(map.get(mapKeys.get(8)).toString());
			selectNotificationTemplate(map.get(mapKeys.get(9)).toString());
			selectVendor(map.get(mapKeys.get(10)).toString());
			selectVendorService(map.get(mapKeys.get(11)).toString());
			if (!map.get(mapKeys.get(12)).toString().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
				String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					sendTextInReceiverName(m, receiverNameList[m]);
				}
			}
			selectStatus(map.get(mapKeys.get(15)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(map.get(1)).toString());
		verifyVisible(By.xpath(String.format(subject, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(notificationType, map.get(mapKeys.get(2)).toString())), 0);
		if (map.get(mapKeys.get(2)).toString().trim().toLowerCase().equals("email")) {
			verifyVisible(By.xpath(String.format(notificationType, map.get(mapKeys.get(4)).toString())), 0);
			verifyVisible(By.xpath(String.format(fromUserName, map.get(mapKeys.get(4)).toString())), 0);
			verifyVisible(By.xpath(String.format(CC, map.get(mapKeys.get(6)).toString())), 0);
			verifyVisible(By.xpath(String.format(BCC, map.get(mapKeys.get(7)).toString())), 0);
		}
		String[] receiverNameList = map.get(mapKeys.get(13)).toString().split(",");
		for (int m = 0; m < receiverNameList.length; m++) {
			verifyVisible(By.xpath(String.format(verifyReceiveName, receiverNameList[m].trim())), 0);
		}
		verifyVisible(By.xpath(String.format(verifystatus, map.get(mapKeys.get(15)).toString())), 0);
	}

	public boolean deleteNotification(Map<Object, Object> map, List<Object> mapKeys) {
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

	public boolean verifyDeletedNotification(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortNotification(Map<Object, Object> map, List<Object> mapKeys) {
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
