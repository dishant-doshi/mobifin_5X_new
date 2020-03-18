package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.SetupInit;

public class UserManagementResetPasswordPage extends SetupInit {

	By btnResetpassword = By.xpath("//*[normalize-space(text())='Reset Password']//preceding::button[@type='submit']");
	//	By btnSearch=By.xpath("//*[normalize-space(text())='Search']/..");
	By btnSearch = By.xpath("//button[contains(@class,'input-search')]");
	By userName=By.id("username");
	List<String> list = new ArrayList<String>();
	By stripText = By.xpath("(//*[@class='ant-notification-notice-message'])[last()]");
	String dataLabel=".//label[normalize-space(text())='%s']";
	String element=".//label[normalize-space(text())='%s']//following::*[normalize-space(text())='%s']";
	
	private CommonPage common;

	public UserManagementResetPasswordPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonPage(this.driver);
	}
	
	public void clickOnResetButton()
	{
		clickOnElement(btnResetpassword);
	}
	
	public void resetPassword(Map<Object, Object> map,List<Object> mapKeys)
	{
		sendKeys(userName, map.get(mapKeys.get(0)).toString(),0);
		clickOnElement(btnSearch);
		String[] navigateList = map.get(mapKeys.get(1)).toString().trim()
				.split("/");
		for (int i = 0; i < navigateList.length; i++)
		{
			if(!map.get(mapKeys.get(2)).toString().isEmpty())
			{
				String[] CategoryField = map.get(mapKeys.get(2)).toString()
						.split("/");
				String [] data=CategoryField[i].split(",");
				for(int k=0;k<data.length;k++)
				{
						String label=data[k].split(":")[0];
						if(verifyVisible(By.xpath(String.format(dataLabel, label.trim()))) &&  (!list.contains(label.trim())))
						{
							String value=data[k].split(":")[1];
							if(verifyVisible(By.xpath(String.format(dataLabel, label.trim(),value.trim()))))
							{
								clickOnResetButton();
								list.add(label.trim());
							}
						}
				}
			}
		}
	}
	
	public boolean verifyResetPassword()
	{
		if (verifyVisible(stripText,0)) {
			String msg=common.getUIText(stripText).trim();
			 if(msg.trim().equals("Reset Password Successfully"))
			 {
				 return true;
			 }
		}
		return false;
	}
	
	
	
}
