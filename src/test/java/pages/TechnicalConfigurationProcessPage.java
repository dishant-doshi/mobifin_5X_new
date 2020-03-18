package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;


public class TechnicalConfigurationProcessPage extends SetupInit {

	By table = By.xpath(".//*[@class='ant-table-body']");
	
	private CommonPage common;

	public TechnicalConfigurationProcessPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public boolean verifyProcessTable() {
		waitForLoader();
		return verifyVisible(table,0);
	}
	
	
}
