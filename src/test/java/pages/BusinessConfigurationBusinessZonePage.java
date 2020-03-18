package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import utils.Utility;

public class BusinessConfigurationBusinessZonePage extends SetupInit {
	CommonPage common;
	By txtBusinessZoneName = By.id("form_in_modal_inputBusinesszoneAddName");
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ScriptConstants.BUSINESSZONE_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ScriptConstants.BUSINESS_ZONE_SAVE + "']//parent::button");
	String drpStatus = "//*[@id='form_in_modal_inputBusinesszoneAddStatus']//span[normalize-space(text())='%s']";
	String drpStatusEdit = "//*[@id='form_in_modal_inputBusinesszoneEditStatus']//span[normalize-space(text())='%s']";
	String drpValues = "(//li[normalize-space(text())='%s'])[last()]";
	By btnReload = By.xpath("//*[contains(@class,'anticon-reload')]//parent::button");
	By btnSearch = By.xpath("//*[contains(@class,'anticon-search')]//parent::button");
	String businessZoneAddIcon = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'business-zone')]//div[contains(@class,'action-button')]//button[1]";
	By drpBusinessZone = By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]");
	By drpView = By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]");
	By drpEdit = By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]");
	String deleteBusinessZone = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'business-zone')]//div[contains(@class,'action-button')]//button[3]";
	String verify = "//*[text()='%s']";
	String verification = "//*[normalize-space(text()) = '%s']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	public BusinessConfigurationBusinessZonePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInBusinessZoneName(String name) {
		sendKeys(txtBusinessZoneName, name);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 1);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(drpStatusEdit, status)), 1);
	}

	public void sendTextInBusinessZoneNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectField(String field) {
		selectFromDropDown(drpSelection, By.xpath(String.format(drpStatusEdit, field)), 0);
	}

	public void filterSearch(String businessZoneName) {
		clickOnElement(btnReload);
		sendTextInBusinessZoneNameFilterSearch(businessZoneName);
		clickOnElement(btnSearch, 0);
	}

	public void clickOnBusinessZoneAddIcon(String parentBusinessZone) {
		filterSearch(parentBusinessZone);
		clickOnElement(By.xpath(String.format(businessZoneAddIcon, parentBusinessZone)), 0);
	}

	public void selectBusinessZone() {
		selectFromDropDown(drpBusinessZone,
				By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_ADD_BUSINESSZONE)), 0);
	}

	public void clickOnViewDetail() {
		selectFromDropDown(drpView, By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_VIEW)), 0);
	}

	public void clickOnEditDetail() {
		selectFromDropDown(drpEdit, By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_EDIT)), 0);
	}

	public void clickOnBusinessZoneDelete(String businessZone) {
		clickOnElement(By.xpath(String.format(deleteBusinessZone, businessZone)), 0);
		common.clickOnDeleteConfirm();
	}

	public void addBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (veifyElementIsNotVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnElement(btnReload);
			clickOnBusinessZoneAddIcon(map.get(mapKeys.get(2)).toString());
			selectBusinessZone();
			sendTextInBusinessZoneName(map.get(mapKeys.get(1)).toString());
			selectStatus(map.get(mapKeys.get(3)).toString());
			clickOnElement(btnSave);
		}
	}

	public void verifyAddedBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		clickOnViewDetail();
		verifyVisible(By.xpath(
				String.format(verification, Utility.readJSFile("businesszone.grid.name", CommonConstants.LABLE_FILE),
						map.get(mapKeys.get(1)).toString())),
				0);
		verifyVisible(By.xpath(
				String.format(verification, Utility.readJSFile("businesszone.grid.name", CommonConstants.LABLE_FILE),
						map.get(mapKeys.get(3)).toString())),
				1);
		clickOnElement(btnOk);
	}

	public boolean editBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())))) {
			clickOnEditDetail();
			selectStatusInEdit(map.get(mapKeys.get(4)).toString());
			clickOnElement(btnSave);
			return true;
		} else
			return false;
	}

	public void verifyEditedBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		clickOnViewDetail();
		verifyVisible(By.xpath(
				String.format(verification, Utility.readJSFile("businesszone.grid.name", CommonConstants.LABLE_FILE),
						map.get(mapKeys.get(1)).toString())),
				0);
		verifyVisible(By.xpath(
				String.format(verification, Utility.readJSFile("businesszone.grid.name", CommonConstants.LABLE_FILE),
						map.get(mapKeys.get(3)).toString())),
				1);
		clickOnElement(btnOk);
	}

	public boolean deleteBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnBusinessZoneDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	public boolean verifyDeletedBusinessZone(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5);
	}
}
