package demoqa1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PO_BasePage
{
	WebDriver d;
	Actions action;
	
	public PO_BasePage (WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d, this);
		action = new Actions(d);
	}
}
