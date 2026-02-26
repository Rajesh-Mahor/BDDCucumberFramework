Feature:Login Functionality For NopCommerce Application

Scenario:Successful login
Given User Open Browser
And User Enter url As "https://admin-demo.nopcommerce.com/login".
When User Enter Email As "admin@yourstore.com" 
And Password As "admin".
And user Click On Login Button.
Then User Nevigate to Dashboard Page.