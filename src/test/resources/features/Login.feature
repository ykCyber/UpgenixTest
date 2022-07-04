Feature: Upgenix login feature
  User Story:
  As a user, I should be able to log in to different accounts; so that I can land on homepage.

  Users are : SalesManager, PosManager.

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given user is on the Upgenix login page

  @BRT-285
  Scenario Outline: Verify that users can log in with valid credentials
  Positive login scenario

    When user enters valid "<Username>" and valid "<Password>"
    And user clicks to "login" button
    Then user should see the title is "Odoo"

    Examples:

      | Username                | Password     |
      | posmanager70@info.com   | posmanager   |
      | salesmanager90@info.com | salesmanager |

  @BRT-286
  Scenario Outline: Verify that "Wrong login/password" should be displayed for invalid credentials
  Negative login scenario

    When user enters "<Username>" and "<Password>"
    And user clicks to "login" button
    Then user should see "Wrong login/password" message displayed

    Examples:

      | Username                | Password     |
      | posmanager70@info.com   | pos&         |
      | salesmanager90@info.com | %-manager    |
      | posmanager%info.com     | posmanager   |
      | salesmanager90.info     | salesmanager |
      | posmanager&12           | 43*&         |
      | salesmanager90          | sales1/      |

  @BRT-287
  Scenario Outline: Verify that "Please fill out this field" message should be displayed if the password or username is empty
  Negative login scenario for empty username and valid password

    When user enters "<Username>" or "<Password>"
    And user clicks to "login" button
    Then error message is displayed

    Examples:

      | Username                | Password     |
      |                         | posmanager   |
      |                         | salesmanager |
      | posmanager70@info.com   |              |
      | salesmanager90@info.com |              |

  @BRT-302
  Scenario: Verify that users land on the 'reset password' page after clicking on the "Reset password" link

    When user clicks "Reset password" link
    Then user should see the title is "Reset password | Best solution for startups"

  @BRT-303
  Scenario: Verify that users should see the password in bullet signs by default

    When user enters password, user should see the password in bullet signs by default

  @BRT-304
  Scenario Outline:  Verify that the 'Enter' key of the keyboard is working correctly on the login page
    When user enters valid "<Username>" and valid "<Password>" and press Enter key
    Then user should see the title is "Odoo"

    Examples:

      | Username                | Password     |
      | posmanager70@info.com   | posmanager   |
      | salesmanager90@info.com | salesmanager |






