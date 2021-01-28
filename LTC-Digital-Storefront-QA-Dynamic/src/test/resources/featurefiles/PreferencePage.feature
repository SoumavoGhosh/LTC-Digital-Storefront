Feature: Preference feature of LTC Digital Storefront 

@Preference
Scenario Outline: LTCDigitalStorefront_PreferencePage_Validation

	Given user is on Login Page and user fills  "<username>" value in the username field
	Then user fills "<password>" value in the password field
	And user clicks login button
	Then user sees and clicks on "<fullname>"
	Then user sees "Preferences" in the dropdown and selects it
	Then user lands on preferences page and sees page header as "My communication preferences"
	And  user verifies preferences page body and contents
	When user selects Text message option
	And user selects Email option
	And user clicks Save button
	Then user sees an "Acknowledgement" pop up 
	And user verifies the header and content of the popup
	Then user selects the acknowledgment agreement confirmation option
	Then user clicks on the confirm button 
	Then user verifies "Preferences saved" message
	And user clicks logout button on Preferences Page
	
	
		Examples:
	|    username    | password  |           fullname                 |
	|R21InsuredHenry | Temp@#123 |R15Insured_Henry R15Insured_Nicholls|