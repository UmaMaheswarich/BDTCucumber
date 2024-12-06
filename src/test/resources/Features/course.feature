#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: BITC Course page

Scenario Outline:
: User should able to select the required course

Given user is already on login page
When user click on the course menu
Then user should able to select the required "<course>"
Then user should navigate to the particular course "<expected_url>"
And user should try to enroll the course 

Examples:
|course| expected_url | status
|ASP.NET MVC Online Training (Legacy) |https://www.bestitcourses.com/courses/asp-net-mvc-online-training| 
|ASP.NET WebForms (Legacy)  |https://www.bestitcourses.com/courses/asp-dot-net-online-training| 



      
      
      
