Feature: Login feature of LTC Digital Storefront 

@Login
Scenario Outline: LTCDigitalStorefront_LoginPage_Validation

	Given user is on Login Page and user fills  "<username>" value in the username field
	Then user fills "<password>" value in the password field
	And user clicks login button
	Then user clicks logout button on Home Page
	
	Examples:
	|    username    | password  |
	|R21InsuredHenry | Temp@#123 |