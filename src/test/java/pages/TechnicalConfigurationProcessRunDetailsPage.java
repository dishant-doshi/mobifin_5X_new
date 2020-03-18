package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;


public class TechnicalConfigurationProcessRunDetailsPage extends SetupInit {

	By table = By.xpath(".//*[@class='ant-table-body']");
	By filterDownArrow = By.xpath("//*[@class='filter-group-first ant-select ant-select-enabled']");
	By filterBy = By.xpath("//li[normalize-space(text())='Equals']");
	By drpStatusInSearch = By.xpath(
			"(//*[normalize-space(text())='Status']//following::*[@class='filter-group-second ant-select ant-select-enabled']//*[@class='ant-select-arrow'])[1]");
	String selectStatus="(//li[normalize-space(text())='%s'])[last()]";
	By remarks = By.xpath(".//*[@name='remarks']");
	
	
	private CommonPage common;

	public TechnicalConfigurationProcessRunDetailsPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public boolean verifyProcessRunDetails() {

		return verifyVisible(table,0);
	}

	public void filterSearch(String remarksName, String state,
			boolean isSubString) {
		common.commonFilterSearch();
		if (isSubString) {
			clickOnElement(filterDownArrow);
			clickOnElement(filterBy);
		}
		sendTextInRemarksInFilterSearch(remarksName);
		selectStatusInFilterSearch(state);
		common.clickOnFilterSearchBtn();
	}

	public void selectStatusInFilterSearch(String status) {
		clickOnElement(drpStatusInSearch);
		clickOnElement(By.xpath(String.format(selectStatus, status)),1);
	}

	public void sendTextInRemarksInFilterSearch(String remarksName) {
		sendKeys(remarks, remarksName);
	}
	
	
	
	
}
