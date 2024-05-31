package demoqa1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_002_LoginTest
{
	public WebDriver d;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void SetUp(String os, String br)
	{
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
		d.get("https://the-internet.herokuapp.com/login");
		d.manage().window().maximize();
	}
	
	@AfterClass
	public void TearDown()
	{
		d.close();
	}
	
	@Test
	public void Verify_Login()
	{
		PO_LoginPage LoginPage = new PO_LoginPage(d);
		LoginPage.SetUserName("tomsmith");
		LoginPage.SetPassword("SuperSecretPassword!");
		LoginPage.ClickLoginButton();
		String confmsg = LoginPage.GetLoginSuccessMessage();
		Assert.assertEquals(confmsg.contains("You logged into a secure area"),true);
	}
	

}
