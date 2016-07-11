Copy a trader

Narrative:
In order to automate my trading
As a user with INsufficient funds in account
I want to copy chosen trader activities
					 
Scenario:  Copying followed trader while with insufficient account balance
Given I'm logged in website
And MyAccount page is displayed
And I'm following at least 1 trader(s)
When I open MyAccount_Following section
And Traders I follow get listed
When I tap on trader account name for user 1 in list
Then chosen trader's account is displayed
When I tap on CopyAccount button in TraderAccount page
Then CopyTrader form is displayed
And notification for insufficient balance is displayed
