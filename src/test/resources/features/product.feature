Feature: Search a product feature
Background: User should able to get a link
#  Background: User has to login--> background will execute before every scenario
#    Given User is logged in

  Scenario: Verify that user is able to search product and able to click product in dropdown
    Given  the user navigates to the home page
    When the user can able to click on search bar
    Then the drop down appear
    And the user enter the product name
    Then the product results should be displayed

  Scenario: verify that user is able to search for desire product using multiple languages- negative testcase
    Given  the user navigates to the home page
    When the user enter the product name in marathi
    And The user is able to click on enter key
    Then the sorry message will be displayed
    And the user will able to click on Back To Home Page
    Then the Home Page should be display

  Scenario: verify that user is able to search for desire product with incomplete spelling of product
    Given  the user navigates to the home page
    When the user enter incomplete name of product
    Then the product results should be displayed for incomplete product name

  Scenario: verify that user is able to search for a product with special characters
    Given  the user navigates to the home page
    When the user enter the product name with special characters
    Then the product results should be displayed for special characters

 Scenario: verify that user can search product name that does not exist in the database, and verifying that no results are returned in web
    Given  the user navigates to the home page
    When the user enter the product name which is not in database
    Then the product results should not be display for it


  Scenario Outline: Verify that user is able to search for a product in UPPERCASE and lowercase
    Given the user navigates to the home page
    When  the user enter the "<productDescription>"
    Then the product will be displayed for both UPPERCASE and lowercase
    Examples:
          |productDescription|
          |      lipstick     |
          |      LIPSTICK     |