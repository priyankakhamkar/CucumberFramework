package com.vtiger.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;

public class LoginPage extends PageActions {
	
	
	
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver=driver;
		//both statements are same
		//PageFactory.initElements(driver, LoginPage.class); 
		PageFactory.initElements(driver, this); 
		
		}
	
	@FindBy(name="user_name")
	WebElement uid;
	
	@FindBy(xpath="//input[@name='user_password']")
	WebElement pass;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="[//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	@FindBy(xpath="//*[contains(text(),'123You must specify a valid username and password.')]")
	WebElement err_msg;
	
	@FindBy(linkText="http://www.vtiger.com/products/crm/customer-support.html")
	WebElement lnk_customer;
	
	@FindBy(name="login_theme")
	WebElement dp_theme;
	
	/*
	private String uid="user_name";
	private String pass="user_password";
	
	*/
	
	/*
	By UserId=By.name("user_name");
	By password=By.name("user_password");
	*/
	
	
	
public void  login(String userid,String pwd) 
{
	
	setInput(uid,userid,userid+ "has been entered into username field");
	setInput(pass,pwd ,pwd+ "has been entered into password field");
	clickElement(login,"Login button clicked");
	
}

 public void checkUsernameExist() {
	 
	 ElementExist(uid,"Textbox username displayed on login page");
 }
 
public void verifyLogo() {
	 
	 ElementExist(logo,"Logo displayed on login page");
 }

public void verifyErrorMsg() {
	 
	 ElementExist(err_msg,"Error message validated successfully");
}




public void checkThemeDropDownExist()
{
	
	ElementExist(dp_theme,"Theme Dropdown exist on login page");
}

public void verifyDefaultThemeValue(String theme) {
	
	Select sel=new Select(dp_theme);
	WebElement elm=sel.getFirstSelectedOption();
	Assert.assertEquals(elm.getText(), theme);
	
	}


public void verifyAllOptionValues(String options) {
	int cnt=0;
	StringBuilder sb=new StringBuilder();
	Select sel=new Select(dp_theme);
	List <WebElement>elms =sel.getOptions();
	
	for(WebElement e:elms)
	{
		String s=e.getText();
		if(cnt==0)
		{
			sb.append(s);
			cnt++;
		}
		else {
			sb.append(","+s);
		}
		
	}
	
	
	Assert.assertEquals(sb.toString(),options);
	
	
	
	
	}






}
