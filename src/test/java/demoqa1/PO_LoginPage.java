package demoqa1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_LoginPage extends PO_BasePage
{
	public PO_LoginPage (WebDriver d)
	{
		super(d);
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement UserNameEdit;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement PasswordEdit;
	
	@FindBy(xpath="//i[@class='fa fa-2x fa-sign-in']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//i[@class='icon-2x icon-signout']")
	WebElement LogoutBtn;
	
	@FindBy(xpath="//div[@id='flash']")
	WebElement LoginSuccessMsg;
	
	public void SetUserName(String param)
	{
		UserNameEdit.sendKeys(param);
	}
	
	public void SetPassword(String param)
	{
		PasswordEdit.sendKeys(param);
	}
	
	public void ClickLoginButton()
	{
		LoginBtn.click();
	}
	
	public String GetLoginSuccessMessage()
	{
		try
		{
			String confmsg = LoginSuccessMsg.getText();
			LogoutBtn.click();
			return(confmsg);
		}
		catch (Exception e)
		{
			return("Login Failed");
		}
	}
}
