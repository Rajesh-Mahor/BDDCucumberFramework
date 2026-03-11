Feature: New Login For NopCommerce

  Background:
    Given User opens the browser
    And User enters URL as "https://admin-demo.nopcommerce.com/login"
	
  @smoke
  Scenario Outline: Successful login with valid credentials
	When User enters Email as "<email>" and Password as "<password>"
    And User clicks on Login button   
    Then User navigates to Dashboard Page
    And User closes the browser

  Examples:
    | email               | password |
    | admin@yourstore.com | admin    |