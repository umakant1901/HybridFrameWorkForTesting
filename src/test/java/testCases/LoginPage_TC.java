package testCases;

import org.testng.annotations.Test;

import pageObject.LoginPage;

public class LoginPage_TC extends BaseClass{
	
	@Test
	public void loginTest()
	{
		driver.get(url);
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		
		logger.info("this is message");
		logger.warn("this is message");
		lp.setPassword(password);
		logger.warn("this is message");
		lp.clickButton();
		
		
		
	}
	

}
