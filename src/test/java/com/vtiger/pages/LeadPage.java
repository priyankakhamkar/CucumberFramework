package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage{

	public LeadPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		
	}
	
	@FindBy(name="lastname")
	WebElement txt_lname;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement txt_cname;
	
	@FindBy(xpath="//input[@name='button']")
	WebElement btn_save;
	
	
	
	
	
	
	public void createLeadWithMandatoryFields(String lname,String company )
	{
		
		setInput(txt_lname,lname,lname+ "has been entered into last name field ");
		setInput(txt_cname,company,company+ "has been entered into company field ");
		clickElement(btn_save,"save button clicked");
	}
	
	
}
