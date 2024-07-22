package com.vtiger.pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class PageObjectManager {
	public  LoginPage lp;
	public  HomePage hp;
	public  LeadPage ldp;
	public WebDriver driver;
	public ExtentTest logger;
	
	public PageObjectManager(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}
	
	public LoginPage getLoginPage() {
		
		if(lp==null) {
			
			lp=new LoginPage(driver,logger);
			return lp;
		}
		
		else
		{
			return lp;
		}
	}
public HomePage getHomePage() {
		
		if(hp==null) {
			
			hp=new HomePage(driver,logger);
			return hp;
		}
		
		else
		{
			return hp;
		}
	}


public LeadPage getLeadPage() {
	
	if(ldp==null) {
		
		ldp=new LeadPage(driver,logger);
		return ldp;
	}
	
	else
	{
		return ldp;
	}
}
}
