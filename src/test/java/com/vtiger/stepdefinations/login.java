package com.vtiger.stepdefinations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login  extends BaseClassForDriver {
	
@Before
public void getScenario(Scenario scen) {
	
	if(extent==null) {
	createExtentReport();
	}
	 TCName=scen.getName();
	 logger=extent.createTest( TCName);
	 
}


@After
public void saveReport(Scenario scenario) {
	//flush() function saves the reports
	extent.flush();if (scenario.isFailed()) {
        // Take screenshot and embed in report
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	driver.quit();
	
}
@Given("User should be on login page")
public void user_should_be_on_login_page() throws IOException, FilloException {
	launchApp();
	pm=new PageObjectManager(driver,logger);
	
    
}

@When("user enters valid credentials and click on login button")
public void user_enters_valid_credentials_and_click_on_login_button() {
	
	
	  pm.getLoginPage().login(dt.get(TCName).get("userid"), dt.get(TCName).get("password"));
    
}

@Then("user should be navigated to home page")
public void user_should_be_navigated_to_home_page() 
{
	
	driver.findElement(By.linkText("Home")).isDisplayed();
    
}

@Then("user can validate login link")
public void user_can_validate_login_link()
   {
	
	hp.verifyLogout();
	
	}

@When("user enters Invalid credentials and click on login button")
public void user_enters_invalid_credentials_and_click_on_login_button()
{
	
	pm.getLoginPage().login(dt.get(TCName).get("userid"),dt.get(TCName).get("password"));
    
}

@Then("user should be navigated to login page")
public void user_should_be_navigated_to_login_page() 
{
	
	pm.getLoginPage().checkUsernameExist();
    
}

@Then("user can validate error message")
public void user_can_validate_error_message()
{
	pm.getLoginPage().verifyErrorMsg();
		
}


@When("user enters Invalid credentials userid as \"admin1\"and password as {string} click on login button")
public void user_enters_invalid_credentials_userid_as_admin1_and_password_as_click_on_login_button(String uid, String pwd) {
    
	pm.getLoginPage().login(uid,pwd);
    
}


@Then("validate dropdown exist")
public void validate_dropdown_exist() {
	pm.getLoginPage().checkThemeDropDownExist();
    }
@Then("default selection should be {string}")
public void default_selection_should_be(String string) {
	
	pm.getLoginPage().verifyDefaultThemeValue(string);
    }
@Then("there should be {int} values as {string}")
public void there_should_be_values_as(String string) {
	
	pm.getLoginPage().verifyAllOptionValues(string);
    
}






}
