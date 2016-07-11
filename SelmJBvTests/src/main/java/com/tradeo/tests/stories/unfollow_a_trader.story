Unfollowing a trader

Narrative:
In order to stop getting notifications from a folowed trader
As a good enough website user
I want to unfollow that trader
					 
Scenario:  Unfollowoing trader from own account page
Given I'm logged in website
And MyAccount page is displayed
And I'm following at least 1 trader(s)
When I open Following MyAccount section
And Traders I follow get listed
And I tap on UnfollowTrader button for user 1 in list
Then SuccessfulOperation popup is displayed and autohidden 

Scenario:  Unfollow a trader from own account after search
Given I'm logged in website
When I choose Traders option from LeftNav menu
Then TradersList page is displayed
When I search for trader Tradeo Support via SearchForTrader field
Then users found by search criteria get displayed
When I tap on UnfollowTrader button for user 1 having UnfollowTrader button displayed in SearchResults list
Then SuccessfulOperation popup is displayed and autohidden 
					 
Scenario:  Unfollowoing trader from trader's account page
Given I'm logged in website
And MyAccount page is displayed
When I open Following MyAccount section
And I tap on trader account name for user 1 in list
Then chosen trader's account is displayed
When I tap on UnfollowTrader button in TraderAccount page
Then SuccessfulOperation popup is displayed and autohidden 
