@regression
Feature: Login Functionality 



@lead
Scenario: Create_multiple_leads_TC04
Given  User should be on login page
When  user enters valid credentials and click on login button
And  once user create lead 
|lastname|company|
|Dhoni1|HCL1|
|Dhoni2|HCL2|
|Dhoni3|HCL3|
Then lead should be created successfully
And user click on logout


@excel
Scenario: Create_leads_TC03
Given  User should be on login page
When  user enters valid credentials and click on login button
And  once user create lead with mandatory fields
Then lead should be created successfully
And user click on logout
 