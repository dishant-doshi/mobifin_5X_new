package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.ScriptConstants;
import base.SetupInit;

public class BusinessConfigurationOperatingEntityTemplatePage extends SetupInit {
	CommonPage common;
	By txtOperatingEntityTemplateName = By.id("form_in_modal_inputOperatingentityAddName");
	By txtDescription = By.id("form_in_modal_inputOperatingentityAddDescription");
	By txtDescriptionInEdit = By.id("form_in_modal_inputOperatingentityEditDescription");
	String IsYes = "Yes";
	By txtNameInSearch = By.id("search");
	By drpSelection = By.xpath("(//*[@class='ant-input ant-cascader-input '])[last()]");
	By btnOk = By.xpath("//*[normalize-space(text()) = '" + ScriptConstants.REGIONAL_ENTITY_OK + "']//parent::button");
	By btnSave = By.xpath("//*[normalize-space(text())='" + ScriptConstants.BUSINESS_ZONE_SAVE + "']//parent::button");
	By drpAccessChannel = By
			.xpath("(//*[contains(@id,'form_in_modal_accesschannalFields')]//*[@class='ant-select-arrow'])[last()]");
	By btnAddKYCLevel = By.xpath("//*[normalize-space(text())='Add Field']//parent::button");
	By drpUserCategory = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddUsercategory')]//*[@class='ant-select-arrow'])[last()]");
	By drpUserCategoryInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditUsercategory')]//*[@class='ant-select-arrow'])[last()]");
	By drpRole = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddRole')]//parent::div[contains(@class,'rendered')])[last()]");
	By drproleInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditRole')]//parent::div[contains(@class,'rendered')])[last()]");
	By drpKyc = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddKyc')]//*[@class='ant-select-arrow'])[last()]");
	By drpKycInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditKyc')]//*[@class='ant-select-arrow'])[last()]");
	By drpKycLevel = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityKycAddLevel')]//*[@class='ant-select-arrow'])[last()]");
	By drpKycLevelInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditKycLevel')]//*[@class='ant-select-arrow'])[last()]");
	By drpWalletTemplate = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityWalletTemplate')]//*[@class='ant-select-arrow'])[last()]");
	By drpServiceProfile = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityServiceProfile')]//*[@class='ant-select-arrow'])[last()]");
	By drpCurrency = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpCurrencyInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpReportingCurrency = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddReportingCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpReportingCurrencyInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditReportingCurrency')]//*[@class='ant-select-arrow'])[last()]");
	By drpTimeZone = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddTimezone')]//*[@class='ant-select-arrow'])[last()]");
	By drpTimeZoneInEdit = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityEditTimeZone')]//*[@class='ant-select-arrow'])[last()]");
	By drpAllowBusinessZone = By
			.xpath("(//*[contains(@id,'form_in_modal_inputOperatingentityAddAllowedBusinessZone')])[last()]");
	String verify = "//*[text()='%s']";
	String drpStatus = "//*[@id='form_in_modal_inputOperatingentityAddStatus']//span[normalize-space(text())='%s']";
	String drpStatusEdit = "//*[@id='form_in_modal_inputOperatingentityEditStatus']//span[normalize-space(text())='%s']";
	String drpValues = "(//li[normalize-space(text())='%s'])[last()]";
	By btnReload = By.xpath("//*[contains(@class,'anticon-reload')]//parent::button");
	By btnSearch = By.xpath("//*[contains(@class,'anticon-search')]//parent::button");
	String btnOperatingEntityTemplateAdd = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'regional-business')]//div[contains(@class,'action-button')]//button[1]";
	By drpOperatingEnityTemplate = By.xpath("(//*[normalize-space(text())='Select']//parent::button)[last()]");
	String view = "//*[text()='%s']//parent::button[contains(@class,'dropdown-trigger')]";
	By edit = By.xpath("(//*[contains(@class,'dropdown-trigger')])[last()]");
	String regEntityDelete = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'template')]//div[contains(@class,'action-button')]//button[2]";
	By txtAccessChannel = By
			.xpath("(//*[contains(@id,'accesschannalFields') and @class='ant-select-search__field'])[last()]");
	By txtAllowAPI = By
			.xpath("(//*[contains(@id,'form_in_modal_allowedapi')]//*[@class='ant-select-search__field'])[last()]");
	By mandatory = By.xpath("(//*[contains(@id,'2faAllowed')])[last()]");
	String drpValue = "//li[normalize-space(text())='%s']";
	By reservation = By.xpath("(//*[contains(@id,'form_in_modal_inputOperatingentityAddBalanceReservation')])[last()]");
	By reservationEdit = By
			.xpath("(//*[contains(@id,'form_in_modal_inputOperatingentityEditBalanaceReservation')])[last()]");
	By addAllowBusinessZone = By.xpath(
			"(//*[contains(@id,'form_in_modal_inputOperatingentityAddAllowedBusinessZone') and @class='ant-select-search__field'])[last()]");
	String chkProduct = "//*[contains(@class,'tabpane-active')]//*[normalize-space(text())='%s']//parent::div[contains(@class,'checkbox')]//input//parent::span";
	String module = "//div[normalize-space(text())='%s']";
	String fromOperatingEntitySelection = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromOperatingEntity')]";
	String fromUserIdentifierSelection = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUseridentifierFrom')]";
	String fieldsOfFromWallet = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromWallet')]";
	String fieldsOfFromPouch = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductFromPouch')]";
	String fromValidationProfileSelection = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileValidateProfileFrom')]";
	String toOperatingEntitySelection = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToOperatingEntity')]";
	String toUserIdentifierSelection = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUseridentifierTo')]";
	By accessChannel = By.xpath("//*[normalize-space(text())='Access Channel']");
	String toValidationProfile = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductGroupValidateProfileTo')]";
	String fieldsOfToPouch = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToPouch')]";
	String fieldsOfToWallet = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToWallet')]";
	String toUserIdentifierSelections = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToUserIdf')]";
	String toOperatingEntitySelections = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpToOperatingEntity')]";
	String productToWallet = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToWallet')]";
	String prductToPouch = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductToPouch')]";
	String valdateProfileTo = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileValidateProfileTo')]";
	String assignserviceprofileUCPFromOperatingEntity = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromOperatingEntity')]";
	String assignserviceprofileUCPUseridentifierFrom = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPUseridentifierFrom')]";
	String assignserviceprofileUCPFromWallet = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromWallet')]";
	String assignserviceprofileUCPFromPouch = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPFromPouch')]";
	String assignserviceprofileUCPValidateProfileFrom = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPValidateProfileFrom')]";
	String assignserviceprofileUCPToOperatingEntity = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToOperatingEntity')]";
	String assignserviceprofileUCPUseridentifierTo = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPUseridentifierTo')]";
	String assignserviceprofileUCPToWallet = "//tr[%s]//*[contains(@id,'form_in_modal_input')]";
	String assignserviceprofileUCPToPouch = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPToPouch')]";
	String assignserviceprofileUCPValidateProfileTo = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileUCPValidateProfileTo')]";
	String assignserviceprofileProductgrpFromOperatingEntity = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromOperatingEntity')]";
	String assignserviceprofileProductgrpFromUserIdf = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromUserIdf')]";
	String assignserviceprofileProductgrpFromWallet = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromWallet')]";
	String assignserviceprofileProductgrpFromPouch = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductgrpFromPouch')]";
	String assignserviceprofileProductGroupValidateProfileFrom = "//tr[%s]//*[contains(@id,'form_in_modal_inputAssignserviceprofileProductGroupValidateProfileFrom')]";
	String name = "//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String userCategory = "//*[normalize-space(text()) = 'User Category']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String role = "//*[normalize-space(text()) = 'Role']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String currency = "//*[normalize-space(text()) = 'Currency']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String reportingCurrency = "//*[normalize-space(text()) = 'Reporting Currency']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String kyc = "//*[normalize-space(text()) = 'KYC']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String kycLevel = "//*[normalize-space(text()) = 'KYC Level']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String timezone = "//*[normalize-space(text()) = 'Timezone']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String walletTemplate = "//*[normalize-space(text()) = 'Wallet Template']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String verifyAccessChannel = "//table//tbody//tr[%s]//td[normalize-space(text())='%s']";
	String verifyLevelField = "//table//tbody//tr[%s]//td[contains(text(),'%s')]";
	String verifySuccess = "//table//tbody//tr[%s]//td//i[contains(@class,'text-success')]";
	String verifyFail = "//table//tbody//tr[%s]//td[normalize-space(text())='false']";
	By timeZone = By.xpath("//*[normalize-space(text())='Timezone']");
	By failureAlert = By.xpath("//*[@class='ant-alert-description']");

	public BusinessConfigurationOperatingEntityTemplatePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInOperatingEntityTemplateName(String name) {
		sendKeys(txtOperatingEntityTemplateName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description, 0);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(drpStatus, status)), 1);
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(drpStatusEdit, status)), 1);
	}

	public void sendTextInOperatingEntityTemplateNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectField(String field) {
		selectFromDropDown(drpSelection, By.xpath(String.format(drpValues, field)), 0);
	}

	public void filterSearch(String sysOperatorEntityTemplateName) {
		clickOnElement(btnReload, 0);
		sendTextInOperatingEntityTemplateNameFilterSearch(sysOperatorEntityTemplateName);
		clickOnElement(btnSearch, 0);
	}

	public void clickOnOperatingEntityTemplateAddIcon(String parentRegionalEntity) {
		filterSearch(parentRegionalEntity);
		clickOnElement(By.xpath(String.format(btnOperatingEntityTemplateAdd, parentRegionalEntity)), 0);
	}

	public void selectOperatingEntityTemplate() {
		selectFromDropDown(drpOperatingEnityTemplate,
				By.xpath(String.format(drpValues, ScriptConstants.ADD_OPERATING_ENTITY_TEMPLATE)), 0);
	}

	public void clickOnViewDetail(String value) {
		selectFromDropDown(By.xpath(String.format(view, value)),
				By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_VIEW)), 0);
	}

	public void clickOnEditDetail() {
		selectFromDropDown(edit, By.xpath(String.format(drpValues, ScriptConstants.BUSINESS_ZONE_EDIT)), 0);
	}

	public void clickOnOperatingEntityTemplateDelete(String regionalEntity) {
		clickOnElement(By.xpath(String.format(regEntityDelete, regionalEntity)), 0);
		common.clickOnDeleteConfirm();
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel, 0);
	}

	public void selectAccessChannel(String accessChannel) {
		clickOnElement(drpAccessChannel);
		sendKeys(txtAccessChannel, accessChannel + Keys.ENTER);
	}

	public void sendTextInAllowedAPI(String allowedAPI) {
		sendKeys(txtAllowAPI, allowedAPI + Keys.ENTER, 0);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes))
			clickOnElement(mandatory);
	}

	public void selectUserCategory(String userCategory) {
		selectFromDropDown(drpUserCategory, By.xpath(String.format(drpValue, userCategory)), 0);
	}

	public void selectUserCategoryInEdit(String userCategory) {
		selectFromDropDown(drpUserCategoryInEdit, By.xpath(String.format(drpValue, userCategory)), 0);
	}

	public void selectRole(String role) {
		selectFromDropDown(drpRole, By.xpath(String.format(drpValue, role)), 0);
	}

	public void selectRoleInEdit(String role) {
		selectFromDropDown(drproleInEdit, By.xpath(String.format(drpValue, role)), 0);
	}

	public void selectKYC(String Kyc) {
		selectFromDropDown(drpKyc, By.xpath(String.format(drpValue, Kyc)), 0);
	}

	public void selectKYCINEdit(String Kyc) {
		selectFromDropDown(drpKycInEdit, By.xpath(String.format(drpValue, Kyc)), 0);
	}

	public void selectKYCLevel(String KycLevel) {
		selectFromDropDown(drpKycLevel, By.xpath(String.format(drpValues, KycLevel)), 0);
	}

	public void selectKYCLevelInEdit(String KycLevel) {
		selectFromDropDown(drpKycLevelInEdit, By.xpath(String.format(drpValues, KycLevel)), 0);
	}

	public void selectCurrency(String currency) {
		selectFromDropDown(drpCurrency, By.xpath(String.format(drpValue, currency)), 0);
	}

	public void selectCurrencyInEdit(String currency) {
		selectFromDropDown(drpCurrencyInEdit, By.xpath(String.format(drpValue, currency)), 0);
	}

	public void selectReportingCurrency(String reportingCurrency) {
		selectFromDropDown(drpReportingCurrency, By.xpath(String.format(drpValues, reportingCurrency)), 0);
	}

	public void selectReportingCurrencyInEdit(String reportingCurrency) {
		selectFromDropDown(drpReportingCurrencyInEdit, By.xpath(String.format(drpValues, reportingCurrency)), 0);
	}

	public void selectTimeZone(String timeZone) {
		selectFromDropDown(drpTimeZone, By.xpath(String.format(drpValue, timeZone)), 0);
	}

	public void selectTimeZoneInEdit(String timeZone) {
		selectFromDropDown(drpTimeZoneInEdit, By.xpath(String.format(drpValue, timeZone)), 0);
	}

	public void selectWalletTemplate(String walletTemplate) {
		selectFromDropDown(drpWalletTemplate, By.xpath(String.format(drpValue, walletTemplate)), 0);
	}

	public void selectIsBalanceReservation(String isRerservation) {
		if (!isRerservation.equalsIgnoreCase(IsYes))
			clickOnElement(reservation, 0);
	}

	public void selectIsBalanceReservationInEdit(String isRerservation) {
		if (!isRerservation.equalsIgnoreCase(IsYes))
			clickOnElement(reservationEdit, 0);
	}

	public void selectServiceProfile(String serviceProfile) {
		selectFromDropDown(drpServiceProfile, By.xpath(String.format(drpValue, serviceProfile)), 0);
	}

	public void selectAllowBusinessZone(String businessZone) {
		clickOnElement(drpAllowBusinessZone, 0);
		sendKeys(addAllowBusinessZone, businessZone + Keys.ENTER, 0);
		clickOnElement(timeZone, 0);
	}

	public void selectProduct(String product) {
		clickOnElement(By.xpath(String.format(chkProduct, product)), 0);
	}

	public void selectmodules(String moduleName) {
		clickOnElement(By.xpath(String.format(module, moduleName)), 0);
	}

	public void selectFieldsOfOperatingEntityTemplate(By element, String operatingEntityTemplate) {
		selectFromDropDown(element, By.xpath(String.format(drpValues, operatingEntityTemplate)), 0);
	}

	public void selectFieldsOfFromWallet(By element, String string) {
		selectFromDropDown(element, By.xpath(String.format(drpValues, string)), 0);
	}

	public void sendTextInUserIdentifier(By element, String userIdentifier) {
		sendKeys(element, userIdentifier, 0);
	}

	public void selectValidationProfile(By element, String isValidationProfile) {
		if (isValidationProfile.equalsIgnoreCase(IsYes))
			clickOnElement(element, 0);
	}

	public void addOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (veifyElementIsNotVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnOperatingEntityTemplateAddIcon(map.get(mapKeys.get(2)).toString());
			pauseInSeconds(2);
			selectOperatingEntityTemplate();
			pauseInSeconds(2);
			sendTextInOperatingEntityTemplateName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(3)).toString());
			selectUserCategory(map.get(mapKeys.get(4)).toString());
			selectRole(map.get(mapKeys.get(5)).toString());
			selectKYC(map.get(mapKeys.get(6)).toString());
			selectKYCLevel(map.get(mapKeys.get(7)).toString());
			selectCurrency(map.get(mapKeys.get(8)).toString());
			selectReportingCurrency(map.get(mapKeys.get(9)).toString());
			String[] allowBusinessZoneList = map.get(mapKeys.get(10)).toString().trim().split(",");
			for (int k = 0; k < allowBusinessZoneList.length; k++)
				selectAllowBusinessZone(allowBusinessZoneList[k]);
			selectTimeZone(map.get(mapKeys.get(11)).toString());
			selectWalletTemplate(map.get(mapKeys.get(12)).toString());
			selectIsBalanceReservation(map.get(mapKeys.get(13)).toString());
			selectStatus(map.get(mapKeys.get(14)).toString());
			selectServiceProfile(map.get(mapKeys.get(15)).toString());
			if (!map.get(mapKeys.get(16)).toString().trim().equals("")) {
				String[] moduleList = map.get(mapKeys.get(16)).toString().trim().split("/");
				String[] productList = map.get(mapKeys.get(17)).toString().trim().split("/");
				String[] fromOperatingEntityList = map.get(mapKeys.get(18)).toString().trim().split("/");
				String[] fromUserIdentifierList = map.get(mapKeys.get(19)).toString().trim().split("/");
				String[] fromWalletList = map.get(mapKeys.get(20)).toString().trim().split("/");
				String[] fromPouchList = map.get(mapKeys.get(21)).toString().trim().split("/");
				String[] fromValidateProfileList = map.get(mapKeys.get(22)).toString().trim().split("/");
				String[] toOperatingEntityList = map.get(mapKeys.get(23)).toString().trim().split("/");
				String[] toUserIdentifierList = map.get(mapKeys.get(24)).toString().trim().split("/");
				String[] toWalletList = map.get(mapKeys.get(25)).toString().trim().split("/");
				String[] toPouchList = map.get(mapKeys.get(26)).toString().trim().split("/");
				String[] toValidtaeProfileList = map.get(mapKeys.get(27)).toString().trim().split("/");
				for (int i = 0; i < moduleList.length; i++) {
					selectmodules(moduleList[i].trim());
					String[] productSelect = productList[i].split(";");
					String[] fromOperatingEntity = fromOperatingEntityList[i].split(";");
					String[] fromUserIdentifier = fromUserIdentifierList[i].split(";");
					String[] fromWallet = fromWalletList[i].split(";");
					String[] fromPouch = fromPouchList[i].split(";");
					String[] fromValidateProfile = fromValidateProfileList[i].split(";");
					String[] toOperatingEntity = toOperatingEntityList[i].split(";");
					String[] toUserIdentifier = toUserIdentifierList[i].split(";");
					String[] toWallet = toWalletList[i].split(";");
					String[] toPouch = toPouchList[i].split(";");
					String[] toValidtaeProfile = toValidtaeProfileList[i].split(";");
					for (int j = 0; j < productSelect.length; j++) {
						if (productSelect[j].toLowerCase().equals("select all"))
							selectProduct(productSelect[j]);
						// from
						if (moduleList[i].toLowerCase().equals("products")) {
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(fromOperatingEntitySelection, (j + 1))),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(By.xpath(String.format(fromUserIdentifierSelection, (j + 1))),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfFromWallet, (j + 1))),
									fromWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfFromPouch, (j + 1))),
									fromPouch[j].trim());
							selectValidationProfile(By.xpath(String.format(fromValidationProfileSelection, (j + 1))),
									fromValidateProfile[j].trim());
							// to
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(toOperatingEntitySelection, (j + 1))),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(By.xpath(String.format(toUserIdentifierSelection, (j + 1))),
									toUserIdentifier[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(productToWallet, (j + 1))),
									toWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(prductToPouch, (j + 1))),
									toPouch[j].trim());
							selectValidationProfile(By.xpath(String.format(valdateProfileTo, (j + 1))),
									toValidtaeProfile[j].trim());
						}
						if (moduleList[i].toLowerCase().equals("ucps")) {
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(assignserviceprofileUCPFromOperatingEntity, (j + 1))),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath(String.format(assignserviceprofileUCPUseridentifierFrom, (j + 1))),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath(String.format(assignserviceprofileUCPFromWallet, (j + 1))),
									fromWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(assignserviceprofileUCPFromPouch, (j + 1))),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath(String.format(assignserviceprofileUCPValidateProfileFrom, (j + 1))),
									fromValidateProfile[j].trim());
							// to
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(assignserviceprofileUCPToOperatingEntity, (j + 1))),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath(String.format(assignserviceprofileUCPUseridentifierTo, (j + 1))),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(By.xpath(String.format(assignserviceprofileUCPToWallet, (j + 1))),
									toWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(assignserviceprofileUCPToPouch, (j + 1))),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath(String.format(assignserviceprofileUCPValidateProfileTo, (j + 1))),
									toValidtaeProfile[j].trim());
						}

						if (moduleList[i].toLowerCase().equals("product groups")) {
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(assignserviceprofileProductgrpFromOperatingEntity, (j + 1))),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath(String.format(assignserviceprofileProductgrpFromUserIdf, (j + 1))),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath(String.format(assignserviceprofileProductgrpFromWallet, (j + 1))),
									fromWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath(String.format(assignserviceprofileProductgrpFromPouch, (j + 1))),
									fromPouch[j].trim());
							selectValidationProfile(By
									.xpath(String.format(assignserviceprofileProductGroupValidateProfileFrom, (j + 1))),
									fromValidateProfile[j].trim());
							// to
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(toOperatingEntitySelections, (j + 1))),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(By.xpath(String.format(toUserIdentifierSelections, (j + 1))),
									toUserIdentifier[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfToWallet, (j + 1))),
									toWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfToPouch, (j + 1))),
									toPouch[j].trim());
							selectValidationProfile(By.xpath(String.format(toValidationProfile, (j + 1))),
									toValidtaeProfile[j].trim());
						}
					}
				}
			}
			int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
			String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
			for (int m = 0; m < rows; m++) {
				selectAccessChannel(accessChannelList[m].trim());
				String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
				String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
				String[] levelfield = allowedAPIList[m].split(",");
				for (int j = 0; j < levelfield.length; j++) {
					sendTextInAllowedAPI(levelfield[j].trim());
					clickOnElement(accessChannel);
				}
				selectIsMandatory(twofactor[m].trim());
				if (m < rows - 1)
					clickOnAddField();
			}
			clickOnElement(btnSave);
		}
	}

	public void verifyAddedOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyVisible(failureAlert, 3)) {
			log("<b style='color:#E82F08'>" + getElementText(failureAlert) + "</b>");
			common.clickOnCloseBtn();
		} else
			log("<b style='color:#02563d'>User successfuly added.</b>");
		filterSearch(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		clickOnViewDetail(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(userCategory, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(role, map.get(mapKeys.get(5)).toString())), 0);
		verifyVisible(By.xpath(String.format(currency, map.get(mapKeys.get(8)).toString())), 0);
		verifyVisible(By.xpath(String.format(reportingCurrency, map.get(mapKeys.get(9)).toString())), 0);
		verifyVisible(By.xpath(String.format(kyc, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(kycLevel, map.get(mapKeys.get(7)).toString())), 0);
		verifyVisible(By.xpath(String.format(timezone, map.get(mapKeys.get(11)).toString())), 0);
		verifyVisible(By.xpath(String.format(walletTemplate, map.get(mapKeys.get(12)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(14)).toString())));
		int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
		String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
		for (int m = 0; m < rows; m++) {
			verifyVisible(By.xpath(String.format(verifyAccessChannel, (m + 1), accessChannelList[m])), 0);
			String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
			String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
			String[] levelfield = allowedAPIList[m].split(",");
			for (int j = 0; j < levelfield.length; j++)
				verifyVisible(By.xpath(String.format(verifyLevelField, (m + 1), levelfield[j])), 0);
			if (twofactor[m].equalsIgnoreCase(IsYes))
				verifyVisible(By.xpath(String.format(verifySuccess, (m + 1))), 0);
			else
				verifyVisible(By.xpath(String.format(verifyFail, (m + 1))), 0);
		}
		clickOnElement(btnOk);
	}

	public boolean editOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())))) {
			clickOnEditDetail();
			if (!map.get(mapKeys.get(3)).toString().equals(""))
				sendTextInDescriptionInEdit(map.get(mapKeys.get(3)).toString());
			if (!map.get(mapKeys.get(4)).toString().equals(""))
				selectUserCategoryInEdit(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().equals(""))
				selectRoleInEdit(map.get(mapKeys.get(5)).toString());
			if (!map.get(mapKeys.get(6)).toString().equals(""))
				selectKYCINEdit(map.get(mapKeys.get(6)).toString());
			if (!map.get(mapKeys.get(7)).toString().equals(""))
				selectKYCLevelInEdit(map.get(mapKeys.get(7)).toString());
			if (!map.get(mapKeys.get(8)).toString().equals(""))
				selectCurrencyInEdit(map.get(mapKeys.get(8)).toString());
			if (!map.get(mapKeys.get(9)).toString().equals(""))
				selectReportingCurrencyInEdit(map.get(mapKeys.get(9)).toString());
			if (!map.get(mapKeys.get(10)).toString().equals("")) {
				String[] allowBusinessZoneList = map.get(mapKeys.get(10)).toString().trim().split(",");
				for (int k = 0; k < allowBusinessZoneList.length; k++)
					selectAllowBusinessZone(allowBusinessZoneList[k]);
			}
			if (!map.get(mapKeys.get(11)).toString().equals(""))
				selectTimeZoneInEdit(map.get(mapKeys.get(11)).toString());
			if (!map.get(mapKeys.get(12)).toString().equals(""))
				selectWalletTemplate(map.get(mapKeys.get(12)).toString());
			if (!map.get(mapKeys.get(13)).toString().equals(""))
				selectIsBalanceReservationInEdit(map.get(mapKeys.get(13)).toString());
			if (!map.get(mapKeys.get(14)).toString().equals(""))
				selectStatusInEdit(map.get(mapKeys.get(14)).toString());
			if (!map.get(mapKeys.get(16)).toString().trim().equals("")) {
				String[] moduleList = map.get(mapKeys.get(16)).toString().trim().split("/");
				String[] productList = map.get(mapKeys.get(17)).toString().trim().split("/");
				String[] fromOperatingEntityList = map.get(mapKeys.get(18)).toString().trim().split("/");
				String[] fromUserIdentifierList = map.get(mapKeys.get(19)).toString().trim().split("/");
				String[] fromWalletList = map.get(mapKeys.get(20)).toString().trim().split("/");
				String[] fromPouchList = map.get(mapKeys.get(21)).toString().trim().split("/");
				String[] fromValidateProfileList = map.get(mapKeys.get(22)).toString().trim().split("/");
				String[] toOperatingEntityList = map.get(mapKeys.get(23)).toString().trim().split("/");
				String[] toUserIdentifierList = map.get(mapKeys.get(24)).toString().trim().split("/");
				String[] toWalletList = map.get(mapKeys.get(25)).toString().trim().split("/");
				String[] toPouchList = map.get(mapKeys.get(26)).toString().trim().split("/");
				String[] toValidtaeProfileList = map.get(mapKeys.get(27)).toString().trim().split("/");
				for (int i = 0; i < moduleList.length; i++) {
					selectmodules(moduleList[i].trim());
					String[] productSelect = productList[i].split(";");
					String[] fromOperatingEntity = fromOperatingEntityList[i].split(";");
					String[] fromUserIdentifier = fromUserIdentifierList[i].split(";");
					String[] fromWallet = fromWalletList[i].split(";");
					String[] fromPouch = fromPouchList[i].split(";");
					String[] fromValidateProfile = fromValidateProfileList[i].split(";");
					String[] toOperatingEntity = toOperatingEntityList[i].split(";");
					String[] toUserIdentifier = toUserIdentifierList[i].split(";");
					String[] toWallet = toWalletList[i].split(";");
					String[] toPouch = toPouchList[i].split(";");
					String[] toValidtaeProfile = toValidtaeProfileList[i].split(";");
					for (int j = 0; j < productSelect.length; j++) {
						if (productSelect[j].toLowerCase().equals("select all"))
							selectProduct(productSelect[j]);
						// from
						if (moduleList[i].toLowerCase().equals("products")) {
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(fromOperatingEntitySelection, (j + 1))),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(By.xpath(String.format(fromUserIdentifierSelection, (j + 1))),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfFromWallet, (j + 1))),
									fromWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfFromPouch, (j + 1))),
									fromPouch[j].trim());
							selectValidationProfile(By.xpath(String.format(fromValidationProfileSelection, (j + 1))),
									fromValidateProfile[j].trim());
							// to
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(toOperatingEntitySelection, (j + 1))),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(By.xpath(String.format(toUserIdentifierSelection, (j + 1))),
									toUserIdentifier[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(productToWallet, (j + 1))),
									toWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(prductToPouch, (j + 1))),
									toPouch[j].trim());
							selectValidationProfile(By.xpath(String.format(valdateProfileTo, (j + 1))),
									toValidtaeProfile[j].trim());
						}
						if (moduleList[i].toLowerCase().equals("ucps")) {
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(assignserviceprofileUCPFromOperatingEntity, (j + 1))),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath(String.format(assignserviceprofileUCPUseridentifierFrom, (j + 1))),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath(String.format(assignserviceprofileUCPFromWallet, (j + 1))),
									fromWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(assignserviceprofileUCPFromPouch, (j + 1))),
									fromPouch[j].trim());
							selectValidationProfile(
									By.xpath(String.format(assignserviceprofileUCPValidateProfileFrom, (j + 1))),
									fromValidateProfile[j].trim());
							// to
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(assignserviceprofileUCPToOperatingEntity, (j + 1))),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath(String.format(assignserviceprofileUCPUseridentifierTo, (j + 1))),
									toUserIdentifier[j].trim());

							selectFieldsOfFromWallet(By.xpath(String.format(assignserviceprofileUCPToWallet, (j + 1))),
									toWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(assignserviceprofileUCPToPouch, (j + 1))),
									toPouch[j].trim());
							selectValidationProfile(
									By.xpath(String.format(assignserviceprofileUCPValidateProfileTo, (j + 1))),
									toValidtaeProfile[j].trim());
						}

						if (moduleList[i].toLowerCase().equals("product groups")) {
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(assignserviceprofileProductgrpFromOperatingEntity, (j + 1))),
									fromOperatingEntity[j].trim());
							sendTextInUserIdentifier(
									By.xpath(String.format(assignserviceprofileProductgrpFromUserIdf, (j + 1))),
									fromUserIdentifier[j].trim());
							selectFieldsOfFromWallet(
									By.xpath(String.format(assignserviceprofileProductgrpFromWallet, (j + 1))),
									fromWallet[j].trim());
							selectFieldsOfFromWallet(
									By.xpath(String.format(assignserviceprofileProductgrpFromPouch, (j + 1))),
									fromPouch[j].trim());
							selectValidationProfile(By
									.xpath(String.format(assignserviceprofileProductGroupValidateProfileFrom, (j + 1))),
									fromValidateProfile[j].trim());
							// to
							selectFieldsOfOperatingEntityTemplate(
									By.xpath(String.format(toOperatingEntitySelections, (j + 1))),
									toOperatingEntity[j].trim());
							sendTextInUserIdentifier(By.xpath(String.format(toUserIdentifierSelections, (j + 1))),
									toUserIdentifier[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfToWallet, (j + 1))),
									toWallet[j].trim());
							selectFieldsOfFromWallet(By.xpath(String.format(fieldsOfToPouch, (j + 1))),
									toPouch[j].trim());
							selectValidationProfile(By.xpath(String.format(toValidationProfile, (j + 1))),
									toValidtaeProfile[j].trim());
						}
					}
				}
			}
			if (!map.get(mapKeys.get(28)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
				String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
				for (int m = 0; m < rows; m++) {
					selectAccessChannel(accessChannelList[m].trim());
					String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
					String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
					String[] levelfield = allowedAPIList[m].split(",");
					for (int j = 0; j < levelfield.length; j++) {
						sendTextInAllowedAPI(levelfield[j].trim());
						clickOnElement(By.xpath("//*[normalize-space(text())='Access Channel']"));
					}
					selectIsMandatory(twofactor[m].trim());
					if (m < rows - 1) {
						clickOnAddField();
					}
				}
			}
			clickOnElement(btnSave);
			return true;
		} else
			return false;
	}

	public void verifyEditedOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		if (verifyVisible(failureAlert, 3)) {
			log("<b style='color:#E82F08'>" + getElementText(failureAlert) + "</b>");
			common.clickOnCloseBtn();
		} else
			log("<b style='color:#02563d'>User successfuly added.</b>");
		filterSearch(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 0);
		clickOnViewDetail(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(3)).toString())), 0);
		verifyVisible(By.xpath(String.format(userCategory, map.get(mapKeys.get(4)).toString())), 0);
		verifyVisible(By.xpath(String.format(role, map.get(mapKeys.get(5)).toString())), 0);
		verifyVisible(By.xpath(String.format(currency, map.get(mapKeys.get(8)).toString())), 0);
		verifyVisible(By.xpath(String.format(reportingCurrency, map.get(mapKeys.get(9)).toString())), 0);
		verifyVisible(By.xpath(String.format(kyc, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(kycLevel, map.get(mapKeys.get(7)).toString())), 0);
		verifyVisible(By.xpath(String.format(timezone, map.get(mapKeys.get(11)).toString())), 0);
		verifyVisible(By.xpath(String.format(walletTemplate, map.get(mapKeys.get(12)).toString())), 0);
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(14)).toString())), 1);
		int rows = Integer.parseInt(map.get(mapKeys.get(28)).toString());
		String[] accessChannelList = map.get(mapKeys.get(29)).toString().split(";");
		for (int m = 0; m < rows; m++) {
			verifyVisible(By.xpath(String.format(verifyAccessChannel, (m + 1), accessChannelList[m])), 0);
			String[] allowedAPIList = map.get(mapKeys.get(30)).toString().split(";");
			String[] twofactor = map.get(mapKeys.get(31)).toString().split(";");
			String[] levelfield = allowedAPIList[m].split(",");
			for (int j = 0; j < levelfield.length; j++)
				verifyVisible(By.xpath(String.format(verifyLevelField, (m + 1), levelfield[j])), 0);
			if (twofactor[m].equalsIgnoreCase(IsYes))
				verifyVisible(By.xpath(String.format(verifySuccess, (m + 1))), 0);
			else
				verifyVisible(By.xpath(String.format(verifyFail, (m + 1))), 0);
		}
		clickOnElement(btnOk);
	}

	public boolean deleteOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		if (verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5)) {
			clickOnOperatingEntityTemplateDelete(map.get(mapKeys.get(1)).toString());
			return true;
		} else {
			String string = "Record already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
		}
		return false;
	}

	public boolean verifyDeletedOperatingEntityTemplate(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString());
		return verifyVisible(By.xpath(String.format(verify, map.get(mapKeys.get(1)).toString())), 5);
	}
}
