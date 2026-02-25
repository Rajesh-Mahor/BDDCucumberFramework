Feature: Login Functionality
Scenario: Verify Login Page
Given Open browser
And Enter Application URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When User Enter Id As "Admin" and Password As "admin123"
And Click On Login Button
Then User Nevigate To Dashboard and Close browser



Scenario Outline: Verify Login Page for DDT
Given Open browser
And Enter Application URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When User Enter Id As "<id>" and Password As "<password>"
And Click On Login Button
Then User Nevigate To Dashboard and Close browser

Examples:

|id|password|
|Admin|admin123|