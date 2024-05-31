package demoqa1;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Driver
{
	
  @Test
  @Parameters({"os","browser"})
  public void RunAllTestCases (@Optional String os, @Optional String br) throws Exception
  {
	  TC_001_AccountRegistrationTest driver1 = new TC_001_AccountRegistrationTest ();
	  TC_002_LoginTest driver2 = new TC_002_LoginTest ();
	  
	  if (br == null)
	  {
		  br = "chrome";
	  }
	  
	  driver1.SetUp(os, br);
	  driver1.Verify_Account_Registration();
	  driver1.TearDown();
	  driver2.SetUp(os, br);
	  driver2.Verify_Login();
	  driver2.TearDown();
	  
	  /*ZTrial1 z = new ZTrial1 ();
	  
	  z.beforeClass();
	  z.f();
	  z.afterClass();*/
  }
}
