package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationExchangeRateManagerPage extends SetupInit {

	
	
	By drpFromCurrency = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_EXCHANGERATE_ADD_FROMCURRENCY", CommonConstants.ELEMENT_FILE)
					+ "']//span[@class='ant-select-arrow']");
	By drpToCurrency = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_EXCHANGERATE_ADD_TOCURRENCY", CommonConstants.ELEMENT_FILE)
					+ "']//span[@class='ant-select-arrow']");
	By txtExchangeRate = By.id(Utility.readJSFile("INPUT_EXCHANGERATE_ADD_EXCHANGERATE", CommonConstants.ELEMENT_FILE));
	By drpFromCurrencyInEdit = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_EXCHANGERATE_EDIT_FROMCURRENCY", CommonConstants.ELEMENT_FILE)
					+ "']//span[@class='ant-select-arrow']");
	By drpToCurrencyInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_EXCHANGERATE_EDIT_TOCURRENCY", CommonConstants.ELEMENT_FILE)
					+ "']//span[@class='ant-select-arrow']");
	By txtExchangeRateInEdit = By
			.id(Utility.readJSFile("INPUT_EXCHANGERATE_EDIT_EXCHANGERATE", CommonConstants.ELEMENT_FILE));
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpSearchType = By.xpath("//*[normalize-space(text())='"
	+ Utility.readJSFile("exchangerate.label.validfromdate",CommonConstants.LABLE_FILE)
	+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	String selectElement="(//*[normalize-space(text())='%s'])[last()]";
	String addStatus="//*[@id='inputExchangeRateAddStatus']//span[normalize-space(text())='%s']";
	String editStatus="//*[@id='inputExchangeRateEditStatus']//span[normalize-space(text())='%s']";
	By btnAdd = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_ADD", CommonConstants.ELEMENT_FILE));
	By btnSave = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SAVE", CommonConstants.ELEMENT_FILE));
	By validationToolTipSelect = By.xpath("(//*[contains(@class,'has-error')])[1]");
	By validationToolTip = By.xpath("//*[contains(text(),'already ')]");
	By toDate=By.id("inputExchangeRateAddValidToDate");
	By btnOk=By.xpath("//*[@class='ant-calendar-ok-btn']");
	
	
	String fromCurrency = "//*[normalize-space(text()) = '" + Utility.readJSFile("exchangerate.label.fromcurrency", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String toCurrency = "//*[normalize-space(text()) = '" + Utility.readJSFile("exchangerate.label.tocurrency", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String exchangeRate = "//*[normalize-space(text()) = '" + Utility.readJSFile("exchangerate.label.exchangerate", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '" + Utility.readJSFile("notificationTemplate.label.status",CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String verifyElement="(//td[text()='%s'])[1]";
	By clickElement=By.xpath("//*[@class='ant-table-tbody']//tr[1]//td[1]");
	By txtDate=By.xpath("//*[@class='ant-calendar-input ']");
	
	
	
	
	WebElement element=null;
	
	private CommonPage common;

	public PlatformConfigurationExchangeRateManagerPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void selectFromCurrency(String fromCurrency) {
		clickOnElement(drpFromCurrency);
		clickOnElement(By.xpath(String.format(selectElement, fromCurrency)));
	}

	public void selectFromCurrencyInEdit(String fromCurrency) {
		clickOnElement(drpFromCurrencyInEdit);
		clickOnElement(By.xpath(String.format(selectElement, fromCurrency)));
	}

	public void selectToCurrency(String toCurrency) {
		clickOnElement(drpToCurrency);
		clickOnElement(By.xpath(String.format(selectElement, toCurrency)));
	}

	public void selectToCurrencyInEdit(String toCurrency) {
		clickOnElement(drpToCurrencyInEdit);
		clickOnElement(By.xpath(String.format(selectElement, toCurrency)));
	}

	public void sendTextInExchangeRate(String exchangeRate) {
		sendKeys(txtExchangeRate, exchangeRate);
	}

	public void sendTextInExchangeRateInEdit(String exchangeRate) {
		sendKeys(txtExchangeRateInEdit, exchangeRate);
	}

	public void selectStatus(String status) {
		clickOnElement(By
				.xpath(String.format(addStatus, status)),1);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(editStatus, status)),1);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(selectElement, status)),1);
	}

	public void sendTextInValidFromDateInFilterSearch(String fromDate) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(selectElement, fromDate)));
	}
	
	
	public String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		return dateTime;
	}
	
	public void sendTextInFromDate() {
		String endDate = getCurrentDateTime();
		clickOnElement(By.id("inputExchangeRateAddValidFromDate"));
		sendKeys(By.xpath("//*[@class='ant-calendar-input ']"), endDate);
		clickOnElement(By.xpath("//*[@class='ant-calendar-ok-btn']"));
	}

	public void sendTextInToDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, +30);
		Date currentDatePlusOne = c.getTime();
		String fromDate = dateFormat.format(currentDatePlusOne);
		clickOnElement(toDate);
		sendKeys(txtDate, fromDate);
		clickOnElement(btnOk);
	}
	
	public void clickOnSaveBtn() {
		clickOnElement(btnSave);
		common.isStriptTextDisplayed();
		if (verifyToolTip()) {
			common.clickOnBackBtn();
		}
	}
	
	public boolean verifyToolTip() {
		if (verifyVisible(validationToolTipSelect)) {
			element=(WebElement) validationToolTipSelect;
			element=(WebElement) validationToolTip;
			String validationMessage = "Tooltip Validation Message : "
					+ element.getAttribute("data-original-title");
			log("</br><b style='color:#E82F08'>" + validationMessage + "</b></br>");
			return true;
		} else if (verifyVisible(validationToolTip)) {
			String validationMessage = "Tooltip Validation Message : "
					+ element.getAttribute("data-original-title");
			log("</br><b style='color:#E82F08'>" + validationMessage + "</b></br>");

			return true;
		}
		return false;
	}

	
	public void addExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		common.clickOnAddButton();
		selectFromCurrency(map.get(mapKeys.get(1)).toString());
		selectToCurrency(map.get(mapKeys.get(2)).toString());
		sendTextInExchangeRate(map.get(mapKeys.get(3)).toString());
		sendTextInFromDate();
		sendTextInToDate();
		selectStatus(map.get(mapKeys.get(4)).toString());
		clickOnSaveBtn();
	}
	
	public boolean editExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyVisible(By.xpath(String.format(verifyElement,map.get(mapKeys.get(1)).toString())), 0)) {
			clickOnElement(clickElement);
			common.clickOnEditBtn();
			if (!map.get(mapKeys.get(1)).toString().isEmpty()) {
				selectFromCurrencyInEdit(map.get(mapKeys.get(1)).toString());
			}
			if (!map.get(mapKeys.get(2)).toString().isEmpty()) {
				selectToCurrencyInEdit(map.get(mapKeys.get(2)).toString());
			}
			if (!map.get(mapKeys.get(3)).toString().isEmpty()) {
				sendTextInExchangeRateInEdit(map.get(mapKeys.get(3)).toString());
			}
			selectStatusInEdit(map.get(mapKeys.get(4)).toString());
			clickOnSaveBtn();
			common.clickOnBackBtn();
			return true;
		}
		else
			return false;
	}
	
	public boolean verifyEditedExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0)) {
			clickOnElement(clickElement);
			if (!verifyVisible(By.xpath(String.format(fromCurrency, map.get(mapKeys.get(1)).toString())), 0))
					return false;
			if (!verifyVisible(By.xpath(String.format(toCurrency, map.get(mapKeys.get(2)).toString())), 0))
					return false;
			if (!verifyVisible(By.xpath(String.format(exchangeRate, map.get(mapKeys.get(3)).toString())), 0))
					return false;
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())), 1))
				return false;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyVisible(By.xpath(String.format(verifyElement,  map.get(mapKeys.get(1)).toString())))) {
			clickOnElement(clickElement);
			common.delete();
			common.isStriptTextDisplayed();
			return true;
		} else {
			String string = "ExchangeRateManager already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
		
	}
	
	public boolean verifyDeletedExchangeRateManager(Map<Object, Object> map, List<Object> mapKeys) {
		return verifyVisible(By.xpath(String.format(verifyElement,  map.get(mapKeys.get(1)).toString())),5);
	}

	
}
