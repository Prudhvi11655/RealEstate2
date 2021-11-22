Feature: Application login

Background: Verify login with valid credentials
Given Initialize the browser with chrome
And Navigate to  "http://realty-real-estatem1.upskills.in/my-profile/" site
And Click on Login link in home page to land on Secure sign in Page
When I entered mohankrishna176@gmail.com  and Secret@123&&  logs in
Then Click on signin button


Scenario: verify working functionality of Comments
Given user get the Dashboard
When user click on  the Comments icon
Then user get few options
And each option should be available
And close browser

Scenario Outline: Verify the working functionality of serch box
When user click on  the Comments icon
Then click on search box
And enter <userId>
And click on search comment
And shows user comment
And close browser

Examples:
|userId|
|Bhavana samudrala|

Scenario: Verify dropdown functionality
When user click on  the Comments icon
And click on dropdown button
Then select option
And click on filter
And close browser

Scenario: Verify the reply functionality of comments section
When user click on  the Comments icon
When user hover to reply option
And click on reply button
Then user enter any text in the comment box
And click on send


 
 
 
 
  
