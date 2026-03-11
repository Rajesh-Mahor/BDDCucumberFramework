Feature: Login Functionality For NopCommerce Application

Background:     <!-- For Commen Step For All Scenarios -->

Given User Open Browser
And User Enter url As "https://admin-demo.nopcommerce.com/login".
When User Enter Email As "admin@yourstore.com" 
And Password As "admin".
And user Click On Login Button.

@sanity
Scenario: Successful login
Then User Nevigate to Dashboard Page and Close Browser.

@regression
Scenario: Add New Customer
When User Click On Customer .
And user Click On Customer Menu Iteam.
And Click On Add New Button.
Then User Can View Add New Customer Page.
When User Enter Customer Info.
And Click n Save Buttom.
Then User View Confirmation Massage "The new customer has been added successfully."
And Close browser. 