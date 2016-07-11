Invite new tradeo.com users

Narrative:
In order to share Tradeo website with friends
As a current website user
I want to send invitations to people I choose
					 
Scenario:  Send invitation from LeftNav menu
Given I'm logged in website
When I choose InviteFriend option from LeftNav menu
Then the InviteFriend form displays
When I submit form with valid data
Then SuccessfulOperation popup is displayed and autohidden
					 
Scenario:  Send invitation from MyAccount page banner
Given I'm logged in
When I tap on InviteFriend banner in MyAccount page
Then the InviteFriend form displays into new tab
When I submit form with valid data
Then SuccessfulOperation popup is displayed and autohidden
