package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class BusinessConfigurationProductManagementPage extends SetupInit {

	By txtProductManagementName = By.id(Utility.readJSFile("INPUT_SERVICEPROFILE_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By drpVendorService = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_PRODUCTMGMT_VENDORSERVICE", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("vendorName");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_SERVICEPROFILE_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	String data="(//td[text()='%s'])[1]";
	By fieldButton=By.xpath("(//button[contains(@class,'icon')])[last()]");
	String list="//*[normalize-space(text())='%s']";
	By button=By.xpath("(//button[contains(@class,'icon')])[1]");
	By equals=By.xpath("//li[normalize-space(text())='Equals']");
	By drpContains=By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	String drpData="(//li[normalize-space(text())='%s'])[last()]";
	String selectStatus="//*[@id='inputServiceprofileAddStatus']//span[normalize-space(text())='%s']";
	String service="//li[normalize-space(text())='%s']";

	private CommonPage common;

	public BusinessConfigurationProductManagementPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void sendTextInProductManagementName(String name) {
		sendKeys(txtProductManagementName, name);
	}

	public void selectVendorService(String vendorService) {
		clickOnElement(drpVendorService);
		clickOnElement(By.xpath(String.format(service, vendorService)));
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(selectStatus, status)));
	}

	public void sendTextInProductManagementNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(drpData, status)));
	}

	public void selectField(String field) {
		clickOnElement(drpSelection);
		clickOnElement(By.xpath(String.format(drpData, field)));
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(drpContains);
			clickOnElement(equals);
		}
		sendTextInProductManagementNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		common.clickOnFilterSearchBtn();
	}

	
	public boolean editProductManagement(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			waitForLoader();
			selectVendorService(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				String[] fieldlist = map.get(mapKeys.get(4)).toString().trim().split(",");
				for (int j = 0; j < fieldlist.length; j++) {
					clickOnElement(By.xpath(String.format(list, fieldlist[j].trim())));
					clickOnElement(button);
				}
			}
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				String[] fieldlist = map.get(mapKeys.get(5)).toString().trim().split(",");
				for (int j = 0; j < fieldlist.length; j++) {
					clickOnElement(By.xpath(String.format(list, fieldlist[j].trim())));
					clickOnElement(fieldButton);
				}
			}
			common.clickOnSaveBtn();
			return true;
		} else 
		return false;
	}
	
	

	
	
}
