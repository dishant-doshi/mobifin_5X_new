package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationProductGroupPage extends SetupInit {

	By txtName = By.id(Utility.readJSFile("INPUT_PRODUCTGROUP_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_PRODUCTGROUP_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_SERVICES_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpProductGroupTypeInSearch = By.xpath(
			"//*[normalize-space(text())='ProductGroup Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpProductGroupTypeInEdit = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_SERVICES_ADD_SERVICETYPE", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By drpProduct = By.xpath("//*[contains(@class,'ant-select-selection__rendered')]");
	By drpProductInEdit = By.xpath("//*[@class='ant-select-search__field']");
	By clickProductText = By.id(Utility.readJSFile("LBL_PRODUCTGROUP_ADD_PRODUCT", CommonConstants.ELEMENT_FILE));
	By clickProductTextInEdit = By.id(Utility.readJSFile("LBL_PRODUCTGROUP_EDIT_PRODUCT", CommonConstants.ELEMENT_FILE));
	String description = "//*[normalize-space(text()) = '" + Utility.readJSFile("productgroup.description", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String product = "//*[normalize-space(text()) = '" + Utility.readJSFile("productgroup.label.product", CommonConstants.LABLE_FILE)
					+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '" + Utility.readJSFile("productgroup.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String data="(//td[text()='%s'])[1]";
	String list="//*[@id = '" + Utility.readJSFile("INPUT_PRODUCTGROUP_EDIT_PRODUCT", CommonConstants.ELEMENT_FILE)
	+ "']//*[normalize-space(text())='%s']";
	String name = "//*[normalize-space(text()) = '" + Utility.readJSFile("productgroup.name", CommonConstants.LABLE_FILE)
	+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String type="//li[normalize-space(text())='%s']";
	String productType="(//li[normalize-space(text())='%s'])[last()]";
   String selectStatus="//*[@id='inputProductgroupStatus']//span[normalize-space(text())='%s']";
   String editStatus="//*[@id='inputProductgroupStatus']//span[normalize-space(text())='%s']";
   String filterStatus="(//*[normalize-space(text())='%s'])[last()]";
   By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
   By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
   
   
	private CommonPage common;

	public PlatformConfigurationProductGroupPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void sendTextInName(String name) {
		sendKeys(txtName, name,0);
	}

	public void selectProductGroupType(String serviceType) {
		clickOnElement(drpProduct);
		clickOnElement(By.xpath(String.format(type, serviceType)));
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description);
	}

	public void clickOnProductText() {
		clickOnElement(clickProductText);
	}

	public void clickOnProductTextInEdit() {
		clickOnElement(clickProductTextInEdit);
	}

	public void selectProduct(String product) {
		clickOnElement(By.xpath(String.format(productType, product)));
	}

	public void selectStatus(String status) {
		clickOnElement(
				By.xpath(String.format(selectStatus, status)),1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescription, description);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(
				By.xpath(String.format(editStatus, status)),1);
	}

	public void selectProductInEdit(String serviceType) {
		clickOnElement(drpProductGroupTypeInEdit);
		clickOnElement(By.xpath(String.format(type, serviceType)));
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(filterStatus, status)),1);
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

	public void addProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				String[] unitlist = map.get(mapKeys.get(3)).toString().trim().split(",");
				clickOnElement(drpProduct);
				for (int i = 0; i < unitlist.length; i++) {
					selectProduct(unitlist[i].trim());
				}
			}
			clickOnProductText();
			selectStatus(map.get(mapKeys.get(4)).toString());
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(product, map.get(mapKeys.get(3)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(5)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	public boolean editProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				String[] unitlist = map.get(mapKeys.get(3)).toString().trim().split(",");
				clickOnElement(drpProductInEdit);
				for (int i = 0; i < unitlist.length; i++) {
					if (!verifyVisible(
							By.xpath(String.format(list, unitlist[i])))) {
						selectProduct(unitlist[i].trim());
					}
				}
			}
			clickOnProductTextInEdit();
			selectStatusInEdit(map.get(mapKeys.get(5)).toString());
			common.clickOnSaveBtn();
			return true;
		} else
			return false;
	}

	public boolean verifyEditedProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(5)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0))
				return false;
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				if (!verifyVisible(By.xpath(String.format(product, map.get(mapKeys.get(3)).toString())), 0))
					return false;
			}
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(5)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "ProductGroup already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	
	public boolean verifyDeletedProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),5);
	}

	public boolean sortProductGroup(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}
	
}
