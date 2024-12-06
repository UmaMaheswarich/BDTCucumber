Feature: Feature to test login functionality

#Scenario: Validate Login functionality is working
#
#Given user to open the application 
#And Click on the Login menu
#When user provides valid email and password
#And click on the login button
#Then user should navigate to login page

Scenario: Validate Login functionality with following details

Given user to open the application 
And Click on the Login menu
When user provides following details
|umamaheswari@deccansoft.net|Umamaheswari@2023|Succesfully loggedin|
|umamaheswari@decansoft.net|Umamaheswari@2023|should not login|
And click on the login button
Then user should navigate to login page