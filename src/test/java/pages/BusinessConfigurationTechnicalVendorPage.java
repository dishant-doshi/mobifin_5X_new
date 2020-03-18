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

public class BusinessConfigurationTechnicalVendorPage extends SetupInit {
	CommonPage common;
	String verifyElement = "(//td[text()='%s'])[1]";
	String dropDownValue = "//li[normalize-space(text())='%s']";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='" + ScriptConstants.EQUEALS + "']");
	By txtTechnicalVendorName = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By drpVendorService = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_SERVICES_ADD_VENDOR_SERVICE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpOperatingEntity = By.xpath("//*[@id='inputOperatingEntity']//*[@class='ant-select-arrow']");
	By txtProviderApiName = By.id("inputProviderApiName");
	By txtTimeOut = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_TIMEOUT", CommonConstants.ELEMENT_FILE));
	By txtFailureCode = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_FAILURE_CODE", CommonConstants.ELEMENT_FILE));
	By txtSucessCode = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_SUCCESS_CODE", CommonConstants.ELEMENT_FILE));
	By drpCommunicationProtocol = By.xpath("//*[@id='inputCommunicationProtocol']//*[@class='ant-select-arrow']");
	By drpHttpType = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_SERVICES_ADD_HTTP_TYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpRequestType = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_SERVICES_ADD_REQUEST_TYPE", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpHttpProtocol = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_SERVICES_ADD_HTTP_PROTOCOL", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By txtApiUrl = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_API_URL", CommonConstants.ELEMENT_FILE));
	By txtRetryCount = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_RETRY_COUNT", CommonConstants.ELEMENT_FILE));
	By txtSSLPassword = By.id("inputSslPassword");
	By btnNext = By.xpath("//*[contains(@class,'next')]");
	By txtApiTemplate = By.id(Utility.readJSFile("INPUT_SERVICES_ADD_API_TEMPLATE", CommonConstants.ELEMENT_FILE));
	By btnSubmit = By.xpath("//*[normalize-space(text())='Submit']//parent::button");
	By drpConnectionType = By.xpath("//*[@id='inputConnectionType']//*[@class='ant-select-arrow']");
	By drpAuth = By.xpath("//*[@id='inputAuth']//*[@class='ant-select-arrow']");
	By drpStartTLS = By.xpath("//*[@id='inputStartTls']//*[@class='ant-select-arrow']");
	By txtHost = By.id("inputHost");
	By txtPort = By.id("inputPort");
	By txtSoapUrl = By.id("inputSoapUrl");
	By drpSoapVersion = By.xpath("//*[@id='inputSoapVersion']//*[@class='ant-select-arrow']");
	By btnAddService = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_ADD_SERVICE", CommonConstants.ELEMENT_FILE));
	By txtNameInSearch = By.name("vendorName");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_ROLES_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpUsedBy = By.xpath("//*[@id='inputTechnicalVendorAddUsedBy']//*[@class='ant-select-arrow']");
	By btnAddKYCLevel = By
			.xpath("//*[contains(@class,'current')]//*[normalize-space(text())='Add field']//parent::button");
	By txtHeaderMappingApiField = By.xpath("(//*[contains(@id,'headerMappingApiField')])[last()]");
	By txtHeaderMappingMobifinPacketField = By.xpath("(//*[contains(@id,'headerMappingMobifinPacketField')])[last()]");
	By txtHeaderMappingDeafultValueField = By.xpath("(//*[contains(@id,'headerMappingDeafultValueField')])[last()]");
	By txtRequestMappingApiField = By.xpath("(//*[contains(@id,'requestMappingApiField')])[last()]");
	By txtReaderMappingMobifinPacketField = By.xpath("(//*[contains(@id,'requestMappingMobifinPacketField')])[last()]");
	By txtReaderMappingDeafultValueField = By.xpath("(//*[contains(@id,'requestMappingDefaultValueField')])[last()]");
	By txtResponseMappingApiField = By.xpath("(//*[contains(@id,'responseMappingApiField')])[last()]");
	By txtResponseMappingMobifinPacketField = By
			.xpath("(//*[contains(@id,'responseMappingMobifinPacketField')])[last()]");
	By txtResponseMappingDeafultValueField = By
			.xpath("(//*[contains(@id,'responseMappingDefaultValueField')])[last()]");
	By verifyerror = By.xpath("//*[contains(@class,'alert-error')]");
	String navigate = "//*[normalize-space(text())='%s']";
	String verifyapifield = "//*[contains(@class,'tabpane-active')]//tr[%s]//td[normalize-space(text())='%s'][last()]";
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String providerApiName = "//*[normalize-space(text()) = 'Provider Api Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String timeOut = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.timeout", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String failureCode = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.failureCode", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String successCode = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.successCode", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String communicationProtocol = "//*[normalize-space(text()) = 'Communication Protocol']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String apiUrl = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.apiUrl", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String httpType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.httpType", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String requestType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.requestType", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String httpProtocol = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.httpProtocol", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String retryCount = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("servicevendor.retryCount", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String connectionType = "//*[normalize-space(text()) = 'Connection Type']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String host = "//*[normalize-space(text()) = 'Host']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String port = "//*[normalize-space(text()) = 'Port']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String StartTLS = "//*[normalize-space(text()) = 'Library']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String auth = "//*[normalize-space(text()) = 'Auth']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String apiTemplate = "//*[normalize-space(text()) = 'API Template']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";

	public BusinessConfigurationTechnicalVendorPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtTechnicalVendorName, name, 1);
	}

	public void selectVendorService(String vendorService) {
		selectFromDropDown(drpVendorService, By.xpath(String.format(dropDownValue, vendorService)), 0);
	}

	public void selectOperatingEntity(String operatingEntity) {
		selectFromDropDown(drpOperatingEntity, By.xpath(String.format(dropDownValue, operatingEntity)), 0);
	}

	public void sendTextInProviderApiName(String providerApiName) {
		sendKeys(txtProviderApiName, providerApiName, 0);
	}

	public void sendTextInTimeOut(String timeOut) {
		sendKeys(txtTimeOut, timeOut, 0);
	}

	public void sendTextInFailureCode(String failureCode) {
		sendKeys(txtFailureCode, failureCode, 0);
	}

	public void sendTextInSuccessCode(String successCode) {
		sendKeys(txtSucessCode, successCode, 0);
	}

	public void selectCommunicationProtocol(String communicationProtocol) {
		selectFromDropDown(drpCommunicationProtocol, By.xpath(String.format(dropDownValue, communicationProtocol)), 0);
	}

	public void selectHttpType(String httpType) {
		selectFromDropDown(drpHttpType, By.xpath(String.format(dropDownValue, httpType)), 0);
	}

	public void selectRequestType(String requestType) {
		selectFromDropDown(drpRequestType, By.xpath(String.format(dropDownValue, requestType)), 0);
	}

	public void selectHttpProtocol(String httpProtocol) {
		selectFromDropDown(drpHttpProtocol, By.xpath(String.format(dropDownValue, httpProtocol)), 0);
	}

	public void sendTextInApiUrl(String apiUrl) {
		sendKeys(txtApiUrl, apiUrl, 0);
	}

	public void sendTextInRetryCount(String retryCount) {
		sendKeys(txtRetryCount, retryCount, 0);
	}

	public void sendTextInSSLPassword(String sslPassword) {
		sendKeys(txtSSLPassword, sslPassword, 0);
	}

	public void sendTextInAPITemplate(String apiTemplate) {
		sendKeys(txtApiTemplate, apiTemplate);
	}

	public void clickOnSubmit() {
		clickOnElement(btnSubmit);
	}

	public void selectConnectionType(String connectionType) {
		selectFromDropDown(drpConnectionType, By.xpath(String.format(dropDownValue, connectionType)), 0);
	}

	public void selectAuth(String auth) {
		selectFromDropDown(drpAuth, By.xpath(String.format(dropDownValue, auth)), 0);
	}

	public void selectStartTLS(String startTLS) {
		clickOnElement(drpStartTLS);
		clickOnElement(By.xpath("(//li[normalize-space(text())='" + startTLS + "'])[last()]"));
	}

	public void sendTextInHost(String host) {
		sendKeys(txtHost, host);
	}

	public void sendTextInPort(String port) {
		sendKeys(txtPort, port);
	}

	public void sendTextInSoapUrl(String soapUrl) {
		sendKeys(txtSoapUrl, soapUrl);
	}

	public void selectSoapVersion(String soapVersion) {
		clickOnElement(drpSoapVersion);
		clickOnElement(By.xpath("//li[normalize-space(text())='" + soapVersion + "']"));
	}

	public void sendTextInTechnicalVendorNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name, 0);
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(dropDownValue, status)), 1);
	}

	public void clickOnAddField() {
		clickOnElement(btnAddKYCLevel);
	}

	public void filterSearch(String str1, String str2, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInTechnicalVendorNameFilterSearch(str1);
		selectStatusInFilterSearch(str2);
		common.clickOnFilterSearchBtn();
	}

	public void addTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		if (!map.get(mapKeys.get(2)).toString().equals("")) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			clickOnElement(btnAddService);
			selectVendorService(map.get(mapKeys.get(2)).toString());
			clickOnElement(btnNext);
		} else {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			selectVendorService(map.get(mapKeys.get(3)).toString());
			clickOnElement(btnNext);
		}
		sendTextInProviderApiName(map.get(mapKeys.get(5)).toString());
		sendTextInTimeOut(map.get(mapKeys.get(6)).toString());
		sendTextInFailureCode(map.get(mapKeys.get(7)).toString());
		sendTextInSuccessCode(map.get(mapKeys.get(8)).toString());
		selectCommunicationProtocol(map.get(mapKeys.get(9)).toString());
		clickOnElement(btnNext);
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				sendTextInApiUrl(map.get(mapKeys.get(10)).toString());
				selectHttpType(map.get(mapKeys.get(12)).toString());
				selectRequestType(map.get(mapKeys.get(13)).toString());
			}
			selectHttpProtocol(map.get(mapKeys.get(11)).toString());
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				sendTextInRetryCount(map.get(mapKeys.get(14)).toString());
			}
			if (map.get(mapKeys.get(11)).toString().toLowerCase().equals("https")) {
				sendTextInSSLPassword(map.get(mapKeys.get(15)).toString());
				// sendTextInSSLCertificate(map.get(mapKeys.get(16)).toString());
			}
		}
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
			selectConnectionType(map.get(mapKeys.get(30)).toString());
			sendTextInHost(map.get(mapKeys.get(31)).toString());
			sendTextInPort(map.get(mapKeys.get(32)).toString());
			if (!map.get(mapKeys.get(33)).toString().trim().equals("")) {
				selectAuth(map.get(mapKeys.get(33)).toString());
				selectStartTLS(map.get(mapKeys.get(34)).toString());
			}
		}
		if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
			clickOnElement(btnNext);
			int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
			String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
			String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
			String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				clickOnAddField();
				sendKeys(txtHeaderMappingApiField, apiFieldList[m], 1);
				sendKeys(txtHeaderMappingApiField, mobifinPacketList[m], 1);
				sendKeys(txtHeaderMappingDeafultValueField, defaultValueList[m], 1);

			}
			clickOnElement(btnNext);
		}
		if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
			sendTextInAPITemplate(map.get(mapKeys.get(21)).toString());
		} else {
			if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
				int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
				String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
				String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
				String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
				for (int k = 0; k < requestrows; k++) {
					clickOnAddField();
					sendKeys(txtRequestMappingApiField, requestapiFieldList[k], 1);
					sendKeys(txtReaderMappingMobifinPacketField, requestmobifinPacketList[k], 1);
					sendKeys(txtReaderMappingDeafultValueField, requestdefaultValueList[k], 1);
				}
			}
		}
		if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
			clickOnElement(btnNext);
			int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
			String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
			String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
			String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
			for (int j = 0; j < responserows; j++) {
				clickOnAddField();
				sendKeys(txtResponseMappingApiField, responseapiFieldList[j], 1);
				sendKeys(txtResponseMappingMobifinPacketField, responsemobifinPacketList[j], 1);
				sendKeys(txtResponseMappingDeafultValueField, responsedefaultValueList[j], 1);
			}
		}
		clickOnSubmit();
		if (verifyVisible(verifyerror, 0)) {
			common.clickOnBackBtn();
			log("Given Technical Vendor Already Exits");
		}
	}

	public void verifyAddedTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		selectVendorService(map.get(mapKeys.get(3)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);

		String[] navigation = map.get(mapKeys.get(36)).toString().split(",");
		clickOnElement(By.xpath(String.format(navigate, navigation[0].trim())));
		verifyVisible(By.xpath(String.format(providerApiName, map.get(mapKeys.get(5)).toString())), 0);
		verifyVisible(By.xpath(String.format(timeOut, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(failureCode, map.get(mapKeys.get(7)).toString())), 0);
		verifyVisible(By.xpath(String.format(successCode, map.get(mapKeys.get(8)).toString())), 0);
		verifyVisible(By.xpath(String.format(communicationProtocol, map.get(mapKeys.get(9)).toString())), 0);
		clickOnElement(By.xpath(String.format(navigate, navigation[1].trim())));
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				verifyVisible(By.xpath(String.format(apiUrl, map.get(mapKeys.get(10)).toString())), 0);
				verifyVisible(By.xpath(String.format(httpType, map.get(mapKeys.get(12)).toString())), 0);
				verifyVisible(By.xpath(String.format(requestType, map.get(mapKeys.get(13)).toString())), 0);
			}
			verifyVisible(By.xpath(String.format(httpProtocol, map.get(mapKeys.get(11)).toString())), 0);
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				verifyVisible(By.xpath(String.format(retryCount, map.get(mapKeys.get(14)).toString())), 0);
			}
		}
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
			verifyVisible(By.xpath(String.format(connectionType, map.get(mapKeys.get(30)).toString())), 0);
			verifyVisible(By.xpath(String.format(host, map.get(mapKeys.get(31)).toString())), 0);
			verifyVisible(By.xpath(String.format(port, map.get(mapKeys.get(32)).toString())), 0);
			if (!map.get(mapKeys.get(34)).toString().trim().equals("")) {
				verifyVisible(By.xpath(String.format(StartTLS, map.get(mapKeys.get(34)).toString())), 0);
				verifyVisible(By.xpath(String.format(auth, map.get(mapKeys.get(35)).toString())), 0);
			}
		}
		if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
			clickOnElement(By.xpath(String.format(navigate, navigation[2].trim())));
			int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
			String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
			String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
			String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
			for (int i = 0; i < rows; i++) {
				verifyVisible(By.xpath(String.format(verifyapifield, String.valueOf(i + 1), apiFieldList[i].trim())),
						0);
				verifyVisible(
						By.xpath(String.format(verifyapifield, String.valueOf(i + 1), mobifinPacketList[i].trim())), 0);
				verifyVisible(
						By.xpath(String.format(verifyapifield, String.valueOf(i + 1), defaultValueList[i].trim())), 0);
			}
			clickOnElement(By.xpath(String.format(navigate, navigation[3].trim())));
		}
		if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(apiTemplate, map.get(mapKeys.get(21)).toString())), 0);
		} else {
			if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
				int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
				String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
				String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
				String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
				for (int x = 0; x < requestrows; x++) {
					verifyVisible(By.xpath(
							String.format(verifyapifield, String.valueOf(x + 1), requestapiFieldList[x].trim())), 0);
					verifyVisible(By.xpath(
							String.format(verifyapifield, String.valueOf(x + 1), requestmobifinPacketList[x].trim())),
							0);
					verifyVisible(By.xpath(
							String.format(verifyapifield, String.valueOf(x + 1), requestdefaultValueList[x].trim())),
							0);
				}
			}
		}
		if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
			clickOnElement(By.xpath(String.format(navigate, navigation[4].trim())));
			int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
			String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
			String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
			String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
			for (int y = 0; y < responserows; y++) {
				verifyVisible(
						By.xpath(String.format(verifyapifield, String.valueOf(y + 1), responseapiFieldList[y].trim())),
						0);
				verifyVisible(By.xpath(
						String.format(verifyapifield, String.valueOf(y + 1), responsemobifinPacketList[y].trim())), 0);
				verifyVisible(By.xpath(
						String.format(verifyapifield, String.valueOf(y + 1), responsedefaultValueList[y].trim())), 0);
			}
		}
	}

	public boolean editTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			selectVendorService(map.get(mapKeys.get(3)).toString());
			clickOnElement(btnNext);
			sendTextInProviderApiName(map.get(mapKeys.get(5)).toString());
			sendTextInTimeOut(map.get(mapKeys.get(6)).toString());
			sendTextInFailureCode(map.get(mapKeys.get(7)).toString());
			sendTextInSuccessCode(map.get(mapKeys.get(8)).toString());
			clickOnElement(btnNext);
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
				if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
					sendTextInApiUrl(map.get(mapKeys.get(10)).toString());
					selectHttpType(map.get(mapKeys.get(12)).toString());
					selectRequestType(map.get(mapKeys.get(13)).toString());
				}
				selectHttpProtocol(map.get(mapKeys.get(11)).toString());
				if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
					sendTextInRetryCount(map.get(mapKeys.get(14)).toString());
				}
				if (map.get(mapKeys.get(11)).toString().toLowerCase().equals("https")) {
					sendTextInSSLPassword(map.get(mapKeys.get(15)).toString());
					// sendTextInSSLCertificate(map.get(mapKeys.get(16)).toString());
				}
			}
			if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				selectConnectionType(map.get(mapKeys.get(30)).toString());
				sendTextInHost(map.get(mapKeys.get(31)).toString());
				sendTextInPort(map.get(mapKeys.get(32)).toString());
				if (!map.get(mapKeys.get(33)).toString().trim().equals("")) {
					selectAuth(map.get(mapKeys.get(33)).toString());
					selectStartTLS(map.get(mapKeys.get(34)).toString());
				}
			}
			if (!map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				clickOnElement(btnNext);
			}
			if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
				int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
				String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
				String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					clickOnAddField();
					sendKeys(txtHeaderMappingApiField, apiFieldList[m], 1);
					sendKeys(txtHeaderMappingApiField, mobifinPacketList[m], 1);
					sendKeys(txtHeaderMappingDeafultValueField, defaultValueList[m], 1);

				}
			}
			if (!map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				clickOnElement(btnNext);
			}
			if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
				sendTextInAPITemplate(map.get(mapKeys.get(21)).toString());
			} else {
				if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
					int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
					String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
					String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
					String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
					for (int z = 0; z < requestrows; z++) {
						clickOnAddField();
						sendKeys(txtRequestMappingApiField, requestapiFieldList[z], 1);
						sendKeys(txtReaderMappingMobifinPacketField, requestmobifinPacketList[z], 1);
						sendKeys(txtReaderMappingDeafultValueField, requestdefaultValueList[z], 1);
					}
				}
			}
			if (!map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
				clickOnElement(btnNext);
			}
			if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
				int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
				String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
				String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
				String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
				for (int n = 0; n < responserows; n++) {
					clickOnAddField();
					sendKeys(txtResponseMappingApiField, responseapiFieldList[n], 1);
					sendKeys(txtResponseMappingMobifinPacketField, responsemobifinPacketList[n], 1);
					sendKeys(txtResponseMappingDeafultValueField, responsedefaultValueList[n], 1);
				}
			}
			clickOnSubmit();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(35)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		selectVendorService(map.get(mapKeys.get(3)).toString());
		String[] navigation = map.get(mapKeys.get(36)).toString().split(",");
		clickOnElement(By.xpath(String.format(navigate, navigation[0].trim())));
		verifyVisible(By.xpath(String.format(providerApiName, map.get(mapKeys.get(5)).toString())), 0);
		verifyVisible(By.xpath(String.format(timeOut, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(failureCode, map.get(mapKeys.get(7)).toString())), 0);
		verifyVisible(By.xpath(String.format(successCode, map.get(mapKeys.get(8)).toString())), 0);
		verifyVisible(By.xpath(String.format(communicationProtocol, map.get(mapKeys.get(9)).toString())), 0);
		clickOnElement(By.xpath(String.format(navigate, navigation[1].trim())));
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("rest")) {
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				verifyVisible(By.xpath(String.format(apiUrl, map.get(mapKeys.get(10)).toString())), 0);
				verifyVisible(By.xpath(String.format(httpType, map.get(mapKeys.get(12)).toString())), 0);
				verifyVisible(By.xpath(String.format(requestType, map.get(mapKeys.get(13)).toString())), 0);
			}
			verifyVisible(By.xpath(String.format(httpProtocol, map.get(mapKeys.get(11)).toString())), 0);
			if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
				verifyVisible(By.xpath(String.format(retryCount, map.get(mapKeys.get(14)).toString())), 0);
			}
		}
		if (map.get(mapKeys.get(9)).toString().toLowerCase().equals("smtp")) {
			verifyVisible(By.xpath(String.format(connectionType, map.get(mapKeys.get(30)).toString())), 0);
			verifyVisible(By.xpath(String.format(host, map.get(mapKeys.get(31)).toString())), 0);
			verifyVisible(By.xpath(String.format(port, map.get(mapKeys.get(32)).toString())), 0);
			if (!map.get(mapKeys.get(34)).toString().trim().equals("")) {
				verifyVisible(By.xpath(String.format(StartTLS, map.get(mapKeys.get(34)).toString())), 0);
				verifyVisible(By.xpath(String.format(auth, map.get(mapKeys.get(35)).toString())), 0);
			}
		}
		if (!map.get(mapKeys.get(17)).toString().trim().equals("")) {
			clickOnElement(By.xpath(String.format(navigate, navigation[2].trim())));
			int rows = Integer.parseInt(map.get(mapKeys.get(17)).toString());
			String[] apiFieldList = map.get(mapKeys.get(18)).toString().split(",");
			String[] mobifinPacketList = map.get(mapKeys.get(18)).toString().split(",");
			String[] defaultValueList = map.get(mapKeys.get(19)).toString().split(",");
			for (int m = 0; m < rows; m++) {
				verifyVisible(By.xpath(String.format(verifyapifield, String.valueOf(m + 1), apiFieldList[m].trim())),
						0);
				verifyVisible(
						By.xpath(String.format(verifyapifield, String.valueOf(m + 1), mobifinPacketList[m].trim())), 0);
				verifyVisible(
						By.xpath(String.format(verifyapifield, String.valueOf(m + 1), defaultValueList[m].trim())), 0);
			}
			clickOnElement(By.xpath(String.format(navigate, navigation[3].trim())));
		}
		if (!map.get(mapKeys.get(21)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(apiTemplate, map.get(mapKeys.get(21)).toString())), 0);
		} else {
			if (!map.get(mapKeys.get(22)).toString().trim().equals("")) {
				int requestrows = Integer.parseInt(map.get(mapKeys.get(22)).toString());
				String[] requestapiFieldList = map.get(mapKeys.get(23)).toString().split(",");
				String[] requestmobifinPacketList = map.get(mapKeys.get(24)).toString().split(",");
				String[] requestdefaultValueList = map.get(mapKeys.get(25)).toString().split(",");
				for (int x = 0; x < requestrows; x++) {
					verifyVisible(By.xpath(
							String.format(verifyapifield, String.valueOf(x + 1), requestapiFieldList[x].trim())), 0);
					verifyVisible(By.xpath(
							String.format(verifyapifield, String.valueOf(x + 1), requestmobifinPacketList[x].trim())),
							0);
					verifyVisible(By.xpath(
							String.format(verifyapifield, String.valueOf(x + 1), requestdefaultValueList[x].trim())),
							0);
				}
			}
		}
		if (!map.get(mapKeys.get(26)).toString().trim().equals("")) {
			clickOnElement(By.xpath(String.format(navigate, navigation[4].trim())));
			int responserows = Integer.parseInt(map.get(mapKeys.get(26)).toString());
			String[] responseapiFieldList = map.get(mapKeys.get(27)).toString().split(",");
			String[] responsemobifinPacketList = map.get(mapKeys.get(28)).toString().split(",");
			String[] responsedefaultValueList = map.get(mapKeys.get(29)).toString().split(",");
			for (int y = 0; y < responserows; y++) {
				verifyVisible(
						By.xpath(String.format(verifyapifield, String.valueOf(y + 1), responseapiFieldList[y].trim())),
						0);
				verifyVisible(By.xpath(
						String.format(verifyapifield, String.valueOf(y + 1), responsemobifinPacketList[y].trim())), 0);
				verifyVisible(By.xpath(
						String.format(verifyapifield, String.valueOf(y + 1), responsedefaultValueList[y].trim())), 0);
			}
		}
	}

	public boolean deleteTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
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

	public boolean verifyDeletedTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		return verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5);
	}

	public boolean sortTechnicalVendor(Map<Object, Object> map, List<Object> mapKeys) {
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
