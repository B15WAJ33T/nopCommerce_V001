Feature: Customer
  Background: Below ar ethe common steps for every scenario
    Given User launch the browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"

  @sanity
  Scenario: Add a new customer
    When User click on Customers menu
    And Click on Customers menu item
    And Click on Add New button
    Then User can view Add a new customer page "Add a new customer / nopCommerce administration"
    When User enters customer info
    And Click on Save button
    Then User can view confermation message "The new customer has been added successfully."
    And close browser

  @regression
  Scenario: Search customer by email id
    When User click on Customers menu
    And Click on Customers menu item
    And Enter customer Email
    When Click on search button
    Then User should find email in the search table
    And close browser
   
