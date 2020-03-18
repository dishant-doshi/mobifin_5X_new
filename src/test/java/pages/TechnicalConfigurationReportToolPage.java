package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class TechnicalConfigurationReportToolPage extends SetupInit {

	By txtName = By.id("inputReporttoolAddName");
	By txtDescription = By.id("inputReporttoolAddSrNo");
	By drpFieldType = By.xpath("//*[@id='inputReportToolAddFieldtype']//*[@class='ant-select-arrow']");
	String IsYes = "Yes";
	By btnAddColumn = By.xpath("//*[normalize-space(text())='Add Columns']//parent::button");
	By btnAddFilter = By.xpath("//*[normalize-space(text())='Add Filters']//parent::button");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By
			.xpath("//*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id("inputReporttoolEditDescription");
	By txtQuery = By.id("inputReporttoolAddQuery");
	By drpParameter = By.xpath("(//*[contains(@id,'parameters')]//*[@class='ant-select-arrow'])[last()]");
	By txtDefaultValue = By.xpath("(//*[contains(@id,'defaultValue')])[last()]");
	By drpDefaultCriteria = By.xpath("(//*[contains(@id,'defaultCriteria')]//*[@class='ant-select-arrow'])[last()]");
	By drpDataType = By.xpath("(//*[contains(@id,'datatype')]//*[@class='ant-select-arrow'])[last()]");
	By drpAlignment = By.xpath("(//*[contains(@id,'alignment')]//*[@class='ant-select-arrow'])[last()]");
	By txtDisplayName = By.xpath("(//*[contains(@id,'displayname')])[last()]");
	By txtColumnName = By.xpath("(//*[contains(@id,'columnname')])[last()]");
	By txtQueryInEdit = By.id("inputReporttoolEditQuery");
	String data="(//td[text()='%s'])[1]";
	String outputList="//*[normalize-space(text()) = 'Output File Format']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String name = "//*[normalize-space(text()) = 'Name']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = 'Description']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = 'Status']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	By fileFormat=By.xpath("//*[text()='Output File Format']");
	String list="//*[normalize-space(text()) = 'Output File Format']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	String element="(//li[normalize-space(text())='%s'])[last()]";
	By drpValue=By.xpath("(//*[@id='inputReportToolAddPossiblevalue'])[last()]");
	String child="//*[normalize-space(text())='%s']";
	By visible=By.xpath("(//*[contains(@id,'visible')])[last()]");
	By mandatory=By.xpath("(//*[contains(@id,'isMandatory')])[last()]");
	String editStatus="//*[@id='inputReporttoolAddStatus']//span[normalize-space(text())='%s']";
	String editReport="//*[@id='inputReporttoolEditReportType']//span[normalize-space(text())='%s']";
	String report="//*[@id='inputReporttoolAddReporttype']//span[normalize-space(text())='%s]";
	String selectStatus="//*[@id='inputReporttoolAddStatus']//span[normalize-space(text())='%s']";
	By editFileFormat=By.xpath("//*[@id='inputReporttoolEditFileformat']//input");
	By addFileFormat=By.xpath("//*[@id='inputReporttoolAddOutputFileFormat']//input");
	
	private CommonPage common;

	public TechnicalConfigurationReportToolPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void sendTextInName(String name) {
		sendKeys(txtName, name,0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description,0);
	}

	public void sendTextInOutputFileFormat(String outputFileFormat) {
		sendKeys(addFileFormat,outputFileFormat + Keys.ENTER);
	}

	public void sendTextInOutputFileFormatInEdit(String outputFileFormat) {
		sendKeys(editFileFormat, outputFileFormat + Keys.ENTER);
	}

	public void sendTextInDescriptionInEdit(String description) {
	
			sendKeys(txtDescriptionInEdit, description,0);
	}

	public void select(String fieldType) {
		clickOnElement(drpFieldType);
		clickOnElement(By.xpath(String.format(child, fieldType.trim())));
	}

	public void sendTextInQuery(String query) {
		sendKeys(txtQuery, query);
	}

	public void sendTextInQueryInEdit(String query) {
		sendKeys(txtQueryInEdit, query);
	}

	public void sendTextInDeafaltValue(String defaultValue) {
		sendKeys(txtDefaultValue, defaultValue);
	}

	public void sendTextInDisplayName(String displayName) {
		sendKeys(txtDisplayName, displayName);
	}

	public void sendTextInColumnName(String columnName) {
		sendKeys(txtColumnName, columnName);
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(selectStatus, status.trim())),1);
	}

	public void selectReportType(String reportType) {
		clickOnElement(By.xpath(String.format(report, reportType.trim())));
	}

	public void selectReportTypeInEdit(String reportType) {
		clickOnElement(By.xpath(String.format(editReport, reportType.trim())));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(editStatus, status)),1);
	}

	public void selectIsMandatory(String isMandatory) {
		if (isMandatory.equalsIgnoreCase(IsYes)) {
			clickOnElement(mandatory);
		}
	}

	public void selectIsVisible(String isVisible) {
		if (!isVisible.equalsIgnoreCase(IsYes)) {
			clickOnElement(visible);
		}
	}

	public void clickOnAddColumn() {
		clickOnElement(btnAddColumn);
	}

	public void clickOnAddFilters() {
		clickOnElement(btnAddFilter);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectChildField(String childField) {
		clickOnElement(By.xpath(String.format(child, childField.trim())));
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(element, status.trim())),1);
	}

	public void sendTextInPossibleValueInDropdown(String possibleValue) {
		sendKeys(drpValue, possibleValue);
	}

	public void selectParameter(String parameter) {
		clickOnElement(drpParameter);
		clickOnElement(By.xpath(String.format(element, parameter.trim())));
	}

	public void selectDefaultCriteria(String defaultCriteria) {
		clickOnElement(drpDefaultCriteria);
		clickOnElement(By.xpath(String.format(element, defaultCriteria.trim())));
	}

	public void selectDataType(String dataType) {
		clickOnElement(drpDataType);
		clickOnElement(By.xpath(String.format(element, dataType.trim())));
	}

	public void selectAlignment(String alignment) {
		clickOnElement(drpAlignment);
		clickOnElement(By.xpath(String.format(element, alignment.trim())));
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

	public void addReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
			for (int m = 0; m < OutputFileFormatList.length; m++) {
				sendTextInOutputFileFormat(OutputFileFormatList[m].trim());
				clickOnElement(fileFormat);
			}
			selectStatus(map.get(mapKeys.get(4)).toString());
			selectReportType(map.get(mapKeys.get(5)).toString());
			sendTextInQuery(map.get(mapKeys.get(6)).toString());
			if (!map.get(mapKeys.get(5)).toString().toLowerCase().equals("scheduled")) {
				String[] fieldNameList = map.get(mapKeys.get(7)).toString().split(",");
				String[] defaultValueList = map.get(mapKeys.get(8)).toString().split(",");
				String[] defaultCriteriaList = map.get(mapKeys.get(9)).toString().split(",");
				String[] ismandatory = map.get(mapKeys.get(10)).toString().split(",");
				String[] isVisible = map.get(mapKeys.get(11)).toString().split(",");
				for (int m = 0; m < fieldNameList.length; m++) {
					clickOnAddFilters();
					selectParameter(fieldNameList[m].trim());
					sendTextInDeafaltValue(defaultValueList[m].trim());
					selectDefaultCriteria(defaultCriteriaList[m].trim());
					selectIsMandatory(ismandatory[m].trim());
					selectIsVisible(isVisible[m].trim());
				}
				int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
				String[] displayNameList = map.get(mapKeys.get(13)).toString().split(",");
				String[] columnNameList = map.get(mapKeys.get(14)).toString().split(",");
				String[] dataTypeList = map.get(mapKeys.get(15)).toString().split(",");
				String[] alignmentList = map.get(mapKeys.get(16)).toString().split(",");
				for (int m = 0; m < rows; m++) {
					sendTextInDisplayName(displayNameList[m].trim());
					sendTextInColumnName(columnNameList[m].trim());
					selectDataType(dataTypeList[m].trim());
					selectAlignment(alignmentList[m].trim());
					if (m < rows - 1) {
						clickOnAddColumn();
					}
				}
			}
			common.clickOnSaveBtn();
		}
	}

	public boolean verifyAddedReportTool(Map<Object, Object> map, List<Object> mapKeys) {

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())), 0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0))
				return false;
			String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
			for (int m = 0; m < OutputFileFormatList.length; m++) {
				if (!verifyVisible(By.xpath(String.format(list, OutputFileFormatList[m].toUpperCase())), 0))
					return false;
			}
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(4)).toString())),1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	public boolean editReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
		
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			if (!map.get(mapKeys.get(3)).toString().equals("")) {
				String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
				for (int m = 0; m < OutputFileFormatList.length; m++) {
					sendTextInOutputFileFormatInEdit(OutputFileFormatList[m].trim());
					clickOnElement(fileFormat);
				}
			}
			if (!map.get(mapKeys.get(5)).toString().equals("")) {
				selectReportTypeInEdit(map.get(mapKeys.get(5)).toString());
			}
			if (!map.get(mapKeys.get(6)).toString().equals("")) {
				sendTextInQueryInEdit(map.get(mapKeys.get(6)).toString());
			}
			if (!map.get(mapKeys.get(5)).toString().toLowerCase().equals("scheduled")) {
				if (!map.get(mapKeys.get(7)).toString().equals("")) {
					String[] fieldNameList = map.get(mapKeys.get(7)).toString().split(",");
					String[] defaultValueList = map.get(mapKeys.get(8)).toString().split(",");
					String[] defaultCriteriaList = map.get(mapKeys.get(9)).toString().split(",");
					String[] ismandatory = map.get(mapKeys.get(10)).toString().split(",");
					String[] isVisible = map.get(mapKeys.get(11)).toString().split(",");
					for (int m = 0; m < fieldNameList.length; m++) {
						clickOnAddFilters();
						selectParameter(fieldNameList[m].trim());
						sendTextInDeafaltValue(defaultValueList[m].trim());
						selectDefaultCriteria(defaultCriteriaList[m].trim());
						selectIsMandatory(ismandatory[m].trim());
						selectIsVisible(isVisible[m].trim());
					}
				}
				if (!map.get(mapKeys.get(12)).toString().equals("")) {
					int rows = Integer.parseInt(map.get(mapKeys.get(12)).toString());
					String[] displayNameList = map.get(mapKeys.get(13)).toString().split(",");
					String[] columnNameList = map.get(mapKeys.get(14)).toString().split(",");
					String[] dataTypeList = map.get(mapKeys.get(15)).toString().split(",");
					String[] alignmentList = map.get(mapKeys.get(16)).toString().split(",");
					for (int m = 0; m < rows; m++) {
						sendTextInDisplayName(displayNameList[m].trim());
						sendTextInColumnName(columnNameList[m].trim());
						selectDataType(dataTypeList[m].trim());
						selectAlignment(alignmentList[m].trim());
						if (m < rows - 1) {
							clickOnAddColumn();

						}
					}
				}
			}
			selectStatusInEdit(map.get(mapKeys.get(17)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEditedReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(17)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			if (!verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0))
				return false;
			if (!verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0))
				return false;
			String[] OutputFileFormatList = map.get(mapKeys.get(3)).toString().split(",");
			for (int m = 0; m < OutputFileFormatList.length; m++) {
				if (!verifyVisible(By
						.xpath(String.format(outputList, OutputFileFormatList[m].toUpperCase())), 0))
					return false;
			}
			if (!verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(17)).toString())), 1))
				return false;
			return true;
		} else {
			return false;
		}
	}

	
	public boolean deleteReportTool(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.delete();
			return true;
		} else {
			String string = "ReportTool already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
	}

	public boolean verifyDeletedReportTool(Map<Object, Object> map, List<Object> mapKeys) {
			filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(), true);
			return verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(1)).toString())),5);
	}
	
	
	
}
