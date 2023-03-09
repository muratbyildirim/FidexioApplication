@FIX10-236
Feature: Fidexio apllication Log out Functionality

  Background: User is already loged in
    When user is on the login page
    Then user enters credentials and click the login button
      | email    | posmanager15@info.com |
      | password | posmanager            |

  @FIX10-297
  Scenario:  Verify user can log out and ends up in login page.
    When user click the profile dropdown located top right corner
    And user click the log out link
    Then user end up on login page
      | title | Login |

  @FIX10-298
  Scenario: Verify user can not back home page by clicking  step back button.
    When user click the profile dropdown located top right corner
    And user click the log out link
    And user end up on login page
      | title | Login |
    And user click the step back button
    Then user should display Session expired alert


