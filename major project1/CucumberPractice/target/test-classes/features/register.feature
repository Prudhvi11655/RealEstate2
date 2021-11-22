Feature: Singup Application


Scenario: Register new user
Given Initialize the browser with chrome
And Navigate to  "http://realty-real-estatem1.upskills.in/my-profile/" site
And Click on Regiter link in home page to land on Secure signup Page
When entered suneelv8109r39@gmail.com and prudhvi and varre
Then click on Register button
And getting text


Scenario: Verify login with invalid credentials
Given Initialize the browser with chrome
And Navigate to  "http://realty-real-estatem1.upskills.in/my-profile/" site
And Click on Login link in home page to land on Secure sign in Page
When I entered prudhvi@gmail.com  and SecrS23&&  logs in
Then Click on signin button
And close browser