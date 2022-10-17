Feature: Login mopCommerce

  @sanity
  Scenario: Successful login with valid credential 
    Given User launch the browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login 
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page title should be "Your store. Login"
    And close browser   