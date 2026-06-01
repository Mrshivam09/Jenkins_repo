@Smoke
Feature: Verify Tutorials Ninja Functionality

Background:
Given user opens Tutorials Ninja website

@RegisterLogin
Scenario: Verify Registration and Login Functionality

When user clicks on My Account
And user clicks on Register option
And user enters first name "Shivam"
And user enters last name "Pal"
And user enters register email "dummy"
And user enters telephone "9876543210"
And user enters register password "test123"
And user confirms password "test123"
And user selects privacy policy
And user clicks on Continue button
Then account should create successfully

When user clicks on My Account
And user clicks on Logout option

And user clicks on My Account
And user clicks on Login option
And user enters email "dummy"
And user enters password "test123"
And user clicks on Login button
Then user should login successfully

@Search
Scenario Outline: Verify Product Search

When user searches product "<product>"
And user clicks on search button
Then searched product should display

Examples:
| product |
| iPhone  |
| MacBook |