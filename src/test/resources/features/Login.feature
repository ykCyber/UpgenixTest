Feature: Upgenix login feature
  User Story:
  As a user, I should be able to log in to different accounts; so that I can land on homepage.

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given user is on the Upgenix login page

  @BRT-285
  Scenario Outline: Verify that users can log in with valid credentials
  Positive login scenario

    When "<User>" enters valid "<Username>" and valid "<Password>"
    And user clicks to "login" button
    Then user should see the title is "#Inbox - Odoo"

    Examples:

      | User         | Username                | Password     |
      | PosManager   | posmanager70@info.com   | posmanager   |
      | SalesManager | salesmanager90@info.com | salesmanager |

  @BRT-286
  Scenario Outline: Verify that "Wrong login/password" should be displayed for invalid credentials
  Negative login scenario

    When "<User>" enters "<Username>" and "<Password>"
    And user clicks to "login" button
    Then user should see "Wrong login/password" displayed

    Examples:

      | User         | Username                | Password     |
      | PosManager   | posmanager70@info.com   | pos&         |
      | SalesManager | salesmanager90@info.com | %-manager    |
      | PosManager   | posmanager%info.com     | posmanager   |
      | SalesManager | salesmanager90.info     | salesmanager |
      | PosManager   | posmanager&12           | 43*&         |
      | SalesManager | salesmanager90          | sales1/      |

  @BRT-287
  Scenario Outline: Verify that "Please fill out this field" message should be displayed if the password or username is empty
  Negative login scenario for empty username and valid password

    When "<User>" enters valid "<Password>"
    And user clicks to "login" button
    Then user should see "Please fill out this field" message displayed

    Examples:

      | User         | Password     |
      | PosManager   | posmanager   |
      | SalesManager | salesmanager |

  @BRT-287
  Scenario Outline: Verify that "Please fill out this field" message should be displayed if the password or username is empty
  Negative login scenario for valid username and empty password

    When "<User>" enters valid "<Username>"
    And user clicks to "login" button
    Then user should see "Wrong login/password" message displayed

    Examples:

      | User         | Username                |
      | PosManager   | posmanager70@info.com   |
      | SalesManager | salesmanager90@info.com |
