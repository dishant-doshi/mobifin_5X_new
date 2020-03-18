package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class OperatorConfigSystemOperatorEntityPage extends SetupInit {
	CommonPage common;
	By txtSystemOperatorEntityName = By
			.id(Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By
			.id(Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUserCategory = By.xpath(
			"//*[@id='" + Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_USERCATEGORY", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpBusinessZone = By.xpath("//*[@id='inputSystemoperatorentityBusinessZone']//*[@class='ant-select-arrow']");
	By drpKYC = By.xpath("//*[@id='inputSystemoperatorentityKYC']//*[@class='ant-select-arrow']");
	By drpKYCLevel = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_KYCLEVEL", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpRole = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_SYSTEMOPERATORENTITY_ROLE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpTimeZone = By.xpath("//*[@id='inputSystemoperatorentityTimeZone']//*[@class='ant-select-arrow']");
	By drpAccessChannel = By.xpath("(//*[contains(@id,'accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	By drpAllowedAPI = By
			.xpath("(//*[contains(@id,'allowedapi')]//*[@class='ant-select-selection__rendered'])[last()]");
	String IsYes = "Yes";
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUsedBy = By.xpath("//*[@id='inputSystemOperatorEntityAddUsedBy']//*[@class='ant-select-arrow']");
	By drpUsedByInSearch = By.xpath(
			"//*[normalize-space(text())='Used By']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By btnAddKYCLevel = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");
	By filterDropdown = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	String dropDownValue = "//li[normalize-space(text())='%s']";
	String dropStatusValue = "(//li[normalize-space(text())='%s'])[last()]";
	String verifyElement = "(//td[text()='%s'])[1]";
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("systemoperatorentity.label.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("systemoperatorentity.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String userCategory = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("systemoperatorentity.label.usercategory", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String businessZone = "//*[normalize-space(text()) = 'Business Zone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String kycLevel = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("systemoperatorentity.label.kyclevel", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String role = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("systemoperatorentity.label.role", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String timeZone = "//*[normalize-space(text()) = 'Time Zone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("systemoperatorentity.label.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String accessChannel = "//table//tbody//tr[%s]//td[normalize-space(text())='%s']";
	String levelField = "//table//tbody//tr[%s]//td[contains(text(),'%s')]";
	String success = "//table//tbody//tr[%s]//td//i[contains(@class,'text-success')]";
	String danger = "//table//tbody//tr[%s]//td//i[contains(@class,'text-danger')]";
	By accessChannelField = By
			.xpath("(//*[contains(@id,'accesschannalFields') and @class='ant-select-search__field'])[last()]");
	By allowAPI = By.xpath("(//*[contains(@id,'allowedapi')]//*[@class='ant-select-search__field'])[last()]");
	String statusField = "//*[@id='inputSystemoperatorentityStatus']//span[normalize-space(text())='%s']";
	By manatory = By.xpath("(//*[contains(@id,'2faAllowed')])[last()]");
	By editable = By.xpath("(//*[contains(@id,'"
			+ Utility.readJSFile("INPUT_PARAMETER_ADD_CHILDFIELDEDITABLE", CommonConstants.ELEMENT_FILE)
			+ "')])[last()]");
	By accessChannelBtn = By.xpath("//*[normalize-space(text())='Access Channel']");
	String removeAccessChannel = "(//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'ant-row ant-form-item')]//parent::td//following-sibling::td//button[contains(@class,'delete')])[last()]";

	public OperatorConfigSystemOperatorEntityPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtSystemOperatorEntityName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void selectUserCategory(String userCategory) {
		selectFromDropDown(drpUserCategory, By.xpath(String.format(dropDownValue, userCategory)), 0);
	}

	public void selectBusinessZone(String businessZone) {
		selectFromDropDown(drpBusinessZone, By.xpath(String.format(dropDownValue, businessZone)), 0);
	}

	public void selectKYC(String kyc) {
		selectFromDropDown(drpKYC, By.xpath(String.format(dropDownValue, kyc)), 0);
	}

	public void selectKYCLevel(String kycLevel) {
		selectFromDropDown(drpKYCLevel, By.xpath(String.format(dropDownValue, kycLevel)), 0);
	}

	public void selectRole(String role) {
		selectFromDropDown(drpRole, By.xpath(String.format(dropDownValue, role)), 0);
	}

	public void selectTimeZone(String timeZone) {
		selectFromDropDown(drpTimeZone, By.xpath(String.format(dropDownValue, timeZone)), 0);
	}

	public void selectAccessChannel(String accessChannel) {
		clickOnElement(drpAccessChannel);
		sendKeys(accessChannelField, accessChannel + Keys.ENTER, 0);
	}

	public void sendTextInAllowedAPI(String allowedAPI) {
		sendKeys(allowAPI, allowedAPI + Keys.ENTER, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(statusField, status)), 1);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes))
			clickOnElement(manatory, 0);
	}

	public void selectIsEditable(String isEditable) {
		if (isEditable.equalsIgnoreCase(IsYes))
			clickOnElement(editable, 0);
	}

	public void sendTextInSystemOperatorEntityNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropStatusValue, status)), 1);
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel, 0);
	}

	public void removeAccessChannel(String accessChannel) {
		clickOnElement(By.xpath(String.format(removeAccessChannel, accessChannel.trim())), 0);
	}

	public void filterSearch(String sysOperEntityname, String status, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString)
			selectFromDropDown(filterDropdown, filterBy, 0);
		sendTextInSystemOperatorEntityNameFilterSearch(sysOperEntityname);
		selectStatusInFilterSearch(status);
		common.clickOnFilterSearchBtn();
	}

	public void addSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(13)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectBusinessZone(map.get(mapKeys.get(4)).toString());
			selectKYC(map.get(mapKeys.get(5)).toString());
			selectKYCLevel(map.get(mapKeys.get(6)).toString());
			selectRole(map.get(mapKeys.get(7)).toString());
			selectTimeZone(map.get(mapKeys.get(8)).toString());
			int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
			String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				clickOnAddField();
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					sendTextInAllowedAPI(levelfield[j].trim());
					clickOnElement(accessChannelBtn);
				}
				selectIsMandatory(twofactor[m].trim());
			}
			selectStatus(map.get(mapKeys.get(13)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(13)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(userCategory, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(businessZone, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(kycLevel, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(role, map.get(mapKeys.get(7)).toString())), 0);
		verifyVisible(By.xpath(String.format(timeZone, map.get(mapKeys.get(8)).toString())), 0);
		int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
		String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
		for (int m = 0; m < rows; m++) {
			verifyVisible(By.xpath(String.format(accessChannel, String.valueOf(m + 1), accessChannelList[m])), 0);
			String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
			String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
			String[] levelfield = allowedAPIList[m].split(",");
			for (int j = 0; j < levelfield.length; j++)
				verifyVisible(By.xpath(String.format(levelField, String.valueOf(m + 1), levelfield[j])), 0);
			if (twofactor[m].equalsIgnoreCase(IsYes))
				verifyVisible(By.xpath(String.format(success, String.valueOf(m + 1))), 0);
			else
				verifyVisible(By.xpath(String.format(danger, String.valueOf(m + 1))), 0);
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(13)).toString())));
	}

	public boolean editSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(13)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectUserCategory(map.get(mapKeys.get(3)).toString());
			selectBusinessZone(map.get(mapKeys.get(4)).toString());
			selectKYC(map.get(mapKeys.get(5)).toString());
			selectKYCLevel(map.get(mapKeys.get(6)).toString());
			selectRole(map.get(mapKeys.get(7)).toString());
			selectTimeZone(map.get(mapKeys.get(8)).toString());
			if (!map.get(mapKeys.get(15)).toString().isEmpty()) {
				String[] removeAccessChannels = map.get(mapKeys.get(15)).toString().split(",");
				for (int i = 0; i < removeAccessChannels.length; i++)
					removeAccessChannel(removeAccessChannels[i]);
			}
			int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
			String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				clickOnAddField();
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++)
					sendTextInAllowedAPI(levelfield[j].trim());
				selectIsMandatory(twofactor[m].trim());
			}
			selectStatus(map.get(mapKeys.get(14)).toString());
			common.clickOnSaveBtn();
			return true;
		} else
			return false;
	}

	public void verifyEditedSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(14)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(userCategory, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(businessZone, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(kycLevel, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(role, map.get(mapKeys.get(7)).toString())), 0);
		verifyVisible(By.xpath(String.format(timeZone, map.get(mapKeys.get(8)).toString())), 0);
		int rows = Integer.parseInt(map.get(mapKeys.get(9)).toString());
		String[] accessChannelList = map.get(mapKeys.get(10)).toString().split(";");
		for (int m = 0; m < rows; m++) {
			verifyVisible(By.xpath(String.format(accessChannel, String.valueOf(m + 1), accessChannelList[m])), 0);
			String[] allowedAPIList = map.get(mapKeys.get(11)).toString().split(";");
			String[] twofactor = map.get(mapKeys.get(12)).toString().split(";");
			String[] levelfield = allowedAPIList[m].split(",");
			for (int j = 0; j < levelfield.length; j++)
				verifyVisible(By.xpath(String.format(levelField, String.valueOf(m + 1), levelfield[j])), 0);
			if (twofactor[m].equalsIgnoreCase(IsYes))
				verifyVisible(By.xpath(String.format(success, String.valueOf(m + 1))), 0);
			else
				verifyVisible(By.xpath(String.format(danger, String.valueOf(m + 1))), 0);
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(14)).toString())));
	}

	public boolean deleteSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
	}

	public boolean verifyDeletedSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortSystemOperatorEntity(Map<Object, Object> map, List<Object> mapKeys) {
		return common.sorting(map, mapKeys);
	}
}
