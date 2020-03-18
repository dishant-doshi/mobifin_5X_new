package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class LoginPage extends SetupInit {
	
	By unmTextBox = By.id("inputLoginUsername");
	By pwdTextBox = By.id("inputLoginPd");
	By loginBtn = By.id("btnLoginLogin");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String userNameVal, String passwordVal) {
		sendKeys(unmTextBox, userNameVal);
		sendKeys(pwdTextBox, passwordVal);
		clickOnElement(loginBtn, 0);
	}
}
