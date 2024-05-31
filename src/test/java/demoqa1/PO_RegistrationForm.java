package demoqa1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_RegistrationForm extends PO_BasePage
{
	public WebDriver d;
	
	public PO_RegistrationForm (WebDriver d)
	{
		super(d);
	}
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement FirstNameEdit;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement LastNameEdit;
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement UserEmailEdit;
	
	@FindBy(xpath="//label[normalize-space()='Male']")
	WebElement MaleRadioBtn;
	
	@FindBy(xpath="//label[normalize-space()='Female']")
	WebElement FemaleRadioBtn;
	
	@FindBy(xpath="//label[normalize-space()='Other']")
	WebElement OtherBtn;
	
	@FindBy(xpath="//input[@id='userNumber']")
	WebElement MobileNoEdit;
	
	@FindBy(xpath="//div[@id='subjectsContainer']")
	WebElement SubjectsEdit;
	
	@FindBy(xpath="//label[normalize-space()='Sports']")
	WebElement SportsChkBox;
	
	@FindBy(xpath="//label[normalize-space()='Reading']")
	WebElement ReadingChkBox;
	
	@FindBy(xpath="//label[normalize-space()='Music']")
	WebElement MusicChkBox;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	WebElement CurrentAddressEdit;
	
	@FindBy(xpath="//div[contains(text(),'Select State')]")
	WebElement StateDropDown;
	
	@FindBy(xpath="//div[contains(text(),'Select City')]")
	WebElement CityDropDown;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//div[@id='example-modal-sizes-title-lg']")
	WebElement SubmitInformation;
	
	@FindBy(xpath="//button[@id='closeLargeModal']")
	WebElement CloseButton;
	
	@FindBy(xpath="//div[@id='fixedban']")
	WebElement BottomPageBar;
	
	public void SetFirstName(String param)
	{
		FirstNameEdit.sendKeys(param);
	}
	
	public void SetLastName(String param)
	{
		LastNameEdit.sendKeys(param);
	}
	
	public void SetEmail(String param)
	{
		UserEmailEdit.sendKeys(param);
	}
	
	public void SelectGender(String param)
	{
		if (param.toUpperCase().equals("MALE"))
		{
			MaleRadioBtn.click();
		}
		else if (param.toUpperCase().equals("FEMALE"))
		{
			FemaleRadioBtn.click();
		}
		else if (param.toUpperCase().equals("OTHER"))
		{
			OtherBtn.click();
		}
	}
	
	public void SetMobileNumber(String param)
	{
		MobileNoEdit.sendKeys(param);
	}
	
	public void SetSubjects(String param)
	{
		action.moveToElement(SubjectsEdit).click().sendKeys(param).sendKeys(Keys.TAB).build().perform();
	}
	
	public void SelectHobbies(String param)
	{
		if (param.toUpperCase().equals("SPORTS"))
		{
			SportsChkBox.click();
		}
		else if (param.toUpperCase().equals("READING"))
		{
			ReadingChkBox.click();
		}
		else if (param.toUpperCase().equals("MUSIC"))
		{
			MusicChkBox.click();
		}
	}
	
	public void SetCurrentAddress(String param)
	{
		CurrentAddressEdit.sendKeys(param);
		//action.moveToElement(CurrentAddressEdit).click().sendKeys(Keys.TAB);
	}
	
	public void SelectState (String param)
	{
		//action.moveToElement(StateDropDown).click().sendKeys(param).sendKeys(Keys.TAB).build().perform();
		action.sendKeys(param).sendKeys(Keys.TAB).sendKeys(Keys.TAB);
	}
	
	public void SelectCity (String param)
	{
		//action.moveToElement(CityDropDown).click().sendKeys(param).sendKeys(Keys.TAB).build().perform();
		action.sendKeys(param).sendKeys(Keys.TAB);
	}
	
	public void ScrollToElement (String param)
	{
		if (param.toUpperCase().equals("SUBMITBUTTON"))
		{
			action.scrollToElement(SubmitBtn).build().perform();
		}
		else if (param.toUpperCase().equals("BOTTOMPAGE"))
		{
			action.moveToElement(CurrentAddressEdit).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB);
		}
	}
	
	public void ClickSubmit ()
	{
		SubmitBtn.submit();
	}
	
	public String GetConfirmationMessage()
	{
		try
		{
			String confmsg = SubmitInformation.getText();
			CloseButton.click();
			return(confmsg);
		}
		catch (Exception e)
		{
			return("Submit Failed");
		}
	}
}
