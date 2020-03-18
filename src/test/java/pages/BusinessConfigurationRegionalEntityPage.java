package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.ScriptConstants;
import base.SetupInit;
import utils.Utility;

public class BusinessConfigurationRegionalEntityPage extends SetupInit {
	CommonPage common;
	By txtRegionalEntityName = By.id("form_in_modal_inputBusinessentityAddName");
	By txtDescription = By.id("form_in_modal_inputBusinessentityDescription");
	String IsYes = "Yes";
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ScriptConstants.REGIONAL_ENTITY_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ScriptConstants.BUSINESS_ZONE_SAVE + "']//parent::button");
	By drpAccessChannel = By
			.xpath("(//*[contains(@id,'form_in_modal_accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnAddKYCLevel = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");
	String drpStatus = "//*[@id='form_in_modal_inputBusinessentityAddStatus']//span[normalize-space(text())='%s']";
	String drpStatusEdit = "//*[@id='form_in_modal_inputBusinessentityEditStatus']//span[normalize-space(text())='%s']";
	String drpValues = "(//li[normalize-space(text())='%s'])[last()]";
	By btnReload = By.xpath("//*[contains(@class,'anticon-reload')]//parent::button");
	By btnSearch = By.xpath("//*[contains(@class,'anticon-search')]//parent::button");
	String regionalEntityAddIcon = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'business-zone')]//div[contains(@class,'action-button')]//button[2]";
	By drpSelect = By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]");
	String drpView = "//*[text()='%s']//parent::button[contains(@class,'dropdown-trigger')]";
	By drpEdit = By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]");
	String entityDelete = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'regional-business')]//div[contains(@class,'action-button')]//button[3]";
	By txtAccessChannel = By
			.xpath("(//*[contains(@id,'accesschannalFields') and @class='ant-select-search__field'])[last()]");
	By allowAPI = By
			.xpath("(//*[contains(@id,'form_in_modal_allowedapi')]//*[@class='ant-select-search__field'])[last()]");
	By mandatory = By.xpath("(//*[contains(@id,'2faAllowed')])[last()]");
	String verify = "//*[text()='%s']";
	By accessChannel = By.xpath("//*[normalize-space(text())='Access Channel']");
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("businessentity.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("businessentity.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String accessChannels = "//table//tbody//tr[%s]//td[normalize-space(text())='%s']";
	String levelFields = "//table//tbody//tr[%s]//td[contains(text(),'%s')]";
	String successTrue = "//table//tbody//tr[%s]//td//i[contains(@class,'text-success')]";
	String successFalse = "//table//tbody//tr[%s]//td[normalize-space(text())='false']";

	public BusinessConfigurationRegionalEntityPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInRegionalEntityName(String name) {
		sendKeys(txtRegionalEntityName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 1);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(drpStatusEdit, status)), 1);
	}

	public void sendTextInRegionalEntityNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectField(String field) {
		selectFromDropDown(drpSelection, By.xpath(String.format(drpValues, field)), 0);
	}

	public void filterSearch(String regionalEntityName) {
		clickOnElement(btnReload, 0);
		sendTextInRegionalEntityNameFilterSearch(regionalEntityName);
		clickOnElement(btnSearch, 0);
	}

	public void clickOnRegionalEntityAddIcon(String parentBusinessZone) {
		filterSearch(parentBusinessZone);
		clickOnElement(By.xpath(String.format(regionalEntityAddIcon, parentBusinessZone)), 0);
	}

	public void selectRegionalEntity() {
		selectFromDropDown(drpSelect, By.xpath(String.format(drpValues, ScriptConstants.ADD_REGIONAL_ENTITY)), 0);
	}

	public void clickOnViewDetail(String value) {
		selectFromDropDown(By.xpath(String.format(drpView, value)),
				By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_VIEW)), 0);
	}

	public void clickOnEditDetail() {
		selectFromDropDown(drpEdit, By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_EDIT)), 0);
	}

	public void clickOnRegionalEntityDelete(String regionalEntity) {
		clickOnElement(By.xpath(String.format(entityDelete, regionalEntity)), 0);
		common.clickOnDeleteConfirm();
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel);
	}

	public void selectAccessChannel(String accessChannel) {
		clickOnElement(drpAccessChannel);
		sendKeys(txtAccessChannel, accessChannel + Keys.ENTER);
	}

	public void sendTextInAllowedAPI(String allowedAPI) {
		sendKeys(allowAPI, allowedAPI + Keys.ENTER);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes))
			clickOnElement(mandatory);
	}

	public void addRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (veifyElementIsNotVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnElement(btnReload);
			clickOnRegionalEntityAddIcon(map.get(mapKeys.get(2)).toString());
			selectRegionalEntity();
			sendTextInRegionalEntityName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
			String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					sendTextInAllowedAPI(levelfield[j].trim());
					clickOnElement(accessChannel);
				}
				selectIsMandatory(twofactor[m].trim());
				if (m < rows - 1) {
					clickOnAddField();
				}
			}
			selectStatus(map.get(mapKeys.get(8)).toString());
			clickOnElement(btnSave);
		}
	}

	public void verifyAddedRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		clickOnViewDetail(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(8)).toString())), 1);
		int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
		String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
		for (int m = 0; m < rows; m++) {
			verifyVisible(By.xpath(String.format(accessChannels, (m + 1), accessChannelList[m])), 0);
			String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
			String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
			String[] levelfield = allowedAPIList[m].split(",");
			for (int j = 0; j < levelfield.length; j++)
				verifyVisible(By.xpath(String.format(levelFields, (m + 1), levelfield[j])), 0);
			if (twofactor[m].equalsIgnoreCase(IsYes)) {
				verifyVisible(By.xpath(String.format(successTrue, (m + 1))), 0);
			} else {
				verifyVisible(By.xpath(String.format(successFalse, (m + 1))), 0);
			}
		}
		clickOnElement(btnOk);
	}

	public boolean editRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnEditDetail();
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
				String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
				for (int m = 0; m < rows; m++) {
					selectAccessChannel(accessChannelList[m].trim());
					String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
					String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
					String[] levelfield = allowedAPIList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						sendTextInAllowedAPI(levelfield[j].trim());
						clickOnElement(accessChannel);
					}
					selectIsMandatory(twofactor[m].trim());
					if (m < rows - 1) {
						clickOnAddField();
					}
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(9)).toString());
			clickOnElement(btnSave);
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		clickOnViewDetail(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(9)).toString())), 1);
		int rows = Integer.parseInt(map.get(mapKeys.get(4)).toString());
		String[] accessChannelList = map.get(mapKeys.get(5)).toString().split(";");
		for (int m = 0; m < rows; m++) {
			verifyVisible(By.xpath(String.format(accessChannels, (m + 1), accessChannelList[m])), 0);
			String[] allowedAPIList = map.get(mapKeys.get(6)).toString().split(";");
			String[] twofactor = map.get(mapKeys.get(7)).toString().split(";");
			String[] levelfield = allowedAPIList[m].split(",");
			for (int j = 0; j < levelfield.length; j++)
				verifyVisible(By.xpath(String.format(levelFields, (m + 1), levelfield[j])), 0);
			if (twofactor[m].equalsIgnoreCase(IsYes)) {
				verifyVisible(By.xpath(String.format(successTrue, (m + 1))), 0);
			} else {
				verifyVisible(By.xpath(String.format(successFalse, (m + 1))), 0);
			}
		}
		clickOnElement(btnOk);
	}

	public boolean deleteRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnRegionalEntityDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	public boolean verifyDeletedRegionalEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5);
	}
}
