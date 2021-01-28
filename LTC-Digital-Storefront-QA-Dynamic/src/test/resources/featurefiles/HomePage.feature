Feature: Home feature of LTC Digital Storefront 

@Home
Scenario Outline: LTCDigitalStorefront_HomePage_Validation

	Given user is on Login Page and user fills  "<username>" value in the username field
	Then user fills "<password>" value in the password field
	And user clicks login button
	Then user lands on Home page and sees "<policy_number>" 
	And user sees "PRODUCT" field as expected 
	And user sees "POLICY_STATUS" field as expected
	And user sees "CLIENT_NAME" field as expected
	Then user sees and clicks on "<fullname>"
	Then user sees "Preferences" in the dropdown and selects it
	And user clicks logout button on Preferences Page
	
	Examples:
	|  username      | password  |           fullname                 |policy_number|
	|R21InsuredHenry | Temp@#123 |R15Insured_Henry R15Insured_Nicholls|   10000106  |