package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationProductPage extends SetupInit {

	By txtName = By.id(Utility.readJSFile("INPUT_PRODUCT_ADD_NAME",CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_PRODUCT_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpService = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_PRODUCT_ADD_SERVICE",CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By drpServiceInEdit = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_PRODUCT_EDIT_SERVICE", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_PRODUCT_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpProductTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Product Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtSKUID = By.id("inputProductAddSKUID");
	By txtSKUIDInEdit = By.id("inputProductEditSKUID");
	By drpCurrency = By.xpath("//*[@id='inputProductAddCurrency']//*[@class='ant-select-arrow']");
	By drpDenominationType = By.xpath("//*[@id='inputProductAddDenominationType']//*[@class='ant-select-arrow']");
	By txtFromAmount = By.id("inputProductAddFromAmount");
	By txtToAmount = By.id("inputProductAddToAmount");
	By drpPrecision = By.xpath("//*[@id='inputProductAddPrecision']//*[@class='ant-select-arrow']");
	By txtamount = By.id("inputProductAddAmount");
	By drpCurrencyInEdit = By.xpath("//*[@id='inputProductEditCurrency']//*[@class='ant-select-arrow']");
	By drpCountryName = By.xpath("//*[@id='inputProductAddParamStr2']//*[@class='ant-select-arrow']");
	By txtParaStr1 = By.id("inputProductAddParamStr1");
	By txtParaStr2 = By.id("inputProductAddParamStr3");
	By txtParaStr3 = By.id("inputProductAddParamStr4");
	By txtParaStr4 = By.id("inputProductAddParamStr5");
	By txtEditParaStr1 = By.id("inputProductEditParamStr1");
	By txtEditParaStr2 = By.id("inputProductEditParamStr3");
	By txtEditParaStr3 = By.id("inputProductEditParamStr4");
	By txtEditParaStr4 = By.id("inputProductEditParamStr5");
	By drpCountryNameInEdit = By.xpath("//*[@id='inputProductEditParamStr2']//*[@class='ant-select-arrow']");
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("product.label.name", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '" + Utility.readJSFile("product.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String service = "//*[normalize-space(text()) = '" + Utility.readJSFile("product.label.service", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String SKUID = "//*[normalize-space(text()) = 'SKUID']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String data="(//td[text()='%s'])[1]";
	String element="(//*[normalize-space(text())='%s'])[last()]";
	String selectStatus="//*[@id='inputProductAddStatus']//span[normalize-space(text())='%s']";
	String editStatus="//*[@id='lblProducteditStatus']//span[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	
	
	private CommonPage common;

	public PlatformConfigurationProductPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void sendTextInName(String name) {
		sendKeys(txtName, name,0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description);
	}

	public void selectService(String service) {
		clickOnElement(drpService);
		clickOnElement(By.xpath(String.format(element, service)));
	}

	public void selectServiceInEdit(String service) {
		clickOnElement(drpServiceInEdit);
		clickOnElement(By.xpath(String.format(element, service)));
	}

	public void sendTextInSKUID(String SKUID) {
		sendKeys(txtSKUID, SKUID);
	}

	public void sendTextInSKUIDInEdit(String SKUID) {
		sendKeys(txtSKUIDInEdit, SKUID);
	}

	public void sendTextInParamStr(By element, String paramStr) {
		sendKeys(element, paramStr);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(element, status)),1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath(String.format(editStatus, status)),1);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(element, status)),1);
	}

	public void selectCurrency(String currency) {
		clickOnElement(drpCurrency);
		clickOnElement(By.xpath(String.format(element, currency)));
	}

	public void selectCurrencyInEdit(String currency) {
		clickOnElement(drpCurrency);
		clickOnElement(By.xpath(String.format(element, currency)));
	}

	public void selectDenominationType(String denominationType) {
		clickOnElement(drpDenominationType);
		clickOnElement(By.xpath(String.format(element, denominationType.trim())));
	}

	public void sendTextInFromAmount(String fromAmount) {
		sendKeys(txtFromAmount, fromAmount);
	}

	public void sendTextInToAmount(String toAmount) {
		sendKeys(txtToAmount, toAmount);
	}

	public void selectPrecision(String precision) {
		clickOnElement(drpPrecision);
		clickOnElement(By.xpath(String.format(element, precision.trim())));
	}

	public void sendTextInAmount(String amount) {
		sendKeys(txtamount, amount);
	}

	public void selectCountryName(String countryName) {
		clickOnElement(drpCountryName);
		clickOnElement(By.xpath(String.format(element, countryName)));
	}

	public void selectCountryNameInEdit(String countryName) {
		clickOnElement(drpCountryNameInEdit);
		clickOnElement(By.xpath(String.format(element, countryName.trim())));
	}

	public void sendTextInPrameterStr1(String paraStr1) {
		sendKeys(txtParaStr1, paraStr1);
	}

	public void sendTextInPrameterStr2(String paraStr2) {
		sendKeys(txtParaStr2, paraStr2);
	}

	public void sendTextInPrameterStr3(String paraStr3) {
		sendKeys(txtParaStr3, paraStr3);
	}

	public void sendTextInPrameterStr4(String paraStr4) {
		sendKeys(txtParaStr4, paraStr4);
	}

	public void sendTextInEditPrameterStr1(String paraStr1) {
		sendKeys(txtEditParaStr1, paraStr1);
	}

	public void sendTextInEditPrameterStr2(String paraStr2) {
		sendKeys(txtEditParaStr2, paraStr2);
	}

	public void sendTextInEditPrameterStr3(String paraStr3) {
		sendKeys(txtEditParaStr3, paraStr3);
	}

	public void sendTextInEditPrameterStr4(String paraStr4) {
		sendKeys(txtEditParaStr4, paraStr4);
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

	
	public void addProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectService(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				selectCurrency(map.get(mapKeys.get(4)).toString());
				selectDenominationType(map.get(mapKeys.get(5)).toString());
				if (map.get(mapKeys.get(5)).toString().toLowerCase().equals("flexi")) {
					sendTextInFromAmount(map.get(mapKeys.get(6)).toString());
					sendTextInToAmount(map.get(mapKeys.get(7)).toString());
					selectPrecision(map.get(mapKeys.get(8)).toString());
				} else {
					sendTextInAmount(map.get(mapKeys.get(6)).toString());
				}
			}
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				sendTextInSKUID(map.get(mapKeys.get(9)).toString());
			}
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				selectCountryName(map.get(mapKeys.get(10)).toString());
			}
			if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
				sendTextInPrameterStr1(map.get(mapKeys.get(11)).toString());
			}
			if (!map.get(mapKeys.get(12)).toString().trim().equals("")) {
				sendTextInPrameterStr2(map.get(mapKeys.get(12)).toString());
			}
			if (!map.get(mapKeys.get(13)).toString().trim().equals("")) {
				sendTextInPrameterStr3(map.get(mapKeys.get(13)).toString());
			}
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				sendTextInPrameterStr4(map.get(mapKeys.get(14)).toString());
			}
			selectStatus(map.get(mapKeys.get(15)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(15)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get( mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(name, map.get( mapKeys.get(1)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(description, map.get( mapKeys.get(2)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(service, map.get( mapKeys.get(3)).toString())), 0))
				return false;
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				if (!verifyVisible(By.xpath(String.format(SKUID, map.get( mapKeys.get(9)).toString()))))
					return false;
			}
			if (!verifyVisible(By.xpath(String.format(status, map.get( mapKeys.get(15)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	public boolean editProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get( mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectServiceInEdit(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
				selectCurrency(map.get(mapKeys.get(8)).toString());
				selectDenominationType(map.get(mapKeys.get(9)).toString());
				if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("flexi")) {
					sendTextInFromAmount(map.get(mapKeys.get(10)).toString());
					sendTextInToAmount(map.get(mapKeys.get(11)).toString());
					selectPrecision(map.get(mapKeys.get(12)).toString());
				} else {
					sendTextInAmount(map.get(mapKeys.get(10)).toString());
				}
			}
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				sendTextInSKUIDInEdit(map.get(mapKeys.get(4)).toString());
			}
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				selectCountryNameInEdit(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(13)).toString().trim().equals("")) {
				sendTextInEditPrameterStr1(map.get(mapKeys.get(13)).toString());
			}
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				sendTextInEditPrameterStr2(map.get(mapKeys.get(14)).toString());
			}
			if (!map.get(mapKeys.get(15)).toString().trim().equals("")) {
				sendTextInEditPrameterStr3(map.get(mapKeys.get(15)).toString());
			}
			if (!map.get(mapKeys.get(16)).toString().trim().equals("")) {
				sendTextInEditPrameterStr4(map.get(mapKeys.get(16)).toString());
			}
			selectStatusInEdit(map.get(mapKeys.get(7)).toString());
			common.clickOnSaveBtn();
			return true;
		} else
			return false;
	}

	public boolean verifyEditedProduct(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(7)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get( mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(description, map.get( mapKeys.get(2)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(service, map.get( mapKeys.get(3)).toString())), 0))
				return false;
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				if (!verifyVisible(By.xpath(String.format(SKUID, map.get( mapKeys.get(9)).toString())), 0))
					return false;
			}
			if (!verifyVisible(By.xpath(String.format(status, map.get( mapKeys.get(15)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	
	public boolean deleteProduct(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get( mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "Product already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
		
	}

		public boolean verifyDeletedProduct(Map<Object, Object> map, List<Object> mapKeys) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),5);
		
	}
	public boolean sortProduct(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}
	
}
