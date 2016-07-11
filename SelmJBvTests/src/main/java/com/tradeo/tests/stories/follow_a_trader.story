Following a trader

Narrative:
In order to be able to learn how to trade well in tradeo.com
As a new website user
I want to follow experienced traders that are doing good
					 
Scenario:  Follow a trader from own account after search
Given I'm logged in website
When I choose Traders option from LeftNav menu
Then TradersList page is displayed
When I search for trader Andrew via SearchForTrader field
Then users found by search criteria get displayed
When I tap on FollowTrader button for user 1 in SearchResults list
Then SuccessfulOperation popup is displayed and autohidden 
					 
Scenario:  Followoing trader from trader's account page
Given I'm logged in website
When I choose Traders option from LeftNav menu
Then TradersList page is displayed
When I tap on trader account name for user 1 in list
Then chosen trader's account is displayed
When I tap on FollowTrader button in TraderAccount page
Then SuccessfulOperation popup is displayed and autohidden 
