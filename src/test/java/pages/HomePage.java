package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class HomePage extends SetupInit {

	By platformConfiguration = By.xpath("//*[text()='Platform Config']");
	By homeLogo = By.xpath("//img[@alt='logo']");
	CommonPage common;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}

	public void goToHome() {
		while (getCurrentURL().equals("http://10.10.180.79:7001/#/user/login")) {
			;
		}
		if (verifyVisible(common.btnClose, 2))
			common.clickOnCloseBtn();
		clickOnElement(homeLogo);
	}
}
