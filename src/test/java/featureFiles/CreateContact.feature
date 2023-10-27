Feature: Create contact on vTiger application

@CreateContact
Scenario Outline: Create new contact on vTiger application
	Given user to launch the browser and launch the application with valid URL "<url>"
	And enter the valid user name "<userName>" and pass word "<passWord>" and click on Login button 
	When user click on Contacts link and click on Create Contact lookup image
	Then enter last name "<lastName>" in Last Name field and select valid Lead Source "<leadSource>" from drop down list and click on Save button
	And validate the Contact Info and click on logout button

Examples:
	|             url           | userName | passWord | lastName | leadSource |
	|   http://localhost:8888/  |    admin |    admin |  Veeeeem | Cold Call  |
	
	
