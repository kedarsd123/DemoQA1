package demoqa1;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_001_AccountRegistrationTest
{
	public WebDriver d;
	
	@Test
	public void Verify_Account_Registration() throws Exception
	{
		PO_RegistrationForm RegForm = new PO_RegistrationForm(d);
		RegForm.SetFirstName(RandomString().toUpperCase());
		RegForm.SetLastName(RandomString().toUpperCase());
		RegForm.SetEmail(RandomString()+"@gmail.com");
		RegForm.SelectGender("Male");
		RegForm.SetMobileNumber(RandomNumber()+""+RandomNumber());
		RegForm.ScrollToElement("SubmitButton");
		Thread.sleep(3000);
		RegForm.SetSubjects("English");
		RegForm.SelectHobbies("Music");
		RegForm.SetCurrentAddress("Optics Building, F-310, Plot No 10, Sector 5, FruitCity");
		RegForm.ScrollToElement("SubmitButton");
		Thread.sleep(2000);
		RegForm.SelectState("Uttar Pradesh");
		Thread.sleep(2000);
		RegForm.SelectCity("Lucknow");
		RegForm.ClickSubmit();
		String confmsg = RegForm.GetConfirmationMessage();
		Assert.assertEquals(confmsg, "Thanks for submitting the form");
	}
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void SetUp(@Optional String os, @Optional String br)
	{
		
		if (br == null)
		{
			br = "chrome";
		}
		
		if (br.toUpperCase().equals("CHROME"))
		{
			d = new ChromeDriver();
		}
		else if (br.toUpperCase().equals("EDGE"))
		{
			d = new EdgeDriver();
		}
		else
		{
			System.out.println("Browser Not Matching");
			return;
		}
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.get("https://demoqa.com/automation-practice-form");
		d.manage().window().maximize();
	}
	
	@AfterClass
	public void TearDown()
	{
		d.close();
	}
	
	public String RandomString ()
	{
		String GeneratedString = RandomStringUtils.randomAlphabetic(5);
		return(GeneratedString);
	}
	
	public String RandomNumber ()
	{
		String GeneratedString = RandomStringUtils.randomNumeric(5);
		return(GeneratedString);
	}
	
	public String RandomAlphaNumeric ()
	{
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(5);
		return(str+num);
	}
}
