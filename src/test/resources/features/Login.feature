@FIX10-249
Feature: Fidexio application login functionality

  Background: User should access the login page
    Given user is on the login page

  @FIX10-290
  Scenario Outline: Verify user should be able to login(PosManager, SalesManager)
    When "<user>" enter username "<username>" and password "<password>"
    And user click on login button
    Then user should see discuss page "<title>"

    Examples:
      | user         | username                | password     | title         |
      | posmanager   | posmanager15@info.com   | posmanager   | #Inbox - Odoo |
      | posmanager   | posmanager16@info.com   | posmanager   | #Inbox - Odoo |
      | salesmanager | salesmanager15@info.com | salesmanager | #Inbox - Odoo |
      | salesmanager | salesmanager16@info.com | salesmanager | #Inbox - Odoo |

  @FIX10-291
  Scenario Outline: Verify "Wrong login/password" should be displayed for invalid credentials.
    When "<user>" enter username "<username>" and password "<password>"
    And user click on login button
    Then user should display "<errorMessage>" error message
    Examples:
      | user         | username              | password   | errorMessage         |
      | posmanager   | posmanager15@info.com | invalid    | Wrong login/password |
      | posmanager   | invalid@info.com      | posmanager | Wrong login/password |
      | salesmanager | invalid@info.com      | invalid    | Wrong login/password |

  @FIX10-292
  Scenario:Verify field message should be displayed if the password or username is empty
   # Then input weblements "required" attribute values should be "true"
    Then user should see the "Please fill out this field." message

  @FIX10-293
  Scenario: Verify user should see the password in bullet signs by default
    #Then password input weblement "type" attribute values should be "password"
    Then User should see the password in bullet signs

  @FIX10-294
  Scenario Outline:Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When "<user>" enter username "<username>" and password "<password>"
    And user press enter on keyboard
    Then user should see discuss page "<title>"


    Examples:
      | user         | username                | password     | title         |
      | posmanager   | posmanager15@info.com   | posmanager   | #Inbox - Odoo |
      | posmanager   | posmanager16@info.com   | posmanager   | #Inbox - Odoo |
      | salesmanager | salesmanager15@info.com | salesmanager | #Inbox - Odoo |
      | salesmanager | salesmanager16@info.com | salesmanager | #Inbox - Odoo |
