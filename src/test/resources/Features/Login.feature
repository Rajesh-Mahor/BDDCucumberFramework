Feature: Login For NopCommerce Application.

Background:     <!-- For Commen Step For All Scenarios -->

Given User Open Browser
And User Enter url As "https://admin-demo.nopcommerce.com/login".
When User Enter Email As "<Email>" 
And Password As "<Password>".
And user Click On Login Button.

Scenario Outline: Successful login
Then User Nevigate to Dashboard Page and Close Browser.

Scenario: Add New Customer
When User Click On Customer .
And user Click On Customer Menu Iteam.
And Click On Add New Button.
Then User Can View Add New Customer Page.
When User Enter Customer Info.
And Click n Save Buttom.
Then User View Confirmation Massage "The new customer has been added successfully."
And Close browser. 


Examples:
|Email|Password|
|admin@yourstore.com|admin|