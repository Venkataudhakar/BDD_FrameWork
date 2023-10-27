Feature: Logint to ActiTime Application

@Sample
Scenario: Login to ActiTime application using valid credentials

	Given user to launch the browser 
	And launch the application "https://demo.actitime.com/login.do"
	When user enters the valid username "admin"
	And user enters the valida password "manager"
	And click on Submit button
	Then navigate to application home page when user clicks on Submit button
	And  user to click on LogOut button to signout from the application


