package com.vtiger.stepdefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadSteps extends BaseClassForDriver{

	
	

@When("once user create lead")
public void once_user_create_lead(io.cucumber.datatable.DataTable dataTable) {
    
	
	List <Map <String ,String>>ls =dataTable.asMaps();
	
	for(Map<String,String> m:ls)
	{
	pm.getLeadPage().clickNewLead();
	pm.getLeadPage().createLeadWithMandatoryFields(m.get("lastname"), m.get("company"));
		
		}
}
@Then("lead should be created successfully")
public void lead_should_be_created_successfully() {
    
}
@Then("user click on logout")
public void user_click_on_logout() {
	pm.getLeadPage().clickLogout();
    
}

@When("once user create lead with mandatory fields")
public void once_user_create_lead_with_mandatory_fields() {

	pm.getLeadPage().clickNewLead();
    
	pm.getLeadPage().createLeadWithMandatoryFields(dt.get(TCName).get("LastName"), dt.get(TCName).get("Company"));
}

}
