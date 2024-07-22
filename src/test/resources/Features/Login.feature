Feature: Login Functionality

Background:
Given User should be on login page

@login1
Scenario: valid_login_TC01
 When  user enters valid credentials and click on login button
Then  user should be navigated to home page
And  user can validate logout link

@invalidlogin
Scenario: Invalid_login_TC02
When  user enters Invalid credentials and click on login button
Then  user should be navigated to login page
And  user can validate error message
 
 @check
Scenario Outline: Invalid login with DataSet
When  user enters Invalid credentials user id as "<userid>"and password as "<password>" click on login button
Then  user should be navigated to login page
And  user can validate error message
Examples:
|userid |password|
|admin1 |pw1|
|admin2|pw2|
|admin3|pw3|


@DropDown
Scenario Outline: Validate_login_theme_dropdown_TC05
Then  validate dropdown exist 
And   default selection should be "<Default_value>"
And  there should be 4 values as "<options>"
Examples:
|Default_value|options|
|blue          |Aqua,blue,nature,orange|