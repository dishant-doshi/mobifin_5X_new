package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class PlatformConfigurationCounterPage extends SetupInit {
	private CommonPage common;
	By txtName = By.id(Utility.readJSFile("INPUT_COUNTER_ADD_NAME", CommonConstants.ELEMENT_FILE));
	By txtDescription = By.id(Utility.readJSFile("INPUT_COUNTER_ADD_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By txtInterval = By.id(Utility.readJSFile("INPUT_COUNTER_ADD_INTERVAL", CommonConstants.ELEMENT_FILE));
	By txtIntervalInEdit = By.id(Utility.readJSFile("INPUT_COUNTER_EDIT_INTERVAL", CommonConstants.ELEMENT_FILE));
	By txtCounterLimit = By.id(Utility.readJSFile("INPUT_COUNTER_ADD_COUNTERLIMIT", CommonConstants.ELEMENT_FILE));
	By txtCounterLimitInEdit = By
			.id(Utility.readJSFile("INPUT_COUNTER_EDIT_COUNTERLIMIT", CommonConstants.ELEMENT_FILE));
	By txtOccurence = By.id(Utility.readJSFile("INPUT_COUNTER_ADD_OCCURENCE", CommonConstants.ELEMENT_FILE));
	By txtOccurenceInEdit = By.id(Utility.readJSFile("INPUT_COUNTER_EDIT_OCCURENCE", CommonConstants.ELEMENT_FILE));
	By drpCreditOn = By.xpath("//*[@id='" + Utility.readJSFile("INPUT_UCP_ADD_CREDITON", CommonConstants.ELEMENT_FILE)
			+ "']//*[@class='ant-select-arrow']");
	By drpDayOftheWeek = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_COUNTER_ADD_WEEKDAYS", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpDayOftheWeekInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_COUNTER_EDIT_WEEKDAYS", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpDayOfMonth = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_COUNTER_ADD_MONTHOFDAY", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpDayOfMonthInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_COUNTER_EDIT_MONTHOFDAY", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpMonthOfYear = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_COUNTER_ADD_MONTHOFYEAR", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpMonthOfYearInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_COUNTER_EDIT_MONTHOFYEAR", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By drpCreditOnInEdit = By
			.xpath("//*[@id='" + Utility.readJSFile("INPUT_UCP_EDIT_CREDITON", CommonConstants.ELEMENT_FILE)
					+ "']//*[@class='ant-select-arrow']");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"//*[normalize-space(text())='Status']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpResetTypeInSearch = By.xpath("//*[normalize-space(text())='"
			+ Utility.readJSFile("counter.grid.resettype", CommonConstants.LABLE_FILE)
			+ "']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpCountOnInSearch = By.xpath(
			"//*[normalize-space(text())='Count On']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By txtDescriptionInEdit = By.id(Utility.readJSFile("INPUT_COUNTER_EDIT_DESCRIPTION", CommonConstants.ELEMENT_FILE));
	By drpCounterTypeInSearch = By.xpath(
			"//*[normalize-space(text())='Counter Type']//ancestor :: div[@class='ant-form-item-label']//following-sibling :: div//ancestor :: span[@class='ant-select-arrow']");
	By drpUnit = By.xpath("//*[@id='"
			+ Utility.readJSFile("INPUT_COUNTER_ADD_COUNTERONVALUE", CommonConstants.ELEMENT_FILE) + "']//li");
	By drpUnitInEdit = By.xpath("//input[@id='"
			+ Utility.readJSFile("INPUT_COUNTER_EDIT_COUNTERONVALUE", CommonConstants.ELEMENT_FILE) + "']");

	String counterOnLoc = "//*[@id='" + Utility.readJSFile("INPUT_COUNTER_ADD_COUNTON", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";

	String counterOnLocEdit = "//*[@id='"
			+ Utility.readJSFile("INPUT_COUNTER_EDIT_COUNTON", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";

	String resetTypeLoc = "//*[@id='" + Utility.readJSFile("INPUT_COUNTER_ADD_RESET_TYPE", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";

	String unitLoc = "(//li[normalize-space(text())='%s'])[last()]";
	String statusValLoc = "//*[@id='inputCounterAddStatus']//span[normalize-space(text())='%s']";

	String monitorTypeLoc = "//*[@id='"
			+ Utility.readJSFile("INPUT_COUNTER_ADD_MONITORING_ENDTYPE", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";
	String monitorTypeInEditLoc = "//*[@id='"
			+ Utility.readJSFile("INPUT_COUNTER_EDIT_MONITORING_ENDTYPE", CommonConstants.ELEMENT_FILE)
			+ "']//span[normalize-space(text())='%s']";

	String statusValInEditLoc = "//*[@id='inputCountereditStatus']//span[normalize-space(text())='%s']";
	String drpdwnValLoc = "(//*[normalize-space(text())='%s'])[last()]";

	By dropDown = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By dropDownVal2 = By.xpath("//li[normalize-space(text())='Equals']");
	String verifyElement = "(//td[text()='%s'])[1]";
	By addCounterVal = By.id(Utility.readJSFile("INPUT_COUNTER_ADD_COUNTERONVALUE", CommonConstants.ELEMENT_FILE));
	String verifyUnit = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.counteronvalue", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String name = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.name", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String description = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.description", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String countOn = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.counton", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String counterLimit = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.counterlimit", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String resetType = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.resettype", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String dayOftheWeek = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.dayoftheweek", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String dayOfMonth = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.dayofthemonth", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String monthOfYear = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.monthofyear", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[contains(text(),'%s')]";
	String interval = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.interval", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String occurence = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.occurrence", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	String status = "//*[normalize-space(text()) = '"
			+ Utility.readJSFile("counter.label.status", CommonConstants.LABLE_FILE)
			+ "']//ancestor:: div[@class='ant-row ant-form-item']//*[normalize-space(text())='%s']";
	By verifyCountValue = By.id(Utility.readJSFile("INPUT_COUNTER_EDIT_COUNTERONVALUE", CommonConstants.ELEMENT_FILE));
	String verifyUnitType = "//*[@id='"
			+ Utility.readJSFile("INPUT_COUNTER_EDIT_COUNTERONVALUE", CommonConstants.ELEMENT_FILE)
			+ "']//*[normalize-space(text())='%s']";
	By verifyoccurance = By.id(Utility.readJSFile("INPUT_COUNTER_EDIT_OCCURENCE", CommonConstants.ELEMENT_FILE));

	public PlatformConfigurationCounterPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void sendTextInName(String name) {
		sendKeys(txtName, name, 0);
	}

	public void sendTextInDescription(String description) {
		sendKeys(txtDescription, description, 0);
	}

	public void sendTextInInterval(String interval) {
		sendKeys(txtInterval, interval, 0);
	}

	public void sendTextInIntervalInEdit(String interval) {
		sendKeys(txtIntervalInEdit, interval, 0);
	}

	public void sendTextInOccurence(String occurence) {
		sendKeys(txtOccurence, occurence, 0);
	}

	public void sendTextInOccurenceInEdit(String occurence) {
		sendKeys(txtOccurenceInEdit, occurence, 0);
	}

	public void sendTextInCounterLimit(String counterLimit) {
		sendKeys(txtCounterLimit, counterLimit, 0);
	}

	public void sendTextInCounterLimitInEdit(String counterLimit) {
		sendKeys(txtCounterLimitInEdit, counterLimit, 0);
	}

	public void selectCountOn(String counterOn) {
		clickOnElement(By.xpath(String.format(counterOnLoc, counterOn.trim())));
	}

	public void selectCountOnInEdit(String counterOn) {
		clickOnElement(By.xpath(String.format(counterOnLocEdit, counterOn)));
	}

	public void selectResetType(String resetType) {
		clickOnElement(By.xpath(String.format(resetTypeLoc, resetType.trim())));
	}

	public void selectResetTypeInEdit(String resetType) {
		clickOnElement(By.xpath(String.format(resetTypeLoc, resetType.trim())));
	}

	public void selectUnit(String unit) {
		clickOnElement(By.xpath(String.format(unitLoc, unit.trim())));
	}

	public void selectStatus(String status) {
		clickOnElement(By.xpath(String.format(statusValLoc, status)), 1);
	}

	public void selectMonitoringEndType(String monitoringEndType) {
		clickOnElement(By.xpath(String.format(monitorTypeLoc, monitoringEndType.trim())));
	}

	public void selectMonitoringEndTypeInEdit(String monitoringEndType) {
		clickOnElement(By.xpath(String.format(monitorTypeInEditLoc, monitoringEndType.trim())));
	}

	public void selectStatusInEdit(String status) {
		clickOnElement(By.xpath(String.format(statusValInEditLoc, status.trim())), 1);
	}

	public void sendTextInDescriptionInEdit(String description) {
		sendKeys(txtDescriptionInEdit, description);
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectResetTypeInFilterSearch(String resetType) {
		selectFromDropDown(drpResetTypeInSearch, By.xpath(String.format(drpdwnValLoc, resetType.trim())));
	}

	public void selectDayOftheWeek(String dayOftheWeek) {
		selectFromDropDown(drpDayOftheWeek, By.xpath(String.format(drpdwnValLoc, dayOftheWeek.trim())));
	}

	public void selectDayOftheWeekInEdit(String dayOftheWeek) {
		selectFromDropDown(drpDayOftheWeekInEdit, By.xpath(String.format(drpdwnValLoc, dayOftheWeek.trim())));
	}

	public void selectDayOfMonth(String dayOfMonth) {
		selectFromDropDown(drpDayOfMonth, By.xpath(String.format(drpdwnValLoc, dayOfMonth.trim())));
	}

	public void selectDayOfMonthInEdit(String dayOfMonth) {
		selectFromDropDown(drpDayOfMonthInEdit, By.xpath(String.format(drpdwnValLoc, dayOfMonth.trim())));
	}

	public void selectMonthOfYear(String monthOfYear) {
		selectFromDropDown(drpMonthOfYear, By.xpath(String.format(drpdwnValLoc, monthOfYear.trim())));
	}

	public void selectMonthOfYearInEdit(String monthOfYear) {
		selectFromDropDown(drpMonthOfYearInEdit, By.xpath(String.format(drpdwnValLoc, monthOfYear.trim())));
	}

	public void selectCounterOnInFilterSearch(String resetType) {
		selectFromDropDown(drpCountOnInSearch, By.xpath(String.format(drpdwnValLoc, resetType.trim())));
	}

	public void selectStatusInFilterSearch(String status) {
		selectFromDropDown(drpStatusInSearch, By.xpath(String.format(drpdwnValLoc, status.trim())), 1);
	}

	public void filterSearch(String str1, String str2, String str3, String str4, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			selectFromDropDown(dropDown, dropDownVal2);
		}
		sendTextInNameFilterSearch(str1);
		selectCounterOnInFilterSearch(str2);
		selectStatusInFilterSearch(str3);
		selectResetTypeInFilterSearch(str4);
		common.clickOnFilterSearchBtn();
	}

	public void addCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(13)).toString(), map.get(mapKeys.get(6)).toString(), true);
		if (veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnAddButton();
			sendTextInName(map.get(mapKeys.get(1)).toString());
			sendTextInDescription(map.get(mapKeys.get(2)).toString());
			selectCountOn(map.get(mapKeys.get(3)).toString());
			if (verifyVisible(addCounterVal)) {
				String[] unitlist = map.get(mapKeys.get(4)).toString().trim().split(",");
				clickOnElement(drpUnit);
				for (int i = 0; i < unitlist.length; i++) {
					selectUnit(unitlist[i].trim());
				}
			}
			sendTextInCounterLimit(map.get(mapKeys.get(5)).toString());
			selectResetType(map.get(mapKeys.get(6)).toString());
			if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
				selectDayOftheWeek(map.get(mapKeys.get(7)).toString());
			}
			if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
				selectDayOfMonth(map.get(mapKeys.get(8)).toString());
			}
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				selectMonthOfYear(map.get(mapKeys.get(9)).toString());
			}
			sendTextInInterval(map.get(mapKeys.get(10)).toString());
			selectMonitoringEndType(map.get(mapKeys.get(11)).toString());
			if (verifyVisible(txtOccurence)) {
				sendTextInOccurence(map.get(mapKeys.get(12)).toString());
			}
			selectStatus(map.get(mapKeys.get(13)).toString());
			common.clickOnSaveBtn();
		}
	}

	public void verifyAddedCounter(Map<Object, Object> map, List<Object> mapKeys) {

		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(13)).toString(), map.get(mapKeys.get(6)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(name, map.get(mapKeys.get(1)).toString())), 0);
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(countOn, map.get(mapKeys.get(3)).toString())), 0);
		if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
			String[] unitlist = map.get(mapKeys.get(4)).toString().trim().split(",");
			for (int i = 0; i < unitlist.length; i++) {
				verifyVisible(By.xpath(String.format(verifyUnit, unitlist[i].trim())), 0);
			}
		}
		verifyVisible(By.xpath(String.format(counterLimit, map.get(mapKeys.get(5)).toString())), 0);
		verifyVisible(By.xpath(String.format(resetType, map.get(mapKeys.get(6)).toString())), 0);

		if (!map.get(mapKeys.get(7)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(dayOftheWeek, map.get(mapKeys.get(7)).toString())), 0);
		}
		if (!map.get(mapKeys.get(8)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(dayOfMonth, map.get(mapKeys.get(8)).toString())), 0);
		}
		if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(monthOfYear, map.get(mapKeys.get(9)).toString())), 0);
		}
		verifyVisible(By.xpath(String.format(interval, map.get(mapKeys.get(10)).toString())), 0);
		if (!map.get(mapKeys.get(12)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(occurence, map.get(mapKeys.get(12)).toString())), 0);
		}
		verifyVisible(By.xpath(String.format(occurence, map.get(mapKeys.get(13)).toString())), 1);
	}

	public boolean editCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(3)).toString(),
				map.get(mapKeys.get(15)).toString(), map.get(mapKeys.get(7)).toString(), true);
		if (verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 5)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
			common.clickOnEditBtn();
			sendTextInDescriptionInEdit(map.get(mapKeys.get(2)).toString());
			selectCountOnInEdit(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
				if (verifyVisible(verifyCountValue, 1)) {
					String[] unitlist = map.get(mapKeys.get(5)).toString().trim().split(",");
					clickOnElement(drpUnitInEdit);
					for (int i = 0; i < unitlist.length; i++) {
						if (!verifyVisible(By.xpath(String.format(verifyUnitType, unitlist[i].trim())))) {
							selectUnit(unitlist[i].trim());
						}
					}
				}
			}
			sendTextInCounterLimitInEdit(map.get(mapKeys.get(6)).toString());
			selectResetTypeInEdit(map.get(mapKeys.get(8)).toString());
			if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
				selectDayOftheWeekInEdit(map.get(mapKeys.get(9)).toString());
			}
			if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
				selectDayOfMonth(map.get(mapKeys.get(10)).toString());
			}
			if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
				selectMonthOfYear(map.get(mapKeys.get(11)).toString());
			}
			sendTextInIntervalInEdit(map.get(mapKeys.get(12)).toString());
			selectMonitoringEndTypeInEdit(map.get(mapKeys.get(13)).toString());
			if (verifyVisible(verifyoccurance, 1)) {
				sendTextInOccurenceInEdit(map.get(mapKeys.get(14)).toString());
			}
			selectStatusInEdit(map.get(mapKeys.get(16)).toString());
			common.clickOnSaveBtn();
			return true;
		} else {
			return false;
		}
	}

	public void verifyEditedCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(4)).toString(),
				map.get(mapKeys.get(16)).toString(), map.get(mapKeys.get(8)).toString(), true);
		verifyVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())), 0);
		common.clickOnInfoBtn(map.get(mapKeys.get(1)).toString());
		verifyVisible(By.xpath(String.format(description, map.get(mapKeys.get(2)).toString())), 0);
		verifyVisible(By.xpath(String.format(countOn, map.get(mapKeys.get(4)).toString())), 0);
		if (!map.get(mapKeys.get(5)).toString().trim().equals("")) {
			String[] unitlist = map.get(mapKeys.get(4)).toString().trim().split(",");
			for (int i = 0; i < unitlist.length; i++) {
				verifyVisible(By.xpath(String.format(verifyUnit, unitlist[i])), 0);
			}
		}
		verifyVisible(By.xpath(String.format(counterLimit, map.get(mapKeys.get(6)).toString())), 0);
		verifyVisible(By.xpath(String.format(resetType, map.get(mapKeys.get(8)).toString())), 1);

		if (!map.get(mapKeys.get(9)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(dayOftheWeek, map.get(mapKeys.get(4)).toString())), 0);

		}
		if (!map.get(mapKeys.get(10)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(dayOfMonth, map.get(mapKeys.get(10)).toString())), 0);
		}
		if (!map.get(mapKeys.get(11)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(monthOfYear, map.get(mapKeys.get(11)).toString())), 0);
		}
		verifyVisible(By.xpath(String.format(interval, map.get(mapKeys.get(12)).toString())), 0);
		if (!map.get(mapKeys.get(14)).toString().trim().equals("")) {
			verifyVisible(By.xpath(String.format(occurence, map.get(mapKeys.get(12)).toString())), 0);
		}
		verifyVisible(By.xpath(String.format(status, map.get(mapKeys.get(16)).toString())), 1);
	}

	public boolean deleteCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), map.get(mapKeys.get(4)).toString(), true);
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

	public boolean verifyDeletedCounter(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(1)).toString(), map.get(mapKeys.get(2)).toString(),
				map.get(mapKeys.get(3)).toString(), map.get(mapKeys.get(4)).toString(), true);
		return veifyElementIsNotVisible(By.xpath(String.format(verifyElement, map.get(mapKeys.get(1)).toString())));

	}

	public boolean sortCounter(Map<Object, Object> map, List<Object> mapKeys) {
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
