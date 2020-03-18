package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationNotificationTemplatePage extends SetupInit {

	By txtName = By.id(Utility.readJSFile("INPUT_NOTIFICATION_TEMPLATE_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtTemplate = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_NOTIFICATION_TEMPLATE_ADD_TEMPLATE", CommonConstants.ELEMENT_FILE)
			+ "']//div[@class='ql-editor ql-blank']");
	By txtTemplateInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_NOTIFICATION_TEMPLATE_EDIT_TEMPLATE", CommonConstants.ELEMENT_FILE)
					+ "']//div[@class='ql-editor']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_RULE_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpNotificationTemplateTypeInSearch = By.xpath("//*[normalize-space(text())='NotificationTemplate Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	String addStatus="//*[@id='inputNotificationTemplateAddStatus']//span[normalize-space(text())='%s']";
	String editStatus="//*[@id='inputNotificationTemplateeditStatus']//span[normalize-space(text())='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("notificationTemplate.label.name", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String template = 
			"//*[normalize-space(text()) = '" + Utility.readJSFile("notificationTemplate.label.template", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = 
			"//*[normalize-space(text()) = '" + Utility.readJSFile("notificationTemplate.label.status",CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String verifyElement="(//*[normalize-space(text())='%s'])[last()]";
	By filter=By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By equals=By.xpath("//li[normalize-space(text())='Equals']");
	String data="(//td[text()='%s'])[1]";
	
	private CommonPage common;

	public PlatformConfigurationNotificationTemplatePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void sendTextInName(String name) {
		sendKeys(txtName, name,0);
	}

	public void sendTextInTemplate(String template) {
		sendKeys(txtTemplate, template,0);
	}

	public void sendTextInTemplateInEdit(String template) {
		sendKeys(txtTemplateInEdit, template);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(addStatus, status)),1);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(editStatus, status)),1);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(verifyElement, status)),1);
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filter);
			clickOnElement(equals);
		}
		sendTextInNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		common.clickOnFilterSearchBtn();
	}

	
	public void addNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInTemplate(map.get(mapKeys.get(2)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())),0))
				return false;
			if (!verifyVisible(By.xpath(String.format(template, map.get(mapKeys.get(2)).toString())),0))
				return false;
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(3)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	
	public boolean editNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInTemplateInEdit(map.get(mapKeys.get(2)).toString());
			selectStatusInEdit(map.get(mapKeys.get(3)).toString());
			common.clickOnSaveBtn();
			return true;
		} else 
			return false;
	}

	public boolean verifyEditedNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(template, map.get(mapKeys.get(2)).toString())),0))
				return false;
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(3)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "NotificationTemplate already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
		
	}

	
	public boolean verifyDeletedNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),
					5);
	}

	public boolean sortNotificationTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}

	
}
