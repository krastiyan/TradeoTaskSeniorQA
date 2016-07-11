Sign up new user of tradeo.com

Narrative:
In order to be able to use full tradeo.com functionality
As a visitor, who is not registered user yet
I want to sign up as new user
					 
Scenario:  User signs up via Homepage's quick sign up form
Given Website Homepage displayed
When I navigate to sign up form
And submit form with valid data in all requested fields
Then new user account is created for me
And I get redirected to MyAccount page
And I receive set of user welcome e-mails to provided address
