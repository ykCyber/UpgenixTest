Feature: Upgenix logout feature
	User Story :
	As a user, I should be able to log out.

	Users are : SalesManager, PosManager.

	Background: For the scenarios in the feature file, user is expected to be on the home page
		Given user is on the Upgenix home page

	@BRT-318
	Scenario: Verify that users can log out and ends up in login page
		When user clicks to "profile" icon
		And user clicks to "logout" dropdown
		Then user should see the title is "Login | Best solution for startups"

	@BRT-319
	Scenario: Verify that users can not go to the home page again by clicking the step back button
		When user clicks to "profile" icon
		And user clicks to "logout" dropdown
		And user should see the title is "Login | Best solution for startups"
		And user clicks to "step back" button
		Then user should see "Odoo Session Expired" message displayed

