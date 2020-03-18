package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class TechnicalConfigurationProcessSchedulerPage extends SetupInit {

	By addBtn = By.id("operationbarbuttonadd");
	By name = By.id("inputProcessSchedulerAddName");
	By description = By.id("inputProcessSchedulerAddDescription");
	String schedulerType = ".//*[normalize-space(text())='%s']";
	String status = ".//*[@id='inputProcessSchedulerAddStatus']//*[normalize-space(text())='%s']";
	By scheduler = By.xpath(".//*[@id='inputProcessSchedulerAddScheduler']//*[@class='ant-select-arrow']");
	By save = By.id("operationbarbuttonsave");
	By backBtn = By.id("operationbarbuttonback");
	By txtNameInSearch = By.name("name");
	By drpStatusInSearch = By.xpath(
			"(//*[normalize-space(text())='Status']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	By process = By.xpath(".//*[@id='inputProcessSchedulerAddProcess']//*[@class='ant-select-arrow']");
	By date = By.id("inputProcessSchedulerAddStartDate");
	String processType = ".//*[@id='inputProcessSchedulerAddProcess']//following::*[normalize-space(text())='%s']";
	String defaultValue = "(.//*[normalize-space(text())='%s']//following::input[@type='text' and contains(@id,'defaultValue')])[1]";
	By editBtn = By.id("operationbarbuttonedit");
	By deleteBtn = By.id("operationbarbuttondelete");
	By descriptionEdit = By.id("inputProcessSchedulerEditDescription");
	String statusEdit = ".//*[@id='inputProcessSchedulerEditStatus']//*[normalize-space(text())='%s']";
	By schedulerEdit = By.xpath(".//*[@id='inputProcessSchedulerEditScheduler']//*[@class='ant-select-arrow']");
	By dateEdit = By.id("inputProcessSchedulerEditStartDate");
	String processTypeEdit = ".//*[@id='inputProcessSchedulerEditProcess']//following::*[normalize-space(text())='%s']";
	By processEdit = By.xpath(".//*[@id='inputProcessSchedulerEditProcess']//*[@class='ant-select-arrow']");
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	String data="(//td[text()='%s'])[1]";
	By okBtn=By.xpath("//*[@class='ant-calendar-ok-btn']");
	String selectDay=".//*[@class='ant-calendar-date' and @aria-selected='true'][normalize-space(text())='%s']";
	String type="//*[contains(@class,'ant-select-selection-selected-value')][normalize-space(text())='%s']";
	String labelName=".//*[normalize-space(text())='%s']";
	String paramValue="(.//*[normalize-space(text())='%s']//following::*[normalize-space(text())='%s'])[1]";
	String schedulerName = ".//*[normalize-space(text())='Name']//following::*[normalize-space(text())='%s']";
	String schedulerDescription = ".//*[normalize-space(text())='Description']//following::*[normalize-space(text())=''%s']";
	String processSchedulerType ="//*[normalize-space(text())='Scheduler']//following::*[normalize-space(text())='%s']";
	String schedulerProcess = ".//*[normalize-space(text())='Process']//following::*[normalize-space(text())='%s']";
	String startDate = ".//*[normalize-space(text())='Start Date']//following::*[contains(normalize-space(text()),'%s')]";
	String schedulerstatus = "//*[normalize-space(text())='Status']//following::*[normalize-space(text())='%s']";
	String element="(//li[normalize-space(text())='%s'])[last()]";
	String label=".//*[normalize-space(text())='%s']";
	String labelValue="(.//*[normalize-space(text())='%s']//following::*[normalize-space(text())='%s'])[1]";
	
	private CommonPage common;

	public TechnicalConfigurationProcessSchedulerPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void addProcessScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (!verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())))) {
			clickOnElement(addBtn);
			waitForLoader();
			sendTextInName(map.get(mapKeys.get(0)).toString());
			sendTextInDescription(map.get(mapKeys.get(1)).toString());
			selectSchedulerType(map.get(mapKeys.get(2)).toString());
			selectProcess(map.get(mapKeys.get(3)).toString());
			sendTextInFromDate();
			selectStatus(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {
				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				for (int i = 0; i < param.length; i++) {
					String name = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyVisible(By.xpath(String.format(label, name)))) {
						String val = String.format(defaultValue, name);
						sendKeys(By.xpath(val), value);
					}
				}
			}
			common.clickOnSaveBtn();
		}
	}

	
	public void sendTextInName(String schedulerName) {
		sendKeys(name, schedulerName);
	}


	public void sendTextInDescription(String schedulerDescription) {
		sendKeys(description, schedulerDescription);
	}


	public void selectSchedulerType(String type) {
		clickOnElement(scheduler);
		String stype = String.format(schedulerType, type);
		clickOnElement(By.xpath(stype));
	}

	
	public void selectStatus(String state) {
		String value = String.format(status, state);
		clickOnElement(By.xpath(value));
	}

	public void selectProcess(String type) {
		clickOnElement(process);
		String stype = String.format(processType, type);
		clickOnElement(By.xpath(stype));
	}

	
	public boolean verifyProcessScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			if (!verifyVisible(By.xpath(String.format(schedulerName, map.get(mapKeys.get(0)).toString())),0)){
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(schedulerDescription, map.get(mapKeys.get(1)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(processSchedulerType, map.get(mapKeys.get(2)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(schedulerProcess, map.get(mapKeys.get(3)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(schedulerstatus, map.get(mapKeys.get(4)).toString())),0)) {
				return false;
			}
			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {
				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				for (int i = 0; i < param.length; i++) {
					String nameID = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyVisible(By.xpath(String.format(label, nameID)))) {
						if (!verifyVisible(By.xpath(String.format(labelValue, nameID,value)))) {
							return false;
						}

					}
				}

			}

			return true;

		} else {
			return false;
		}
	}

	public void filterSearch(String name, String state, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNameFilterSearch(name);
		selectStatusInFilterSearch(state);

		common.clickOnFilterSearchBtn();
	}

	public void sendTextInNameFilterSearch(String name) {
		sendKeys(txtNameInSearch, name);
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(element, status)));
	}

	
	public boolean editProcessScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearch(map.get(mapKeys.get(0)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())),0)) {
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			clickOnElement(editBtn);
			sendTextInDescriptionEdit(map.get(mapKeys.get(1)).toString());
			selectSchedulerTypeEdit(map.get(mapKeys.get(2)).toString());
			selectProcessEdit(map.get(mapKeys.get(3)).toString());
			sendTextInFromDateEdit();
			selectStatusEdit(map.get(mapKeys.get(4)).toString());
			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {
				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				for (int i = 0; i < param.length; i++) {
					String name = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyVisible(By.xpath(String.format(label, name)))) {
						String val = String.format(defaultValue, name);
						sendKeys(By.xpath(val), value);
					}
				}
			}
			common.clickOnSaveBtn();
			return true;
		}
		else
			return false;
	}

	
	public boolean verifyEditProcessScheduler(Map<Object, Object> map, List<Object> mapKeys) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		filterSearch(map.get(mapKeys.get(0)).toString(), map.get(mapKeys.get(4)).toString(), true);
		if (verifyVisible(By.xpath(String.format(data,  map.get(mapKeys.get(0)).toString())))) {
			common.clickOnInfoBtn(map.get(mapKeys.get(0)).toString());
			waitForLoader();
			if (!verifyVisible(By.xpath(String.format(schedulerName, map.get(mapKeys.get(0)).toString())),0)){
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(schedulerDescription, map.get(mapKeys.get(1)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(processSchedulerType, map.get(mapKeys.get(2)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(schedulerProcess, map.get(mapKeys.get(3)).toString())),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(startDate, dateTime)),0)) {
				return false;
			}
			if (!verifyVisible(By.xpath(String.format(schedulerstatus, map.get(mapKeys.get(4)).toString())),0)) {
				return false;
			}
			if (!map.get(mapKeys.get(5)).toString().isEmpty()) {
				String[] param = map.get(mapKeys.get(5)).toString().split(",");
				for (int i = 0; i < param.length; i++) {
					String nameID = param[i].split(":")[0];
					String value = param[i].split(":")[1];
					if (verifyVisible(By.xpath(String.format(labelName, nameID)))) {
						if (!verifyVisible(By.xpath(String.format(paramValue, nameID,value)))) {
							return false;
						}
					}
				}
			}
			return true;

		} else {
			return false;
		}
	}

	
	public boolean deleteProcessScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearchForDelete(map.get(mapKeys.get(0)).toString(), true);
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

	public boolean VerifyDeleteProcessScheduler(Map<Object, Object> map, List<Object> mapKeys) {
		filterSearchForDelete(map.get(mapKeys.get(0)).toString(), true);
		return verifyVisible(By.xpath(String.format(data, map.get(mapKeys.get(0)).toString())),5);

	}

	public void sendTextInFromDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		clickOnElement(date);
		String day = dateTime.split("-")[2];
		if (day.startsWith("0"))
			day = day.replaceFirst("0", "");
		clickOnElement(By.xpath(String.format(selectDay, day.trim())));
		clickOnElement(okBtn);
	}

	
	public void sendTextInDescriptionEdit(String schedulerDescription) {
		sendKeys(descriptionEdit, schedulerDescription);
	}

	
	public void selectSchedulerTypeEdit(String schedulertype) {
		if (!verifyVisible(
				By.xpath(String.format(type, schedulertype)))) {
			clickOnElement(schedulerEdit);
			String stype = String.format(schedulerType, schedulertype);
			clickOnElement(By.xpath(stype));
		}
	}

	
	public void selectStatusEdit(String state) {
		String s = String.format(statusEdit, state);
		clickOnElement(By.xpath(s));
	}

	public void selectProcessEdit(String processType) {
		if (!verifyVisible(
				By.xpath(String.format(type, processType)))) {
			clickOnElement(processEdit);
			String stype = String.format(processTypeEdit, processType);
			clickOnElement(By.xpath(stype));
		}

	}

	public void sendTextInFromDateEdit() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		clickOnElement(dateEdit);
		String day = dateTime.split("-")[2];
		if (day.startsWith("0"))
			day = day.replaceFirst("0", "");
		clickOnElement(By.xpath(String.format(selectDay, day.trim())));
		clickOnElement(okBtn);
	}


	public void filterSearchForDelete(String name, boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInNameFilterSearch(name);
		common.clickOnFilterSearchBtn();
	}
	
}
