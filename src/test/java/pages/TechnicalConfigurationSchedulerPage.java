package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class TechnicalConfigurationSchedulerPage extends SetupInit {

	By addBtn = By.id("operationbarbuttonadd");
	By name = By.id("inputSchedulerName");
	By description = By.id("inputSchedulerDiscription");
	String schedulerType = ".//*[@id='inputSchedulerAddSchedulerType']//*[normalize-space(text())='%s']";
	String schedulerEndType = ".//*[@id='inputSchedulerAddSchedulerEndType']//*[normalize-space(text())='%s']";
	By daysOfWeek = By.xpath(
			".//*[@id='inputSchedulerAddWeekdays']//*[@class='ant-select-arrow']");
	By daysOfMonth = By.xpath(
			".//*[@id='inputSchedulerAddMonthofdays']//*[@class='ant-select-arrow']");
	By daysOfYear = By.xpath(
			".//*[@id='inputSchedulerAdddaysofmonth']//*[@class='ant-select-arrow']");
	String selectDays = ".//*[normalize-space(text())='%s']";
	By executionInterval = By.id("inputSchedulerAddInterval");
	String status = ".//*[@id='inputSchedulerAddStatus']//*[normalize-space(text())='%s']";
	String scheduler = "//*[@class='ant-table-tbody']//*[normalize-space(text())='%s']";
	By save = By.id("operationbarbuttonsave");
	By backBtn = By.id("operationbarbuttonback");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"(//*[normalize-space(text())='Status']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	By drpSchedulerInSearch = By.xpath(
			"(//*[normalize-space(text())='Scheduler Type']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	By occurrence = By.id("inputSchedulerAddOccurence");
	By endDate = By.id("inputSchedulerAddEndDate");
	By editBtn = By.id("operationbarbuttonedit");
	By descriptionEdit = By.id("inputSchedulereditDescription");
	String schedulerTypeEdit = ".//*[@id='inputSchedulereditSchedulerType']//*[normalize-space(text())='%s']";
	By executionIntervalEdit = By.id("inputSchedulereditInterval");
	String schedulerEndTypeEdit = ".//*[@id='inputSchedulereditSchedulerEndType']//*[normalize-space(text())='%s']";
	String statusEdit = ".//*[@id='inputSchedulereditStatus']//*[normalize-space(text())='%s']";
	By daysOfWeekEdit = By.xpath(
			".//*[@id='inputSchedulereditWeekdays']//*[@class='ant-select-arrow']");
	By daysOfMonthEdit = By.xpath(
			".//*[@id='inputSchedulereditMonthofdays']//*[@class='ant-select-arrow']");
	By daysOfYearEdit = By.xpath(
			".//*[@id='inputSchedulereditdaysofmonth']//*[@class='ant-select-arrow']");
	By occurrenceEdit = By.id("inputSchedulereditOccurence");
	By deleteBtn = By.id("operationbarbuttondelete");
	String scehdulerName = 
			"//*[@id='lblSchedulerViewName'][normalize-space(text())='%s']";
	String scehdulerDescription =
			"//*[@id='lblSchedulerDescription'][normalize-space(text())='%s']";
	String scehdulerType =
			"//*[normalize-space(text())='Scheduler Type']//following::*[normalize-space(text())='%s']";
	String scehdulerInterval = 
			"//*[normalize-space(text())='Execution Interval']//following::*[normalize-space(text())='%s']";
	String scehdulerEndType = 
			"//*[@id='lblSchedularEndType'][normalize-space(text())='%s']";
	String scehdulerStatus = 
			"//*[@id='lblSchedulerViewStatus']//following::*[normalize-space(text())='%s']";
	String dayofWeek = "//*[@id='lblSchedulerDayofWeek'][contains(text(),'%s')]";
	String dayOfMonth ="//*[@id='lblSchedulerDay'][normalize-space(text())='%s']";
	String monthoOfYear =
			"//*[@id='lblSchedulerMonthofYear'][normalize-space(text())='%s']";
	String scehdulerOccurrence = 
			"//*[normalize-space(text())='Occurence']//following::*[normalize-space(text())='%s']";
	String data="(//td[text()='%s'])[1]";
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	By txtCalender=By.xpath("//*[@class='ant-calendar-input ']");
	By okBtn=By.xpath("//*[@class='ant-calendar-ok-btn']");
	String selectDay=".//*[@class='ant-calendar-date' and @aria-selected='true'][normalize-space(text())='%s']";
	String element="(//li[normalize-space(text())='%s'])[last()]";
	
	private CommonPage common;

	public TechnicalConfigurationSchedulerPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void addScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(6)).toString(),
				map.get(mapKeys.get(2)).toString(), true);
		if (!verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())))) {
			clickOnElement(addBtn);
			sendTextInName(map.get(mapKeys.get(0)).toString());
			sendTextInDescription(map.get(mapKeys.get(1)).toString());
			selectSchedulerType(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(2)).toString().trim().equals("Weekly")) {
				selectValueFromDaysOfWeek(map.get(mapKeys.get(3)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Monthly")) {
				selectValueFromDaysOfMonth(map.get(mapKeys.get(10)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Yearly")) {
				selectValueFromDaysOfYear(map.get(mapKeys.get(9)).toString());
			}
			sendTextInExecutionInterval(map.get(mapKeys.get(4)).toString());
			selectSchedulerEndType(map.get(mapKeys.get(5)).toString());
			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				sendTextInOccurrenceField(map.get(mapKeys.get(7)).toString());
			} else if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Date")) {
				sendTextInFromDate();
			}
			selectStatus(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
		}
	}

	
	public void sendTextInName(String schedulerName) {
		sendKeys(name, schedulerName,0);
	}

	
	public void sendTextInDescription(String schedulerDescription) {
		sendKeys(description, schedulerDescription);
	}

	
	public void selectSchedulerType(String type) {
		String stype = String.format(schedulerType, type);
		clickOnElement(By.xpath(stype));
	}

	
	public void selectValueFromDaysOfWeek(String days) {
		clickOnElement(daysOfWeek);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	
	public void sendTextInExecutionInterval(String time) {
		sendKeys(executionInterval, time);
	}

	
	public void selectStatus(String state) {
		String s = String.format(status, state);
		clickOnElement(By.xpath(s));
	}

	
	public void selectSchedulerEndType(String type) {
		String stype = String.format(schedulerEndType, type);
		clickOnElement(By.xpath(stype));
	}

	
	public void selectValueFromDaysOfMonth(String days) {
		clickOnElement(daysOfMonth);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	
	public void selectValueFromDaysOfYear(String days) {
		clickOnElement(daysOfYear);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	
	public boolean verifyScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {

		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(6)).toString(),
				map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())),0)) {
			waitForLoader();
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			waitForLoader();
			if (!verifyVisible(By.xpath(String.format(scehdulerName, map.get(mapKeys.get(0)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(scehdulerDescription, map.get(mapKeys.get(1)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(scehdulerType, map.get(mapKeys.get(2)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(scehdulerInterval, map.get(mapKeys.get(4)).toString())),0)) {
				return false;
			}
			 if (!verifyVisible(By.xpath(String.format(scehdulerEndType, map.get(mapKeys.get(5)).toString())),0)) {
			 return false;
			 }

			if (!verifyVisible(By.xpath(String.format(scehdulerStatus, map.get(mapKeys.get(6)).toString())),1)) {
				return false;
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Weekly")) {
				if (!verifyVisible(By.xpath(String.format(dayofWeek, map.get(mapKeys.get(3)).toString())),0)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Monthly")) {
				if (!verifyVisible(By.xpath(String.format(dayOfMonth, map.get(mapKeys.get(9)).toString())),0)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Yearly")) {
				if (!verifyVisible(By.xpath(String.format(monthoOfYear, map.get(mapKeys.get(10)).toString())),0)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				if (!verifyVisible(By.xpath(String.format(scehdulerOccurrence, map.get(mapKeys.get(7)).toString())),0)) {
					return false;
				}
			}
			return true;

		} else {
			return false;
		}

	}

	public void filterSearch(String name, String state, String type,
			boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNameFilterSearch(name);
		selectStatusInFilterSearch(state);
		selectSchedulerInFilterSearch(type);
		common.clickOnFilterSearchBtn();
	}


	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	
	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(element, status.trim())),1);
	}

	
	public void selectSchedulerInFilterSearch(String type) {
		clickOnElement(drpSchedulerInSearch);
		clickOnElement(By.xpath(String.format(element, type.trim())));
	}

	
	public void sendTextInOccurrenceField(String occur) {
		sendKeys(occurrence, occur);
	}

	
	public void sendTextInFromDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		clickOnElement(endDate);
		String day = dateTime.split("-")[2];
		if (day.startsWith("0"))
			day = day.replaceFirst("0", "");
		clickOnElement(By.xpath(String.format(selectDay, day.trim())));
		clickOnElement(okBtn);
	}

	
	public void sendTextInToDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, +30);
		Date currentDatePlusOne = c.getTime();
		String fromDate = dateFormat.format(currentDatePlusOne);
		clickOnElement(endDate);
		sendKeys(txtCalender,
				fromDate);
		clickOnElement(okBtn);
	}

	
	public boolean editScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearchForEdit(map.get(mapKeys.get(0)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			clickOnElement(editBtn);
			waitForLoader();
			sendTextInDescriptionEdit(map.get(mapKeys.get(1)).toString());
			selectSchedulerTypeEdit(map.get(mapKeys.get(2)).toString());
			if (map.get(mapKeys.get(2)).toString().trim().equals("Weekly")) {
				selectValueFromDaysOfWeekEdit(
						map.get(mapKeys.get(3)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Monthly")) {
				selectValueFromDaysOfMonthEdit(
						map.get(mapKeys.get(10)).toString());
			} else if (map.get(mapKeys.get(2)).toString().trim()
					.equals("Yearly")) {
				selectValueFromDaysOfYearEdit(
						map.get(mapKeys.get(9)).toString());
			}
			sendTextInExecutionIntervalEdit(map.get(mapKeys.get(4)).toString());
			selectSchedulerEndTypeEdit(map.get(mapKeys.get(5)).toString());
			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				sendTextInOccurrenceFieldEdit(
						map.get(mapKeys.get(7)).toString());
			} else if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Date")) {
				sendTextInFromDate();
			}
			selectStatusEdit(map.get(mapKeys.get(6)).toString());
			common.clickOnSaveBtn();
			return true;
		}else
			 return false;

	}

	public boolean verifyEditedScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(),
				map.get(mapKeys.get(6)).toString(),
				map.get(mapKeys.get(2)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())),0)) {
			
//			waitForLoader();
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			waitForLoader();
			if (!verifyVisible(By.xpath(String.format(scehdulerName, map.get(mapKeys.get(0)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(scehdulerDescription, map.get(mapKeys.get(1)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(scehdulerType, map.get(mapKeys.get(2)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(scehdulerInterval, map.get(mapKeys.get(4)).toString())),0)) {
				return false;
			}
			 if (!verifyVisible(By.xpath(String.format(scehdulerEndType, map.get(mapKeys.get(5)).toString())),0)) {
			 return false;
			 }
			if (!verifyVisible(By.xpath(String.format(scehdulerStatus, map.get(mapKeys.get(6)).toString())),1)) {
				return false;
			}
			if (map.get(mapKeys.get(4)).toString().trim().equals("Weekly")) {
				if (!verifyVisible(By.xpath(String.format(dayofWeek, map.get(mapKeys.get(3)).toString())),0)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Monthly")) {
				if (!verifyVisible(By.xpath(String.format(dayOfMonth, map.get(mapKeys.get(9)).toString())),0)) {
					return false;
				}
			}

			if (map.get(mapKeys.get(4)).toString().trim().equals("Yearly")) {
				if (!verifyVisible(By.xpath(String.format(monthoOfYear, map.get(mapKeys.get(10)).toString())),0)) {
					return false;
				}
			}
			if (map.get(mapKeys.get(5)).toString().trim()
					.equals("End After Occurrence")) {
				if (!verifyVisible(By.xpath(String.format(scehdulerOccurrence, map.get(mapKeys.get(7)).toString())),0)) {
					return false;
				}
			}

			return true;

		} else {
			return false;
		}

	}

	public void filterSearchForEdit(String name, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNameFilterSearch(name);
		common.clickOnFilterSearchBtn();
	}

	
	public void sendTextInDescriptionEdit(String schedulerDescription) {
		sendKeys(descriptionEdit, schedulerDescription);
	}

	
	public void selectSchedulerTypeEdit(String type) {
		String stype = String.format(schedulerTypeEdit, type);
		clickOnElement(By.xpath(stype));
	}

	
	public void selectValueFromDaysOfWeekEdit(String days) {

		clickOnElement(daysOfWeekEdit);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}


	public void sendTextInExecutionIntervalEdit(String time) {
		sendKeys(executionIntervalEdit, time);
	}


	public void selectStatusEdit(String state) {
		String s = String.format(statusEdit, state);
		clickOnElement(By.xpath(s),1);
	}

	
	public void selectSchedulerEndTypeEdit(String type) {
		String stype = String.format(schedulerEndTypeEdit, type);
		clickOnElement(By.xpath(stype));
	}

	
	public void selectValueFromDaysOfMonthEdit(String days) {

		clickOnElement(daysOfMonthEdit);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	
	public void selectValueFromDaysOfYearEdit(String days) {

		clickOnElement(daysOfYearEdit);
		String day = String.format(selectDays, days);
		clickOnElement(By.xpath(day));
	}

	
	public void sendTextInOccurrenceFieldEdit(String occur) {
		sendKeys(occurrenceEdit, occur);
	}

	
	public boolean deleteScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearchForEdit(map.get(mapKeys.get(0)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			common.delete();
			return true;
		} else {
			String string = "ReportTool already deleted";
			log("</br><b style='color:#02563d'>" + string + "</b>");
			return false;
		}
	}

	
	public boolean verifyDeleteScheduler(Map<Object, Object> map,
			List<Object> mapKeys) {
		filterSearchForEdit(map.get(mapKeys.get(0)).toString(), true);
		return verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())),5);
	}
	
	
}
