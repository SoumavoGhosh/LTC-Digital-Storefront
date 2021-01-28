Feature: Payment Transaction using Credit Card

@Positive
Scenario: Successful Payment Transaction Using Credit Card

	Given user has launched browser and navigated to url
	When user clicks on Buy Now button
	Then user sees an auto generated form and clicks on Checkout button 
	Then user verifies header as "COCO STORE"
	And user verifies header as "Order Summary"
	And user verifies label as "amount"
	And user verifies amount value as "20,000"
	And user verifies header as "order details"
	And user verifies header as "shipping details"
	Then user validates the below table and its contents
	Then user clicks on Continue button
	When user chooses mode of payment as Credit/Debit Card
	Then user provides card number as "4811111111111114"
	Then user provides card expiry as "12/24"
	Then user provides card cvv as "123"
	And  user clicks on Pay Now button
	Then user provides bank password as "112233"
	Then user clicks on OK button
	And  user validates successful transaction 

	
	
@Negative	
Scenario: Un-Successful Payment Transaction Using Faulty Credit Card

	Given user has launched browser and navigated to url
	When user clicks on Buy Now button
	Then user sees an auto generated form and clicks on Checkout button 
	Then user verifies header as "COCO STORE"
	And user verifies header as "Order Summary"
	And user verifies label as "amount"
	And user verifies amount value as "20,000"
	And user verifies header as "order details"
	And user verifies header as "shipping details"
	Then user validates the below table and its contents
	Then user clicks on Continue button
	When user chooses mode of payment as Credit/Debit Card
	Then user provides card number as "4911111111111113"
	Then user provides card expiry as "12/24"
	Then user provides card cvv as "123"
	And  user clicks on Pay Now button
	Then user provides bank password as "112233"
	Then user clicks on OK button
	And  user validates unsuccessful transaction 
