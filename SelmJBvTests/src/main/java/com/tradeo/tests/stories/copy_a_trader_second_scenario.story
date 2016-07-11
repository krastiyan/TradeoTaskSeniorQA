Secons scenario for Copy a trader

Narrative:
In order to automate my trading
As a user with INsufficient funds in account
I want to copy chosen trader activities
					 
					 
Scenario:  Copying found trader while with insufficient account balance
Given I'm logged in website
And My account balance is 0
When I choose Traders option from LeftNav menu
Then TradersList page is displayed
When I search for trader Tradeo Support via SearchForTrader field
Then users found by search criteria get displayed
When I tap on trader account name for user 1 in list
Then chosen trader's account is displayed
When I tap on CopyAccount button in TraderAccount page
Then CopyTrader form is displayed
And notification for insufficient balance is displayed
