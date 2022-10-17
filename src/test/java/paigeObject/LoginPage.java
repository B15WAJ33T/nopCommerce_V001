package paigeObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="Email")
	@CacheLookup
	WebElement emailid;
	

	@FindBy(id ="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement loginbtn;
	

	@FindBy(xpath ="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutbtn;
	
	public void setEmail(String uemail)
	{
		emailid.clear();
		emailid.sendKeys(uemail);
	}
	
	public void setPassword(String upassword)
	{
		password.clear();
		password.sendKeys(upassword);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	public void clickLogout()
	{
		logoutbtn.click();
	}

}
