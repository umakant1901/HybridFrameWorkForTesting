package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	WebDriver lDriver;
	
	public NewCustomer(WebDriver rdriver)
	{
		lDriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerTab;
	
	@FindBy(xpath = "")
	WebElement newusername;
	
	@FindBy(xpath = "")
	WebElement gender;
	
	@FindBy(xpath = "")
	WebElement dob;
	
	@FindBy(xpath = "")
	WebElement address;
	
	@FindBy(xpath = "")
	WebElement city;
	
	@FindBy(xpath = "")
	WebElement state;
	
	@FindBy(xpath = "")
	WebElement pin;
	
	@FindBy(xpath = "")
	WebElement mobile;
	
	@FindBy(xpath = "")
	WebElement email;
	
	@FindBy(xpath = "")
	WebElement password;
	
	@FindBy(xpath = "")
	WebElement submitbtn;
	
	@FindBy(xpath = "")
	WebElement resetbtn;
	
	@FindBy(xpath = "")
	WebElement backtohomebtn;
	
	public void setNewUserName(String uname)
	{
		newusername.sendKeys(uname);
	}
	
	
	public void setGender()
	{
		gender.click();
	}
	
	public void setDoB()
	{
		dob.click();
	}
	
	public void setAddress(String addaddress)
	{
		address.sendKeys(addaddress);
	}
	
	public void setCity(String cityname)
	{
		newusername.sendKeys(cityname);
	}
	
	public void setState(String statename)
	{
		newusername.sendKeys(statename);
	}
	
	public void setPin(String pinnumber)
	{
		newusername.sendKeys(pinnumber);
	}
	
	public void setMobile(String mobilenumber)
	{
		newusername.sendKeys(mobilenumber);
	}
	
	public void setEmail(String emailid)
	{
		newusername.sendKeys(emailid);
	}
	
	public void setPassword(String setpassword)
	{
		newusername.sendKeys(setpassword);
	}
	
	public void clickSubmit()
	{
		submitbtn.click();
	}
	
	public void clickReset()
	{
		resetbtn.click();
	}
	
	public void clickHome()
	{
		backtohomebtn.click();
	}
	
}
